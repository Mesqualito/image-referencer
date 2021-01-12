package com.eigenbaumarkt.cp2db.controller;

import com.eigenbaumarkt.cp2db.commands.TargetCommand;
import com.eigenbaumarkt.cp2db.services.TargetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class TargetController {

    private final TargetService targetService;

    public TargetController(TargetService targetService) {
        this.targetService = targetService;
    }

    @GetMapping("/target/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("target", targetService.findById(id));

        return "target/show";
    }

    @GetMapping("target/new")
    public String newTarget(Model model) {
        model.addAttribute("target", new TargetCommand());

        return "target/targetform";
    }

    @GetMapping("target/{id}/update")
    public String updateTarget(@PathVariable String id, Model model){
        model.addAttribute("target", targetService.findCommandById(id));

        return "target/targetform";
    }

    @PostMapping("target")
    public String saveOrUpdate(@ModelAttribute TargetCommand command) {
        TargetCommand savedCommand = targetService.saveTargetCommand(command);

        return "redirect:/target/" + savedCommand.getId() + "/show";
    }

    @GetMapping("target/{id}/delete")
    public String deleteById(@PathVariable String id) {
        log.debug("Deleting id: " + id);

        targetService.deleteById(id);
        return "redirect:/";
    }
}
