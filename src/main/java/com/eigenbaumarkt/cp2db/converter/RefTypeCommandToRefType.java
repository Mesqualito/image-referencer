package com.eigenbaumarkt.cp2db.converter;

import com.eigenbaumarkt.cp2db.commands.RefTypeCommand;
import com.eigenbaumarkt.cp2db.domain.RefType;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RefTypeCommandToRefType implements Converter<RefTypeCommand, RefType> {

    @Synchronized
    @Nullable
    @Override
    public RefType convert(RefTypeCommand source) {

        if(source == null) {
            return null;
        }

        final RefType refType = new RefType();
        refType.setId(source.getId());
        refType.setTypeName(source.getTypeName());

        return refType;
    }
}
