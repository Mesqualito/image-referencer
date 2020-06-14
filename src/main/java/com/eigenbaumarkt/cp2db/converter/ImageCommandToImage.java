package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.ImageCommand;
import com.eigenbaumarkt.cp2db.domain.ImageRef;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ImageCommandToImage implements Converter<ImageCommand, ImageRef> {

    @Synchronized
    @Nullable
    @Override
    public ImageRef convert(ImageCommand source) {

        if(source == null) {
            return null;
        }

        final ImageRef imageRef = new ImageRef();
        imageRef.setId(source.getId());
        imageRef.setDescription(source.getDescription());
        imageRef.setImage(source.getImage());
        imageRef.setSavedAt(source.getSavedAt());

        return imageRef;
    }
}
