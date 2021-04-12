package com.exp.aws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.AccessAdvisorUsageGranularityType;
import software.amazon.awssdk.services.iam.model.GenerateOrganizationsAccessReportRequest;
import software.amazon.awssdk.services.iam.model.GenerateOrganizationsAccessReportResponse;
import software.amazon.awssdk.services.iam.model.GenerateServiceLastAccessedDetailsRequest;
import software.amazon.awssdk.services.iam.model.GenerateServiceLastAccessedDetailsResponse;
import software.amazon.awssdk.services.iam.model.GetOrganizationsAccessReportRequest;
import software.amazon.awssdk.services.iam.model.GetOrganizationsAccessReportResponse;
import software.amazon.awssdk.services.iam.model.GetServiceLastAccessedDetailsRequest;
import software.amazon.awssdk.services.iam.model.GetServiceLastAccessedDetailsResponse;
import software.amazon.awssdk.services.iam.model.JobStatusType;
import software.amazon.awssdk.services.organizations.OrganizationsClient;
import software.amazon.awssdk.services.organizations.model.Child;
import software.amazon.awssdk.services.organizations.model.ChildType;
import software.amazon.awssdk.services.organizations.model.ListAccountsRequest;
import software.amazon.awssdk.services.organizations.model.ListAccountsResponse;
import software.amazon.awssdk.services.organizations.model.ListChildrenRequest;
import software.amazon.awssdk.services.organizations.model.ListChildrenResponse;
import software.amazon.awssdk.services.organizations.model.ListRootsResponse;

import java.util.concurrent.atomic.AtomicBoolean;

public class IAMOps implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(IAMOps.class);

    private static String MGMT_ACC_ID = "o-ziepcz5dc6";
    private int runCount = 0;

    public IAMOps(String mgmtAccPath) {
        this.MGMT_ACC_ID = mgmtAccPath;
    }

    public IAMOps() {}

    @Override
    public void run() {
        log.info("");
        log.info(">>>>>>>>>>>>>>>>>>   Runing iteration no: {}", runCount++);
        getOrgAcceesInfo( this.MGMT_ACC_ID);
    }

    public void getOrgAcceesInfo(String mgmtAccPath) {

        if (mgmtAccPath != null) {
            MGMT_ACC_ID = mgmtAccPath;
        }

        Region region = Region.AWS_GLOBAL;
        IamClient iam = IamClient.builder()
                .region(region)
                .build();

        OrganizationsClient oc = OrganizationsClient.builder().region(region).build();

        try {
            ListRootsResponse listRootResp = oc.listRoots();

            log.info("");
            log.info("Pulling service access data for last 90 days for Org: {}\n", MGMT_ACC_ID + "/" + listRootResp.roots().get(0).id()); // Assuming there is only one root

            listRootResp.roots().forEach(root -> {
                String baseEntity = MGMT_ACC_ID + "/" + root.id();

                // Iterate over OrgUnits
                ListChildrenRequest lcReq = ListChildrenRequest.builder().parentId(root.id()).childType(ChildType.ORGANIZATIONAL_UNIT).build();
                ListChildrenResponse lcResp =  oc.listChildren(lcReq);

                for (Child ou : lcResp.children()) {
                    String entity = baseEntity + "/" + ou.id();
                    log.info("Processing OrgUnit with entity: {}", entity);
                    getLastAccessInfo(iam, entity);
                }

                // Iterate over Accounts
                lcReq = ListChildrenRequest.builder().parentId(root.id()).childType(ChildType.ACCOUNT).build();
                try {
                    lcResp = oc.listChildren(lcReq);
                } catch (Exception e) {
                    log.error("Exception on listChildren for given org. Cause: {}", e.getLocalizedMessage());
                    return;
                }


                for (Child acc : lcResp.children()) {
                    String entity = baseEntity + "/" + acc.id();
                    log.info("Processing Account with entity: {}", entity);
                    getLastAccessInfo(iam, entity);
                }
            });


            // Just to compare
            // getServiceLastAccessedDetailsUsingARN(iam);

        } catch (Exception e) {
            log.error("", e);
        }

    }

    public void getLastAccessInfo(IamClient iam, String entity) {

        GenerateOrganizationsAccessReportRequest generateOrganizationsAccessReportRequest
                = GenerateOrganizationsAccessReportRequest.builder().entityPath(entity).build();

        GenerateOrganizationsAccessReportResponse generateResp = null;
        try {
            generateResp = iam.generateOrganizationsAccessReport(generateOrganizationsAccessReportRequest);
        } catch (Exception e) {
            log.error("Exception on generateOrganizationsAccessReport. Cause: {}", e.getLocalizedMessage());
            return;
        }

        String jobId = generateResp.jobId();

        GetOrganizationsAccessReportRequest getOrganizationsAccessReportRequest
                = GetOrganizationsAccessReportRequest.builder().jobId(jobId).maxItems(1000).build();
        GetOrganizationsAccessReportResponse getResp = iam.getOrganizationsAccessReport(getOrganizationsAccessReportRequest);

        while(getResp.jobStatus().equals(JobStatusType.IN_PROGRESS)) {
            getResp = iam.getOrganizationsAccessReport(getOrganizationsAccessReportRequest);
        }

        log.info("Number of services accessible:   {}", getResp.numberOfServicesAccessible());
        log.info("Number of services accessed:     {}", getResp.numberOfServicesAccessible() - getResp.numberOfServicesNotAccessed());
        log.info("Number of services NOT accessed: {}", getResp.numberOfServicesNotAccessed());

        log.debug("\nAccess Info: {}\n", getResp.toString());

        if (getResp.numberOfServicesAccessible() - getResp.numberOfServicesNotAccessed() > 0) {
            getResp.accessDetails().forEach(accessDetail -> {
                if (accessDetail.totalAuthenticatedEntities() > 0) {
                    log.info("-> {}", accessDetail.toString());
                }
            });
        }

        log.info("------------------------------------------------------------------------------------------------------\n");
    }

    public void getServiceLastAccessedDetailsUsingARN(IamClient iamClient) {

        String arn = "arn:aws:iam::408777338031:user/mahesh";

        GenerateServiceLastAccessedDetailsRequest getSAFReq = GenerateServiceLastAccessedDetailsRequest.builder().arn(arn).granularity(AccessAdvisorUsageGranularityType.ACTION_LEVEL).build();

        GenerateServiceLastAccessedDetailsResponse getSAFResp = iamClient.generateServiceLastAccessedDetails(getSAFReq);
        GetServiceLastAccessedDetailsRequest sadReq = GetServiceLastAccessedDetailsRequest.builder().jobId(getSAFResp.jobId()).maxItems(1000).build();

        GetServiceLastAccessedDetailsResponse sadResp = iamClient.getServiceLastAccessedDetails(sadReq);

        while(sadResp.jobStatus().equals(JobStatusType.IN_PROGRESS)) {
            sadResp = iamClient.getServiceLastAccessedDetails(sadReq);
        }
        log.info("");
        log.info(">>> getServiceLastAccessedDetailsUsingARN: ARN  {}", arn);
        sadResp.servicesLastAccessed().forEach(accessDetails -> {
            if(accessDetails.totalAuthenticatedEntities() > 0)
                log.info("AccessedDetails  {}\n", accessDetails.toString());
        });

    }


}

