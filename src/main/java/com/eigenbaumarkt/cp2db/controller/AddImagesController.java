package com.eigenbaumarkt.cp2db.controller;


import com.eigenbaumarkt.cp2db.commands.ImageCommand;
import com.eigenbaumarkt.cp2db.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AddImagesController {

    private ImageService imageService;

    public AddImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping("/addimages")
    public String checkoutForm(Model model) {

        model.addAttribute("imageCommand", new ImageCommand());
        return "addimages";
    }

    @RequestMapping(value = "/doaddimg", method = RequestMethod.POST)
    public String doCheckout(@Valid ImageCommand imageCommand, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "addimages";
        }

        return "addimgcomplete";
    };

}
