package com.eigenbaumarkt.cp2db.commands;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ImageCommand {

    @NotEmpty
    @Size(min = 3, max = 200)
    private String description;

    @NotEmpty
    @Size(min = 6, max = 500)
    private String imgPath;

}
