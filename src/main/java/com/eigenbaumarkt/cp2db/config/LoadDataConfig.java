package com.eigenbaumarkt.cp2db.config;

import com.eigenbaumarkt.cp2db.converter.CustomJackson2RepositoryPopulatorFactoryBean;
import com.eigenbaumarkt.cp2db.repositories.RefTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.AbstractRepositoryPopulatorFactoryBean;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class LoadDataConfig {

    @Bean
    public AbstractRepositoryPopulatorFactoryBean repositoryPopulator(ObjectMapper objectMapper, RefTypeRepository repository) {
        Jackson2RepositoryPopulatorFactoryBean factory = new CustomJackson2RepositoryPopulatorFactoryBean();
        repository.deleteAll();
        factory.setMapper(objectMapper);
        factory.setResources(new Resource[]{new ClassPathResource("static/collections/reference-types.json"),
                new ClassPathResource("static/collections/placeholder.json")});
        return factory;
    }
}
