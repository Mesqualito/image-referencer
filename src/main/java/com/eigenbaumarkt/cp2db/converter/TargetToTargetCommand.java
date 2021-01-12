package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.TargetCommand;
import com.eigenbaumarkt.cp2db.domain.Target;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TargetToTargetCommand implements Converter<Target, TargetCommand> {

    private final ImageToImageCommand imageConverter;
    private final ReferenceToReferenceCommand referenceConverter;

    public TargetToTargetCommand(ImageToImageCommand imageConverter, ReferenceToReferenceCommand referenceConverter) {
        this.imageConverter = imageConverter;
        this.referenceConverter = referenceConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public TargetCommand convert(Target source) {

        if(source == null) {
            return null;
        }

        final TargetCommand command = new TargetCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());

        if (source.getReferences() != null && source.getReferences().size() > 0){
            source.getReferences()
                    .forEach( reference -> command.getReferences().add(referenceConverter.convert(reference)));
        }

        if (source.getImageRefs() != null && source.getImageRefs().size() > 0){
            source.getImageRefs()
                    .forEach( image -> command.getImages().add(imageConverter.convert(image)));
        }

        return command;
    }

}
