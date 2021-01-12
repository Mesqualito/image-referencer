package com.eigenbaumarkt.cp2db.domain;

import com.eigenbaumarkt.cp2db.repositories.RefTypeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Optional;

@Getter
@Setter
@Document(collection="gtins")
public class GtinRef implements Reference {

    private final RefTypeRepository refTypeRepository;

    @Id
    private String id;

    // will be refType.typeName here:
    @Field
    private String refName;

    // TODO: GTIN-Nr. should be controlled (last number, algorithm...)
    @Field
    private String refValue;

    @Field
    private RefType referenceType;

    @Field
    private Instant savedAt;

    public GtinRef(RefTypeRepository refTypeRepository) {
        this.refTypeRepository = refTypeRepository;
        setReferenceType();
    }

    public void setReferenceType() {
        Optional<RefType> refTypeGtin = refTypeRepository.findByTypeName("GTIN");
        if(!refTypeGtin.isPresent()) {
            throw new RuntimeException("Expected ReferenceType \'GTIN\' not found!");
        }
    }
}
