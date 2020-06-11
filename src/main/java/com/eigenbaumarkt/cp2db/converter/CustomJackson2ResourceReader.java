package com.eigenbaumarkt.cp2db.converter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2ResourceReader;
import org.springframework.data.repository.init.ResourceReader;

import java.util.Collections;

@Slf4j
public class CustomJackson2ResourceReader implements ResourceReader {

    private static final Logger logger = LoggerFactory.getLogger(CustomJackson2ResourceReader.class);

    private final Jackson2ResourceReader resourceReader = new Jackson2ResourceReader();

    @Override
    public Object readFrom(Resource resource, ClassLoader classLoader) throws Exception {
        Object result;
        try {
            result = resourceReader.readFrom(resource, classLoader);
        } catch(Exception e) {
            logger.warn("Can't read from resource", e);
            System.out.println("Can't read from resource" + e);
            return Collections.EMPTY_LIST;
        }
        return result;
    }
}
