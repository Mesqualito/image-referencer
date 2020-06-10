package com.eigenbaumarkt.cp2db.controller;


import com.eigenbaumarkt.cp2db.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private ImageService imageService;

    public IndexController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping({"/", "index", "index.htm", "index.html"})
    public String getIndex(Model model) {

        model.addAttribute("images", imageService.listImages());

        return "index";
    }

}
