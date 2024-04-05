package com.example.musikdata.Repository;

import com.example.musikdata.Model.Musik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusikRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Musik> getAll() {
        String sql = "select * from musiktabel.musik";
        List<Musik> musikList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Musik.class));
        return musikList;
    }

    public void create(Musik musik) {
final String INSERT_SQL="INSERT INTO musik (artist_name, genre, album_name, album_year) VALUES (?,?,?,?)";
jdbcTemplate.update(INSERT_SQL, musik.getArtistName(), musik.getGenre(), musik.getAlbumName(), musik.getAlbumYear());

    }
    public void deleteById(int deleteId) {
        final String DELETE_BY_ID_SQL = "DELETE FROM musik WHERE id = ?";

        jdbcTemplate.update(DELETE_BY_ID_SQL, deleteId);
    }

    public Musik findById(int updateID) {
        //find SQL
        final String FIND_BY_ID_SQL = "SELECT * FROM musik WHERE id = ?";

        //definer rowmapper som omsætter databaserække til musik.
        RowMapper<Musik> rowmapper = new BeanPropertyRowMapper<>(Musik.class);

        //returner query.resultat fra jdbcTemplate
        return jdbcTemplate.queryForObject(FIND_BY_ID_SQL, rowmapper, updateID);
    }

    public void update(Musik musik) {
        //update sql
        final String UPDATE_SQL = "UPDATE musik SET artist_name = ?, genre = ?, album_name = ?, album_year = ? WHERE id = ?";

        jdbcTemplate.update(UPDATE_SQL, musik.getArtistName(), musik.getGenre(), musik.getAlbumName(), musik.getAlbumYear(), musik.getId());

    }
}
