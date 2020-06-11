package com.eigenbaumarkt.cp2db.commands;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Data
public class ImageCommand {

    private String id;
    private Byte[] image;
    private String description;
    private Instant savedAt;
}
