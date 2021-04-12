package com.exp.aws;

public class LPAReport {

    IAMOps iam = new IAMOps();
    String mgmtAccPath;

    LPAReport () {}

    LPAReport (String mgmtAccPath) {
        this.mgmtAccPath = mgmtAccPath;
    }

    public void run () {
        iam.getOrgAcceesInfo(mgmtAccPath);
    }

    public static void main (String... args) {
        LPAReport lpaReport = null;
        if(args.length > 0) {
            lpaReport = new LPAReport(args[0]);
        } else {
            lpaReport = new LPAReport();
        }
        lpaReport.run();
    }

}
