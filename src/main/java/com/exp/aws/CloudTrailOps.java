package com.exp.aws;

import software.amazon.awssdk.services.cloudtrail.CloudTrailClient;
import software.amazon.awssdk.services.cloudtrail.model.CloudTrailException;
import software.amazon.awssdk.services.cloudtrail.model.DescribeTrailsRequest;
import software.amazon.awssdk.services.cloudtrail.model.DescribeTrailsResponse;
import software.amazon.awssdk.services.cloudtrail.model.GetTrailRequest;
import software.amazon.awssdk.services.cloudtrail.model.GetTrailResponse;
import software.amazon.awssdk.services.cloudtrail.model.Trail;

import java.util.List;
import software.amazon.awssdk.regions.Region;

public class CloudTrailOps {


    public static void main(String... args) {

        Region region = Region.US_EAST_1;
        CloudTrailClient cloudTrailClient = CloudTrailClient.builder()
                .region(region)
                .build();
        CloudTrailClient cloudTrailClientClient = null;
        String trailName = "aws-cloudtrail-logs-408777338031-35fadeb3/AWSLogs/o-ziepcz5dc6/408777338031";

        describeSpecificTrails(cloudTrailClient, trailName);
        cloudTrailClient.close();
    }

    public static void describeSpecificTrails(CloudTrailClient cloudTrailClientClient, String trailName) {

        trailName ="management-events";
        try {
            DescribeTrailsRequest trailsRequest = DescribeTrailsRequest.builder()
                    .trailNameList(trailName)
                    .build();


            DescribeTrailsResponse response = cloudTrailClientClient.describeTrails(trailsRequest);


            List<Trail> trails = response.trailList();
            for (Trail trail : trails) {
                System.out.println("The ARN of the trail is " + trail.trailARN());
            }


            GetTrailRequest getTrailRequest = GetTrailRequest.builder().name(trailName).build();
            GetTrailResponse getTrailResponse = cloudTrailClientClient.getTrail(getTrailRequest);

            System.out.println("The ARN of the trail is " + getTrailResponse.trail().trailARN());

        } catch (CloudTrailException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
