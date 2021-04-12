# AWS_LPAccess

This application just dumps the AWS service acces infomation for an org to console on period basis (1 min).

Build - If you have java 8 and gradle 4.3+, just do 'gradle build -x test' 

Run : LAPReport is main class. It creates IAMOps and runs code to pull 'LastAuthenticatedTime' (AccessTime) for configured mgmt acc.

If running from command line pass "mgmt account org id" of your AWS account, and the period in minute which dictates how regularly the job should run.

Ex: java -jar <path>/AWS_LPAccess-all.jar o-ziepcz5dc6

Acces infomation logged to console which will look like this for first iteration

XGEC:AWS_LPAccess mahbasav$ java -jar ./build/libs/AWS_LPAccess-all.jar o-ziepcz5dc6 
Timestamp=2021-04-12 13:40:46,228 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps
Timestamp=2021-04-12 13:40:46,229 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps >>>>>>>>>>>>>>>>>>   Runing iteration no: 0
Timestamp=2021-04-12 13:40:47,624 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps
Timestamp=2021-04-12 13:40:47,624 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Pulling service access data for last 90 days for Org: o-ziepcz5dc6/r-zphj

Timestamp=2021-04-12 13:40:47,832 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Processing OrgUnit with entity: o-ziepcz5dc6/r-zphj/ou-zphj-wvxvuzjl
Timestamp=2021-04-12 13:40:48,874 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services accessible:   264
Timestamp=2021-04-12 13:40:48,875 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services accessed:     0
Timestamp=2021-04-12 13:40:48,875 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services NOT accessed: 264
Timestamp=2021-04-12 13:40:48,876 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps ------------------------------------------------------------------------------------------------------

Timestamp=2021-04-12 13:40:48,876 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Processing OrgUnit with entity: o-ziepcz5dc6/r-zphj/ou-zphj-7f8m4upv
Timestamp=2021-04-12 13:40:50,461 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services accessible:   264
Timestamp=2021-04-12 13:40:50,461 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services accessed:     0
Timestamp=2021-04-12 13:40:50,461 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services NOT accessed: 264
Timestamp=2021-04-12 13:40:50,462 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps ------------------------------------------------------------------------------------------------------

Timestamp=2021-04-12 13:40:50,658 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Processing Account with entity: o-ziepcz5dc6/r-zphj/408777338031
Timestamp=2021-04-12 13:40:52,162 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services accessible:   264
Timestamp=2021-04-12 13:40:52,162 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services accessed:     18
Timestamp=2021-04-12 13:40:52,162 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services NOT accessed: 246
Timestamp=2021-04-12 13:40:52,163 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS IAM Access Analyzer, ServiceNamespace=access-analyzer, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T06:20:35Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Artifact, ServiceNamespace=artifact, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-06T06:14:16Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Billing, ServiceNamespace=aws-portal, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-06T06:14:54Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS CloudFormation, ServiceNamespace=cloudformation, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-08T22:52:02Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS CloudTrail, ServiceNamespace=cloudtrail, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T19:23:28Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon CloudWatch, ServiceNamespace=cloudwatch, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T00:09:18Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Config, ServiceNamespace=config, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-11T23:24:15Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon EC2, ServiceNamespace=ec2, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-07T07:04:15Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Health APIs and Notifications, ServiceNamespace=health, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T19:38:45Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Identity and Access Management, ServiceNamespace=iam, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T19:24:12Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Lambda, ServiceNamespace=lambda, Region=ap-south-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-10T05:31:48Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon CloudWatch Logs, ServiceNamespace=logs, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-08T23:22:28Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Organizations, ServiceNamespace=organizations, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T19:24:10Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,164 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Resource Access Manager, ServiceNamespace=ram, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-07T07:04:14Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,165 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon S3, ServiceNamespace=s3, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T19:24:00Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,165 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon SNS, ServiceNamespace=sns, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-11T18:20:03Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,165 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon SQS, ServiceNamespace=sqs, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T00:09:20Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,165 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon Resource Group Tagging API, ServiceNamespace=tag, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-08T22:51:56Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:52,165 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps ------------------------------------------------------------------------------------------------------

Timestamp=2021-04-12 13:40:52,165 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Processing Account with entity: o-ziepcz5dc6/r-zphj/835594573477
Timestamp=2021-04-12 13:40:53,609 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services accessible:   264
Timestamp=2021-04-12 13:40:53,609 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services accessed:     4
Timestamp=2021-04-12 13:40:53,609 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps Number of services NOT accessed: 260
Timestamp=2021-04-12 13:40:53,610 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Health APIs and Notifications, ServiceNamespace=health, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/835594573477, LastAuthenticatedTime=2021-04-12T08:41:57Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:53,610 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Identity and Access Management, ServiceNamespace=iam, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/835594573477, LastAuthenticatedTime=2021-04-12T08:06:22Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:53,610 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Organizations, ServiceNamespace=organizations, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/835594573477, LastAuthenticatedTime=2021-04-12T08:11:30Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:53,610 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon S3, ServiceNamespace=s3, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/835594573477, LastAuthenticatedTime=2021-04-12T08:15:20Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 13:40:53,611 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps ------------------------------------------------------------------------------------------------------

Timestamp=2021-04-12 13:40:55,716 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps
Timestamp=2021-04-12 13:40:55,716 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps >>> getServiceLastAccessedDetailsUsingARN: ARN  arn:aws:iam::408777338031:user/mahesh
Timestamp=2021-04-12 13:40:55,716 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps AccessedDetails  ServiceLastAccessed(ServiceName=AWS CloudTrail, LastAuthenticated=2021-04-12T06:43:07Z, ServiceNamespace=cloudtrail, LastAuthenticatedEntity=arn:aws:iam::408777338031:user/mahesh, LastAuthenticatedRegion=us-east-1, TotalAuthenticatedEntities=1)

Timestamp=2021-04-12 13:40:55,716 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps AccessedDetails  ServiceLastAccessed(ServiceName=AWS Identity and Access Management, LastAuthenticated=2021-04-12T20:22:56Z, ServiceNamespace=iam, LastAuthenticatedEntity=arn:aws:iam::408777338031:user/mahesh, LastAuthenticatedRegion=us-east-1, TotalAuthenticatedEntities=1)

Timestamp=2021-04-12 13:40:55,717 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps AccessedDetails  ServiceLastAccessed(ServiceName=AWS Organizations, LastAuthenticated=2021-04-12T19:24:10Z, ServiceNamespace=organizations, LastAuthenticatedEntity=arn:aws:iam::408777338031:user/mahesh, LastAuthenticatedRegion=us-east-1, TotalAuthenticatedEntities=1)

Timestamp=2021-04-12 13:40:55,717 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[pool-1-thread-1] Class=c.e.a.IAMOps AccessedDetails  ServiceLastAccessed(ServiceName=Amazon S3, LastAuthenticated=2021-04-12T00:10:17Z, ServiceNamespace=s3, LastAuthenticatedEntity=arn:aws:iam::408777338031:user/mahesh, LastAuthenticatedRegion=us-west-2, TotalAuthenticatedEntities=1, TrackedActionsLastAccessed=[TrackedActionLastAccessed(ActionName=CreateAccessPoint), TrackedActionLastAccessed(ActionName=CreateBucket, LastAccessedEntity=arn:aws:iam::408777338031:user/mahesh, LastAccessedTime=2021-04-12T00:10:17Z, LastAccessedRegion=us-west-2), TrackedActionLastAccessed(ActionName=CreateJob), TrackedActionLastAccessed(ActionName=DeleteAccessPoint), TrackedActionLastAccessed(ActionName=DeleteAccessPointPolicy), TrackedActionLastAccessed(ActionName=DeleteBucket, LastAccessedEntity=arn:aws:iam::408777338031:user/mahesh, LastAccessedTime=2021-04-10T19:16:27Z, LastAccessedRegion=us-west-2), TrackedActionLastAccessed(ActionName=DeleteBucketPolicy), TrackedActionLastAccessed(ActionName=DeleteBucketWebsite), TrackedActionLastAccessed(ActionName=DeleteJobTagging), TrackedActionLastAccessed(ActionName=DeleteStorageLensConfiguration), TrackedActionLastAccessed(ActionName=DeleteStorageLensConfigurationTagging), TrackedActionLastAccessed(ActionName=DescribeJob), TrackedActionLastAccessed(ActionName=GetAccessPoint), TrackedActionLastAccessed(ActionName=GetAccessPointPolicy), TrackedActionLastAccessed(ActionName=GetAccessPointPolicyStatus), TrackedActionLastAccessed(ActionName=GetAccountPublicAccessBlock), TrackedActionLastAccessed(ActionName=GetBucketAcl), TrackedActionLastAccessed(ActionName=GetBucketCORS), TrackedActionLastAccessed(ActionName=GetBucketLocation), TrackedActionLastAccessed(ActionName=GetBucketLogging), TrackedActionLastAccessed(ActionName=GetBucketNotification), TrackedActionLastAccessed(ActionName=GetBucketObjectLockConfiguration), TrackedActionLastAccessed(ActionName=GetBucketPolicy), TrackedActionLastAccessed(ActionName=GetBucketPolicyStatus), TrackedActionLastAccessed(ActionName=GetBucketPublicAccessBlock), TrackedActionLastAccessed(ActionName=GetBucketRequestPayment), TrackedActionLastAccessed(ActionName=GetBucketTagging), TrackedActionLastAccessed(ActionName=GetBucketVersioning), TrackedActionLastAccessed(ActionName=GetBucketWebsite), TrackedActionLastAccessed(ActionName=GetEncryptionConfiguration), TrackedActionLastAccessed(ActionName=GetJobTagging), TrackedActionLastAccessed(ActionName=GetLifecycleConfiguration), TrackedActionLastAccessed(ActionName=GetReplicationConfiguration), TrackedActionLastAccessed(ActionName=GetStorageLensConfiguration), TrackedActionLastAccessed(ActionName=GetStorageLensConfigurationTagging), TrackedActionLastAccessed(ActionName=GetStorageLensDashboard), TrackedActionLastAccessed(ActionName=ListAccessPoints), TrackedActionLastAccessed(ActionName=ListAllMyBuckets), TrackedActionLastAccessed(ActionName=ListJobs), TrackedActionLastAccessed(ActionName=ListStorageLensConfigurations), TrackedActionLastAccessed(ActionName=PutAccessPointPolicy), TrackedActionLastAccessed(ActionName=PutAccountPublicAccessBlock), TrackedActionLastAccessed(ActionName=PutBucketAcl), TrackedActionLastAccessed(ActionName=PutBucketCORS), TrackedActionLastAccessed(ActionName=PutBucketLogging), TrackedActionLastAccessed(ActionName=PutBucketNotification), TrackedActionLastAccessed(ActionName=PutBucketObjectLockConfiguration), TrackedActionLastAccessed(ActionName=PutBucketPolicy), TrackedActionLastAccessed(ActionName=PutBucketPublicAccessBlock), TrackedActionLastAccessed(ActionName=PutBucketRequestPayment), TrackedActionLastAccessed(ActionName=PutBucketTagging), TrackedActionLastAccessed(ActionName=PutBucketVersioning), TrackedActionLastAccessed(ActionName=PutBucketWebsite), TrackedActionLastAccessed(ActionName=PutEncryptionConfiguration), TrackedActionLastAccessed(ActionName=PutJobTagging), TrackedActionLastAccessed(ActionName=PutLifecycleConfiguration), TrackedActionLastAccessed(ActionName=PutReplicationConfiguration), TrackedActionLastAccessed(ActionName=PutStorageLensConfiguration), TrackedActionLastAccessed(ActionName=PutStorageLensConfigurationTagging), TrackedActionLastAccessed(ActionName=UpdateJobPriority), TrackedActionLastAccessed(ActionName=UpdateJobStatus)])