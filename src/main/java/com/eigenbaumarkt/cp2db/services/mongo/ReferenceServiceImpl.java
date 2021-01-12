package com.eigenbaumarkt.cp2db.services.mongo;

import com.eigenbaumarkt.cp2db.services.ReferenceService;
import com.nmote.iim4j.IIMDataSetInfoFactory;
import com.nmote.iim4j.IIMFile;
import com.nmote.iim4j.IIMReader;
import com.nmote.iim4j.dataset.DataSet;
import com.nmote.iim4j.dataset.DataSetInfo;
import com.nmote.iim4j.dataset.InvalidDataSetException;
import com.nmote.iim4j.stream.FileIIMInputStream;
import com.nmote.iim4j.stream.JPEGIIMInputStream;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    @Override
    public void deleteById(String targetId, String referenceId) {

        // TODO: delete Reference

    }

    // TODO:
    // - divide into different implementations of RefTypes:
    // "GTIN", "Bild", "NAV Artikelnr.", "Hersteller-Artikelnr.", "Lager-Barcode", "Sprache",
    // "NAV Debitoren-Nr.", "NAV Kreditoren-Nr.", "IPTC");

    // - if refType is IptcRef, there will be zero to many IptcRef to save:
    // - should be automatically called if refType is an image
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
