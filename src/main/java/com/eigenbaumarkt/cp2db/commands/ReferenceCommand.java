package com.eigenbaumarkt.cp2db.commands;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class ReferenceCommand {

    private String id;
    private String refName;
    private String refValue;
    private Set<RefTypeCommand> refTypes;


}
