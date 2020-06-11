package com.eigenbaumarkt.cp2db.services;

import com.eigenbaumarkt.cp2db.commands.TargetCommand;
import com.eigenbaumarkt.cp2db.domain.Target;

import java.util.Set;

public interface TargetService {

    Set<Target> getTargets();
    Target findById(String id);
    TargetCommand findCommandById(String id);
    TargetCommand saveTargetCommand(TargetCommand command);
    void deleteById(String id);

}
