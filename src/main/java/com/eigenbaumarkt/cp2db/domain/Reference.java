package com.eigenbaumarkt.cp2db.domain;

import java.time.Instant;

public interface Reference {

    String getId();
    RefType getRefType();
    String getRefValue();
    Instant getSavedAt();

    void setRefType(RefType refType);
    void setRefValue(String refValue);
    void setSavedAt(Instant timestamp);

}
