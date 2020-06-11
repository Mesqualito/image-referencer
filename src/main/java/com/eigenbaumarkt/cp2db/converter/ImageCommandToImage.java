package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.ImageCommand;
import com.eigenbaumarkt.cp2db.domain.Image;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ImageCommandToImage implements Converter<ImageCommand, Image> {

    @Synchronized
    @Nullable
    @Override
    public Image convert(ImageCommand source) {

        if(source == null) {
            return null;
        }

        final Image image = new Image();
        image.setId(source.getId());
        image.setDescription(source.getDescription());
        image.setImage(source.getImage());
        image.setSavedAt(source.getSavedAt());

        return image;
    }
}
