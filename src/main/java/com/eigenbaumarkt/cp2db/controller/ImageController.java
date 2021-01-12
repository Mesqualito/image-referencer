package com.eigenbaumarkt.cp2db.controller;


import com.eigenbaumarkt.cp2db.services.ImageService;
import com.eigenbaumarkt.cp2db.services.TargetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final TargetService targetService;


    public ImageController(ImageService imageService, TargetService targetService) {
        this.imageService = imageService;
        this.targetService = targetService;
    }

    @GetMapping("recipe/{targetId}/image")
    public String showUploadForm(@PathVariable String targetId, Model model) {

        model.addAttribute("target", targetService.findCommandById(targetId));

        return "target/imageuploadform";
    }

    @PostMapping("target/{targetId}/image")
    public String handleImagePost(@PathVariable String targetId, @RequestParam("imagefile") MultipartFile file) {

        imageService.saveImageFile(targetId, file);

        return "redirect:/target/" + targetId + "/show";

    }

    /*
    @GetMapping("target/{id}/targetimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {

        TargetCommand targetCommand = targetService.findCommandById(id);

        byte[] byteArray = new byte[targetCommand.getImage().length];

        int i = 0;
        for (Byte wrappedByte : targetCommand.getImage()) {
            byteArray[i++] = wrappedByte; // auto unboxing
        }

        response.setContentType("image/jpeg");
        InputStream inputStream = new ByteArrayInputStream(byteArray);
        IOUtils.copy(inputStream, response.getOutputStream());

    }

     */
}
