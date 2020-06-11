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


    @Synchronized
    @Nullable
    @Override
    public Target convert(TargetCommand source) {

        if(source == null) {
            return null;
        }

        final Target target = new Target();
        target.setId(source.getId());
        target.setImages(imageConverter);

        return target;

    }
}
