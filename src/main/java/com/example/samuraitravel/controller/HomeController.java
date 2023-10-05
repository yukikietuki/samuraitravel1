package com.example.samuraitravel.controller;

import java.util.List;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.entity.House;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HomeController {
    private final HouseRepository houseRepository;

    public HomeController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }
    @GetMapping("/")
    public String index(Model model) {
        List<House> newHouses = houseRepository.findTop10ByOrderByCreatedAtDesc();
        model.addAttribute("newHouses", newHouses);
        return "index";
    }
}
