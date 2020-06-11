package com.eigenbaumarkt.cp2db.services;

import com.eigenbaumarkt.cp2db.commands.ReferenceCommand;

public interface ReferenceService {

    ReferenceCommand findByTargetIdAndReferenceId(String targetId, String referenceId);
    ReferenceCommand saveReferenceCommand(ReferenceCommand command);
    void deleteById(String targetId, String referenceId);

}
