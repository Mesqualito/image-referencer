package com.eigenbaumarkt.cp2db.services.mongo;

import com.eigenbaumarkt.cp2db.commands.RefTypeCommand;
import com.eigenbaumarkt.cp2db.converter.RefTypeToRefTypeCommand;
import com.eigenbaumarkt.cp2db.repositories.RefTypeRepository;
import com.eigenbaumarkt.cp2db.services.RefTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RefTypeServiceImpl implements RefTypeService {

    private final RefTypeRepository refTypeRepository;
    private final RefTypeToRefTypeCommand command;

    public RefTypeServiceImpl(RefTypeRepository refTypeRepository, RefTypeToRefTypeCommand command) {
        this.refTypeRepository = refTypeRepository;
        this.command = command;
    }

    @Override
    public Set<RefTypeCommand> listAllRefTypes() {

        return StreamSupport.stream(refTypeRepository.findAll()
                .spliterator(), false)
                .map(command::convert)
                .collect(Collectors.toSet());
    }
}
