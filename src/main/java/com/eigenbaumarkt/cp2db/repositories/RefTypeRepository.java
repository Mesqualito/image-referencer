package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.RefType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RefTypeRepository extends MongoRepository<RefType, String> {

    Optional<RefType> findByTypeName(String name);
}
