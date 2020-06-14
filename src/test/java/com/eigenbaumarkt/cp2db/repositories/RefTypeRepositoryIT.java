package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.RefType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class) // will load Spring Context
public class RefTypeRepositoryIT {


    @Autowired // will autowire an object of UnitOfMeasureRepository
            RefTypeRepository refTypeRepository;

    @Before
    public void setUp() throws Exception {
    }

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
