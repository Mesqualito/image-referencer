package com.eigenbaumarkt.cp2db.services.mongo;

import com.eigenbaumarkt.cp2db.commands.TargetCommand;
import com.eigenbaumarkt.cp2db.converter.TargetCommandToTarget;
import com.eigenbaumarkt.cp2db.converter.TargetToTargetCommand;
import com.eigenbaumarkt.cp2db.domain.Target;
import com.eigenbaumarkt.cp2db.repositories.TargetRepository;
import com.eigenbaumarkt.cp2db.services.TargetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class TargetServiceImpl implements TargetService {

    private final TargetRepository targetRepository;
    private final TargetCommandToTarget targetCommandToTarget;
    private final TargetToTargetCommand targetToTargetCommand;

    public TargetServiceImpl(TargetRepository targetRepository, TargetCommandToTarget targetCommandToTarget, TargetToTargetCommand targetToTargetCommand) {
        this.targetRepository = targetRepository;
        this.targetCommandToTarget = targetCommandToTarget;
        this.targetToTargetCommand = targetToTargetCommand;
    }

    @Override
    public Set<Target> getTargets() {
        return null;
    }

    @Override
    public Target findById(String id) {
        return null;
    }

    @Override
    public TargetCommand findCommandById(String id) {
        return null;
    }

    @Override
    public TargetCommand saveTargetCommand(TargetCommand command) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
