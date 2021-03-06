package com.eigenbaumarkt.cp2db.config;

import com.eigenbaumarkt.cp2db.tasks.FirstTask;
import com.eigenbaumarkt.cp2db.tasks.SecondTask;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step stepOne(){
        return steps.get("stepOne")
                .tasklet(new FirstTask())
                .build();
    }

    @Bean
    public Step stepTwo(){
        return steps.get("stepTwo")
                .tasklet(new SecondTask())
                .build();
    }

    @Bean
    public Job demoJob(){
        return jobs.get("MyJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .next(stepTwo())
                .build();
    }

}
