package com.eigenbaumarkt.cp2db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Set;

@NoArgsConstructor
@Data
@Document(collection="images")
public class Image {

    @Id
    private String id;
    @Field
    private String description;
    @Field
    private Instant savedAt;
    @DBRef
    private Set<Reference> references;

    public Image(String description, Instant savedAt) {
        this.description = description;
        this.savedAt = savedAt;
    }
}
