package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.ReferenceCommand;
import com.eigenbaumarkt.cp2db.domain.Reference;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReferenceToReferenceCommand implements Converter<Reference, ReferenceCommand> {

    private final RefTypeToRefTypeCommand refTypeConverter;

    public ReferenceToReferenceCommand(RefTypeToRefTypeCommand refTypeConverter) {
        this.refTypeConverter = refTypeConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public ReferenceCommand convert(Reference source) {

        if(source == null) {
            return null;
        }

        final ReferenceCommand command = new ReferenceCommand();
        command.setId(source.getId());
        command.setRefName(source.getRefName());
        command.setRefValue(source.getRefValue());
        command.setRefType(refTypeConverter.convert(source.getReferenceType()));

        return command;

    }

}
