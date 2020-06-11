package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.RefTypeCommand;
import com.eigenbaumarkt.cp2db.domain.RefType;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RefTypeToRefTypeCommand implements Converter<RefType, RefTypeCommand> {

    @Synchronized
    @Nullable
    @Override
    public RefTypeCommand convert(RefType source) {

        if(source == null) {
            return null;
        }

        final RefTypeCommand command = new RefTypeCommand();
        command.setId(source.getId());
        command.setTypeName(source.getTypeName());

        return command;

    }
}
