package com.eigenbaumarkt.cp2db.commands;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReferenceCommand {

    private String id;
    private String refName;
    private String refValue;
    private RefTypeCommand refType;


}
