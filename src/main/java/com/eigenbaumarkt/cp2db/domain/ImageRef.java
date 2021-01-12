package com.eigenbaumarkt.cp2db.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Getter
@Setter
@Document(collection="images")
public class ImageRef implements Reference {

    @Id
    private String id;
    @Field
    private RefType refType;
    @Field
    private String refValue;
    @Field
    private Instant savedAt;
    @Field
    private Byte[] image;
}
