package com.eigenbaumarkt.cp2db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Data
@Document(collection="referencetypes")
public class RefType {

    @Id
    private String id;
    @Field
    private String typeName;
    @Field
    private String typeValue;

    public RefType(String typeName, String typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }
}
