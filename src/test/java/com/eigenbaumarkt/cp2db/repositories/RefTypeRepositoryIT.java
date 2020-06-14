package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.RefType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class RefTypeRepositoryIT {

    @Autowired
    RefTypeRepository refTypeRepository;

    @Test
    @DirtiesContext // will reload Spring Context
    public void findByTypeNameGtin() {

        Optional<RefType> refTypeOptional = refTypeRepository.findByTypeName("GTIN");
        assertEquals("GTIN", refTypeOptional.get().getTypeName());
    }

    @Test
    public void findByTypeNameIptc() {

        Optional<RefType> refTypeOptional = refTypeRepository.findByTypeName("IPTC");
        assertEquals("IPTC", refTypeOptional.get().getTypeName());
    }
}
