package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.Reference;
import org.springframework.data.repository.CrudRepository;

public interface ReferenceRepository extends CrudRepository<Reference, String> {
}
