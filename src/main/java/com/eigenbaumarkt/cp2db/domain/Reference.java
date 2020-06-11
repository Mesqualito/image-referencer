package com.eigenbaumarkt.cp2db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Data
public class Reference {

    @Id
    private String id;
    @Field
    private String refName;
    @Field
    private String refValue;
    @DBRef
    private RefType referenceType;

    public Reference(String refName, String refValue) {
        this.refName = refName;
        this.refValue = refValue;
    }
}
