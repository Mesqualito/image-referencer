package com.eigenbaumarkt.cp2db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@NoArgsConstructor
@Data
@Document(collection="references")
public class Reference {

    @Id
    private String id;
    @Field
    private String refName;
    @Field
    private String refValue;
    @DBRef
    private Set<RefType> referenceTypes;

    public Reference(String refName, String refValue) {
        this.refName = refName;
        this.refValue = refValue;
    }
}
