package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.RefType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class RefTypeRepositoryIT {

    @Autowired
    RefTypeRepository refTypeRepository;

    @Test
    public void findByTypeNames() {

        List<String> expectedRefTypes = Arrays.asList("GTIN", "Image", "NAV Artikelnr.", "Hersteller-Artikelnr.",
                "Lager-Barcode", "Sprache", "Debitoren-Nr.", "Kreditoren-Nr.", "IPTC");

        for (String refType : expectedRefTypes) {
            Optional<RefType> refTypeOptional = refTypeRepository.findByTypeName(refType);
            assertEquals(refType, refTypeOptional.get().getTypeName());
        }
    }
}
