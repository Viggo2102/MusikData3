package com.example.musikdata.Controller;

import com.example.musikdata.Model.Musik;
import com.example.musikdata.Repository.MusikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    MusikRepository musikRepository;

    @GetMapping("/")
    public String seMusik(Model model) {
        List<Musik> musik = musikRepository.getAll();
        model.addAttribute("musiccs", musik);
        return "musik";
    }

    @GetMapping("/create")
    public String visCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String createSong(
            @RequestParam("name") String navn,
            @RequestParam("genre") String genre,
            @RequestParam("albumName") String albumName,
            @RequestParam("albumYear") int albumYear
    ) {
        Musik musik = new Musik(navn, genre, albumName, albumYear);
        musikRepository.create(musik);
        return "redirect:/";

    }
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") int deleteId) {
        //slet i Repository

        musikRepository.deleteById(deleteId);

        //redirect til liste
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int updateId, Model model) {
        //find musik i database

        Musik musik = musikRepository.findById(updateId);

        //tilføj musik til view model.
        model.addAttribute("mus", musik);

        //vis update-side
        return "update";
    }

    @PostMapping("update")
    public String updateMusic(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("genre") String genre,
            @RequestParam("albumName") String albumName,
            @RequestParam("albumYear") int albumYear
    ) {
        //lave en sang
        Musik musik = new Musik (id, name, genre, albumName, albumYear);

        //opdater repository
        musikRepository.update(musik);

        //vis liste

        return "redirect:/";
    }
}
