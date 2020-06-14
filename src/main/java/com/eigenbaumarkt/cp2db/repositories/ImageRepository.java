package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.ImageRef;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<ImageRef, String> {
}
