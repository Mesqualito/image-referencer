package com.eigenbaumarkt.cp2db.services;

import com.eigenbaumarkt.cp2db.commands.RefTypeCommand;

import java.util.Set;

public interface RefTypeService {

    Set<RefTypeCommand> listAllRefTypes();
}
