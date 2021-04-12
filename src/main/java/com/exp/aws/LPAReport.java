package com.exp.aws;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LPAReport {

    private IAMOps iamClient;
    private String mgmtAccPath;
    private int dealy = 1;
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    LPAReport (String... args) {

        if(args.length > 0) {
            iamClient = new IAMOps(args[0]);
        }

        if (args.length > 1) {
            dealy = Integer.parseInt(args[1]);
        }
    }

    LPAReport () {
        iamClient = new IAMOps();
    }

    public void run () {
        scheduledExecutorService.scheduleWithFixedDelay(iamClient, 1, dealy * 60, TimeUnit.SECONDS);
    }

    public static void main (String... args) {
        LPAReport lpaReport = null;

        if(args.length > 0) {
            lpaReport = new LPAReport(args);
        } else {
            lpaReport = new LPAReport();
        }

        lpaReport.run();
    }

}
