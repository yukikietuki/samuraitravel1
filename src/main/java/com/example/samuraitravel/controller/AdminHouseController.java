package com.example.samuraitravel.controller;


import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.repository.HouseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/admin/houses")
public class AdminHouseController {
    private final HouseRepository houseRepository;

    public AdminHouseController(HouseRepository houseRepository){
        this.houseRepository = houseRepository;
    }

    @GetMapping
    public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<House> housePage = houseRepository.findAll(pageable);
        model.addAttribute("housePage", housePage);
        return "admin/houses/index";

    }
}
