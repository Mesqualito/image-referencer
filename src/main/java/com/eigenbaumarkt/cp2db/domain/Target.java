package com.eigenbaumarkt.cp2db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@NoArgsConstructor
@Data
@Document(collection="targets")
public class Target {

    @Id
    private String id;

    @DBRef
    private Set<Image> images;

    @DBRef
    private Set<Reference> references;

}
