package com.example.musikdata.Model;

public class Musik {
    private int id;
    private String artistName;
    private String genre;
    private String albumName;
    private int albumYear;

    public Musik() {
    }

    public Musik(String artistName, String genre, String albumName, int albumYear) {
        this.artistName = artistName;
        this.genre = genre;
        this.albumName = albumName;
        this.albumYear = albumYear;
    }

    public Musik(int id, String artistName, String genre, String albumName, int albumYear) {
        this.id =id;
        this.artistName=artistName;
        this.genre = genre;
        this.albumName = albumName;
        this.albumYear = albumYear;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }

    @Override
    public String toString() {
        return "Musik{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", genre='" + genre + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumYear=" + albumYear +
                '}';
    }
}
