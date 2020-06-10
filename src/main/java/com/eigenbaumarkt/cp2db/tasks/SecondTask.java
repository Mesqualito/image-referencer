package com.eigenbaumarkt.cp2db.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.concurrent.TimeUnit;

public class SecondTask implements Tasklet {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("SecondTask start...");

        TimeUnit.SECONDS.sleep(5);

        System.out.println("SecondTask done...");
        return RepeatStatus.FINISHED;

    }
}
