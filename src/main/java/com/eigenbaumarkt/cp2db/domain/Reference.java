package com.eigenbaumarkt.cp2db.domain;

import java.time.Instant;

public interface Reference {

    String getId();
    String getRefName();
    String getRefValue();
    RefType getReferenceType();
    Instant getSavedAt();

    void setRefName(String refName);
    void setRefValue(String refValue);
    void setReferenceType(RefType refType);
    void setSavedAt(Instant timestamp);

}
