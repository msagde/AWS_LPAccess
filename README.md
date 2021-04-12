# AWS_LPAccess

LAPReport is main class. It creates IAMOps and runs code to pull 'LastAuthenticatedTime' (AccesTime) for configured mgmt acc.

If running from command line pass "mgmt account org id" .

Ex: java -jar <path>/AWS_LPAccess-all.jar o-ziepcz5dc6

This application just dumps the acces infomation to console which will look like this


MAHBASAV-M-XGEC:AWS_LPAccess mahbasav$ java -jar ./build/libs/AWS_LPAccess-all.jar o-ziepcz5dc6 r-zph
#logback.classic pattern: Timestamp=%d LogLevel=%-5level ServiceName=AWS_LPA ThreadId=[%thread] Class=%logger{1} %msg%n
Timestamp=2021-04-12 12:04:18,610 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps
Timestamp=2021-04-12 12:04:18,611 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Pulling service access data for last 90 days for Org: o-ziepcz5dc6/r-zphj

Timestamp=2021-04-12 12:04:18,830 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Processing OrgUnit with entity: o-ziepcz5dc6/r-zphj/ou-zphj-wvxvuzjl
Timestamp=2021-04-12 12:04:21,856 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services accessible:   264
Timestamp=2021-04-12 12:04:21,857 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services accessed:     0
Timestamp=2021-04-12 12:04:21,857 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services NOT accessed: 264
Timestamp=2021-04-12 12:04:21,858 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps ------------------------------------------------------------------------------------------------------

Timestamp=2021-04-12 12:04:21,858 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Processing OrgUnit with entity: o-ziepcz5dc6/r-zphj/ou-zphj-7f8m4upv
Timestamp=2021-04-12 12:04:23,946 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services accessible:   264
Timestamp=2021-04-12 12:04:23,946 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services accessed:     0
Timestamp=2021-04-12 12:04:23,947 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services NOT accessed: 264
Timestamp=2021-04-12 12:04:23,947 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps ------------------------------------------------------------------------------------------------------

Timestamp=2021-04-12 12:04:24,145 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Processing Account with entity: o-ziepcz5dc6/r-zphj/408777338031
Timestamp=2021-04-12 12:04:25,994 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services accessible:   264
Timestamp=2021-04-12 12:04:25,994 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services accessed:     18
Timestamp=2021-04-12 12:04:25,994 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services NOT accessed: 246
Timestamp=2021-04-12 12:04:25,995 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS IAM Access Analyzer, ServiceNamespace=access-analyzer, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T06:20:35Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Artifact, ServiceNamespace=artifact, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-06T06:14:16Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Billing, ServiceNamespace=aws-portal, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-06T06:14:54Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS CloudFormation, ServiceNamespace=cloudformation, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-08T22:52:02Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS CloudTrail, ServiceNamespace=cloudtrail, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T06:43:07Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon CloudWatch, ServiceNamespace=cloudwatch, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T00:09:18Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Config, ServiceNamespace=config, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-11T23:24:15Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon EC2, ServiceNamespace=ec2, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-07T07:04:15Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Health APIs and Notifications, ServiceNamespace=health, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T07:58:08Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Identity and Access Management, ServiceNamespace=iam, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T18:41:28Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Lambda, ServiceNamespace=lambda, Region=ap-south-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-10T05:31:48Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon CloudWatch Logs, ServiceNamespace=logs, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-08T23:22:28Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Organizations, ServiceNamespace=organizations, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T18:37:31Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Resource Access Manager, ServiceNamespace=ram, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-07T07:04:14Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,996 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon S3, ServiceNamespace=s3, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T06:41:14Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,997 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon SNS, ServiceNamespace=sns, Region=us-east-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-11T18:20:03Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,997 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon SQS, ServiceNamespace=sqs, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-12T00:09:20Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,997 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon Resource Group Tagging API, ServiceNamespace=tag, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/408777338031, LastAuthenticatedTime=2021-04-08T22:51:56Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:25,997 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps ------------------------------------------------------------------------------------------------------

Timestamp=2021-04-12 12:04:25,997 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Processing Account with entity: o-ziepcz5dc6/r-zphj/835594573477
Timestamp=2021-04-12 12:04:28,039 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services accessible:   264
Timestamp=2021-04-12 12:04:28,040 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services accessed:     4
Timestamp=2021-04-12 12:04:28,040 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps Number of services NOT accessed: 260
Timestamp=2021-04-12 12:04:28,040 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Health APIs and Notifications, ServiceNamespace=health, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/835594573477, LastAuthenticatedTime=2021-04-12T08:41:57Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:28,040 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Identity and Access Management, ServiceNamespace=iam, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/835594573477, LastAuthenticatedTime=2021-04-12T08:06:22Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:28,040 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=AWS Organizations, ServiceNamespace=organizations, Region=us-east-1, EntityPath=o-ziepcz5dc6/r-zphj/835594573477, LastAuthenticatedTime=2021-04-12T08:11:30Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:28,040 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps -> AccessDetail(ServiceName=Amazon S3, ServiceNamespace=s3, Region=us-west-2, EntityPath=o-ziepcz5dc6/r-zphj/835594573477, LastAuthenticatedTime=2021-04-12T08:15:20Z, TotalAuthenticatedEntities=1)
Timestamp=2021-04-12 12:04:28,040 LogLevel=INFO  ServiceName=AWS_LPA ThreadId=[main] Class=c.e.a.IAMOps ------------------------------------------------------------------------------------------------------

