package com.exp.aws;

public class LPAReport {

    IAMOps iam = new IAMOps();

    LPAReport () {}

    public void run () {
        iam.getOrgAcceesInfo();
    }

    public static void main (String... args) {
        LPAReport lpaReport = new LPAReport();
        lpaReport.run();
    }

}
