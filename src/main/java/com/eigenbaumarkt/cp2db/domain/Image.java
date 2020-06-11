package com.eigenbaumarkt.cp2db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

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
    @Field
    private Byte[] image;

    public Image(String description, Instant savedAt) {
        this.description = description;
        this.savedAt = savedAt;
    }
}
