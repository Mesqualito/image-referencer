package com.eigenbaumarkt.cp2db.domain;

import com.nmote.iim4j.IIMDataSetInfoFactory;
import com.nmote.iim4j.IIMFile;
import com.nmote.iim4j.IIMReader;
import com.nmote.iim4j.dataset.DataSet;
import com.nmote.iim4j.dataset.DataSetInfo;
import com.nmote.iim4j.dataset.InvalidDataSetException;
import com.nmote.iim4j.stream.FileIIMInputStream;
import com.nmote.iim4j.stream.JPEGIIMInputStream;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@NoArgsConstructor
@Data
public class IptcRef implements Reference {

    @Id
    private String id;
    @Field
    private String refName;
    @Field
    private String refValue;
    @Field
    private RefType referenceType;

    // TODO: Fields for HashMap from readIptc

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getRefName() {
        return refName;
    }

    @Override
    public String getRefValue() {
        return refValue;
    }

    @Override
    public RefType getReferenceType() {
        return referenceType;
    }

    @Override
    public void setRefName(String refName) {
        this.refName = refName;

    }

    @Override
    public void setRefValue(String refValue) {
        this.refValue = refValue;
    }

    // TODO: ReferenceType should be refType.typeName.equals("IPTC")
    @Override
    public void setReferenceType(RefType refType) {
        this.referenceType = refType;
    }

    public HashMap<String, String> readIptc(File file) throws IOException, InvalidDataSetException {

        HashMap<String, String> dataMap = new HashMap<>();

        IIMReader reader = new IIMReader(new JPEGIIMInputStream(new FileIIMInputStream(file)),
                new IIMDataSetInfoFactory());

        IIMFile iimFile = new IIMFile();
        iimFile.readFrom(reader, 20);

        for (DataSet ds : iimFile.getDataSets()) {
            Object value = ds.getValue();
            DataSetInfo info = ds.getInfo();
            System.out.println(info.toString() + " " + info.getName() + ": " + value);
            dataMap.put(info.getName(), value.toString());
        }

        return dataMap;
    }
}
