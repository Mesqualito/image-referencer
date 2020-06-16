package com.eigenbaumarkt.cp2db.commands;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TargetCommand {

    private String id;
    private String description;
    private Set<ReferenceCommand> references = new HashSet<>();
    private Set<ImageCommand> images = new HashSet<>();

}
