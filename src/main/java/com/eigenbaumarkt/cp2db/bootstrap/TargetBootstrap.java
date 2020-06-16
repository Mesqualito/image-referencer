package com.eigenbaumarkt.cp2db.bootstrap;

import com.eigenbaumarkt.cp2db.domain.ImageRef;
import com.eigenbaumarkt.cp2db.domain.RefType;
import com.eigenbaumarkt.cp2db.domain.Target;
import com.eigenbaumarkt.cp2db.repositories.ImageRepository;
import com.eigenbaumarkt.cp2db.repositories.RefTypeRepository;
import com.eigenbaumarkt.cp2db.repositories.TargetRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TargetBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final TargetRepository targetRepository;
    private final RefTypeRepository refTypeRepository;
    private final ImageRepository imageRepository;

    public TargetBootstrap(TargetRepository targetRepository, RefTypeRepository refTypeRepository,
                           ImageRepository imageRepository) {
        this.targetRepository = targetRepository;
        this.refTypeRepository = refTypeRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadReferenceTypes();
        targetRepository.saveAll(getTargets());
    }

    private void loadReferenceTypes() {

        RefType refTypeGtin = new RefType();
        refTypeGtin.setTypeName("GTIN");
        refTypeRepository.save(refTypeGtin);

        RefType refTypeImg = new RefType();
        refTypeImg.setTypeName("Bild");
        refTypeRepository.save(refTypeImg);

        RefType refTypeNavArtNr = new RefType();
        refTypeNavArtNr.setTypeName("NAV Artikelnr.");
        refTypeRepository.save(refTypeNavArtNr);

        RefType refTypeHerstArtNr = new RefType();
        refTypeHerstArtNr.setTypeName("Hersteller-Artikelnr.");
        refTypeRepository.save(refTypeHerstArtNr);

        RefType refTypeLagerBarCode = new RefType();
        refTypeLagerBarCode.setTypeName("Lager-Barcode");
        refTypeRepository.save(refTypeLagerBarCode);

        RefType refTypeLang = new RefType();
        refTypeLang.setTypeName("Sprache");
        refTypeRepository.save(refTypeLang);

        RefType refTypeNavDeb = new RefType();
        refTypeNavDeb.setTypeName("NAV Debitoren-Nr.");
        refTypeRepository.save(refTypeNavDeb);

        RefType refTypeNavKred = new RefType();
        refTypeNavKred.setTypeName("NAV Kreditoren-Nr.");
        refTypeRepository.save(refTypeNavKred);

        RefType refTypeIptc = new RefType();
        refTypeIptc.setTypeName("IPTC");
        refTypeRepository.save(refTypeIptc);
    }

    private List<Target> getTargets() {

        List<Target> targets = new ArrayList<>(2);

        List<String> expectedRefTypes = Arrays.asList("GTIN", "Bild", "NAV Artikelnr.", "Hersteller-Artikelnr.",
                "Lager-Barcode", "Sprache", "NAV Debitoren-Nr.", "NAV Kreditoren-Nr.", "IPTC");

        Optional<RefType> refTypeOptionalGtin = refTypeRepository.findByTypeName("GTIN");
        if (!refTypeOptionalGtin.isPresent()) {
            throw new RuntimeException("Reference-Type 'GTIN' not found!");
        }

        Optional<RefType> refTypeOptionalImg = refTypeRepository.findByTypeName("Bild");
        if (!refTypeOptionalImg.isPresent()) {
            throw new RuntimeException("Reference-Type 'Bild' not found!");
        }

        Optional<RefType> refTypeOptionalNavArtNr = refTypeRepository.findByTypeName("NAV Artikelnr.");
        if (!refTypeOptionalNavArtNr.isPresent()) {
            throw new RuntimeException("Reference-Type 'NAV Artikelnr.' not found!");
        }

        Optional<RefType> refTypeOptionalHerstArtNr = refTypeRepository.findByTypeName("Hersteller-Artikelnr.");
        if (!refTypeOptionalHerstArtNr.isPresent()) {
            throw new RuntimeException("Reference-Type 'Hersteller-Artikelnr.' not found!");
        }

        Optional<RefType> refTypeOptionalLagerBarCode = refTypeRepository.findByTypeName("Lager-Barcode");
        if (!refTypeOptionalLagerBarCode.isPresent()) {
            throw new RuntimeException("Reference-Type 'Lager-Barcode' not found!");
        }

        Optional<RefType> refTypeOptionalLang = refTypeRepository.findByTypeName("Sprache");
        if (!refTypeOptionalLang.isPresent()) {
            throw new RuntimeException("Reference-Type 'Sprache' not found!");
        }

        Optional<RefType> refTypeOptionalNavDeb = refTypeRepository.findByTypeName("NAV Debitoren-Nr.");
        if (!refTypeOptionalNavDeb.isPresent()) {
            throw new RuntimeException("Reference-Type 'NAV Debitoren-Nr.' not found!");
        }

        Optional<RefType> refTypeOptionalNavKred = refTypeRepository.findByTypeName("NAV Kreditoren-Nr.");
        if (!refTypeOptionalNavKred.isPresent()) {
            throw new RuntimeException("Reference-Type 'NAV Kreditoren-Nr.' not found!");
        }

        Optional<RefType> refTypeOptionalIptc = refTypeRepository.findByTypeName("IPTC");
        if (!refTypeOptionalIptc.isPresent()) {
            throw new RuntimeException("Reference-Type 'IPTC' not found!");
        }

        // get Optionals
        RefType refTypeGtin = refTypeOptionalGtin.get();
        RefType refTypeImg = refTypeOptionalImg.get();
        RefType refTypeNavArtNr = refTypeOptionalNavArtNr.get();
        RefType refTypeHerstArtNr = refTypeOptionalHerstArtNr.get();
        RefType refTypeLagerBarCode = refTypeOptionalLagerBarCode.get();
        RefType refTypeLang = refTypeOptionalLang.get();
        RefType refTypeNavDeb = refTypeOptionalNavDeb.get();
        RefType refTypeNavKred = refTypeOptionalNavKred.get();
        RefType refTypeIptc = refTypeOptionalIptc.get();

        ImageRef imageRef = new ImageRef();
        imageRef.setRefType(refTypeImg);
        imageRef.setRefValue("Pic0816351.jpg");
        imageRef.setImage(null);

        Target imgObject = new Target();
        imgObject.setDescription("Ein Beispiel-Bild");
        imgObject.addReference(imageRef);

        targets.add(imgObject);

        return targets;
    }
}
