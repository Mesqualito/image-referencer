package com.eigenbaumarkt.cp2db.commands;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RefTypeCommand {

    private String id;
    private String typeName;
    private String typeValue;

}
