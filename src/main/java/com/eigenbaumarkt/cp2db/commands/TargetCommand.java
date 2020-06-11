package com.eigenbaumarkt.cp2db.commands;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class TargetCommand {

    private String id;
    private Byte[] image;
    private String description;
    private Set<ReferenceCommand> references = new HashSet<>();

}