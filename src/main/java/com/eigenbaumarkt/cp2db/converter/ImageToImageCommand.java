package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.ImageCommand;
import com.eigenbaumarkt.cp2db.domain.Image;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ImageToImageCommand implements Converter<Image, ImageCommand> {

    @Synchronized
    @Nullable
    @Override
    public ImageCommand convert(Image source) {

        if(source == null) {
            return null;
        }

        final ImageCommand command = new ImageCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());
        command.setImage(source.getImage());
        command.setSavedAt(source.getSavedAt());

        return command;

    }
}
