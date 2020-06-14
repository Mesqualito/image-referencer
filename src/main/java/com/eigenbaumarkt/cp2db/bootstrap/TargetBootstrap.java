package com.eigenbaumarkt.cp2db.bootstrap;

import com.eigenbaumarkt.cp2db.domain.Target;
import com.eigenbaumarkt.cp2db.repositories.ImageRepository;
import com.eigenbaumarkt.cp2db.repositories.RefTypeRepository;
import com.eigenbaumarkt.cp2db.repositories.ReferenceRepository;
import com.eigenbaumarkt.cp2db.repositories.TargetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TargetBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final TargetRepository targetRepository;
    private final RefTypeRepository refTypeRepository;
    private final ReferenceRepository referenceRepository;
    private final ImageRepository imageRepository;

    public TargetBootstrap(TargetRepository targetRepository, RefTypeRepository refTypeRepository,
                           ReferenceRepository referenceRepository, ImageRepository imageRepository) {
        this.targetRepository = targetRepository;
        this.refTypeRepository = refTypeRepository;
        this.referenceRepository = referenceRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        targetRepository.saveAll(getTargets());
        log.debug("Loading Bootstrap Data!");
    }

    private List<Target> getTargets() {

        List<Target> targets = new ArrayList<>(2);

        return targets;

    }


}
