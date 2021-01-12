package com.eigenbaumarkt.cp2db.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


public class FirstTask implements Tasklet {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("FirstTask start: Read file...");


        System.out.println("FirstTask done...");
        return RepeatStatus.FINISHED;

    }
}
