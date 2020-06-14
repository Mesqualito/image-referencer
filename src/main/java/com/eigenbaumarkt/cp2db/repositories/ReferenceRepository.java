package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.Reference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReferenceRepository extends MongoRepository<Reference, String> {
}
