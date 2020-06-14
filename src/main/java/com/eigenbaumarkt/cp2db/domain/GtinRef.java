package com.eigenbaumarkt.cp2db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@NoArgsConstructor
@Data
@Document(collection="gtins")
public class GtinRef implements Reference {

    @Id
    private String id;

    // will be refType.typeName here:
    @Field
    private String refName;

    // TODO: GTIN-Nr. should be controlled (last number, algorithm...)
    @Field
    private String refValue;

    // TODO: ReferenceType should be refType.typeName.equals("GTIN")
    @Field
    private RefType referenceType;

    @Field
    private Instant savedAt;

}
