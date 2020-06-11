package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.ReferenceCommand;
import com.eigenbaumarkt.cp2db.domain.Reference;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReferenceCommandToReference implements Converter<ReferenceCommand, Reference> {

    private final RefTypeCommandToRefType refTypeConverter;

    public ReferenceCommandToReference(RefTypeCommandToRefType refTypeConverter) {
        this.refTypeConverter = refTypeConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public Reference convert(ReferenceCommand source) {

        if(source == null) {
            return null;
        }

        final Reference reference = new Reference();
        reference.setId(source.getId());
        reference.setRefName(source.getRefName());
        reference.setRefValue(source.getRefValue());
        reference.setReferenceType(refTypeConverter.convert(source.getRefType()));

        return reference;

    }
}
