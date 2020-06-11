package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.TargetCommand;
import com.eigenbaumarkt.cp2db.domain.Target;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TargetCommandToTarget implements Converter<TargetCommand, Target> {

    private final ImageCommandToImage imageConverter;
    private final ReferenceCommandToReference referenceConverter;

    public TargetCommandToTarget(ImageCommandToImage imageConverter, ReferenceCommandToReference referenceConverter) {
        this.imageConverter = imageConverter;
        this.referenceConverter = referenceConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Target convert(TargetCommand source) {

        if(source == null) {
            return null;
        }

        final Target target = new Target();
        target.setId(source.getId());

        if (source.getReferences() != null && source.getReferences().size() > 0){
            source.getReferences()
                    .forEach( reference -> target.getReferences().add(referenceConverter.convert(reference)));
        }

        if (source.getImages() != null && source.getImages().size() > 0){
            source.getImages()
                    .forEach( image -> target.getImages().add(imageConverter.convert(image)));
        }

        return target;
    }
}
