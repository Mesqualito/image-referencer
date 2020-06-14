package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.RefType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefTypeRepository extends CrudRepository<RefType, String> {

    Optional<RefType> findByTypeName(String name);
}
