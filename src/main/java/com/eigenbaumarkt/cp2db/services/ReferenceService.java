package com.eigenbaumarkt.cp2db.services;

public interface ReferenceService {

    ReferenceCommand findByTargetIdAndReferenceId(String targetId, String referenceId);
    ReferenceCommand saveReferenceCommand(ReferenceCommand command);
    void deleteById(String targetId, String referenceId);

}
