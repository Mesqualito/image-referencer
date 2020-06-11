package com.eigenbaumarkt.cp2db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Document(collection="targets")
public class Target {

    @Id
    private String id;

    @Field
    private String description;

    @DBRef
    private Set<Image> images = new HashSet<>();

    @DBRef
    private Set<Reference> references = new HashSet<>();

    public Target addImage(Image image) {
        this.images.add(image);
        return this;
    }

    public Target addReference(Reference reference) {
        this.references.add(reference);
        return this;
    }


}
