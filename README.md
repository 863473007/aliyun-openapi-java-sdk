# Alibaba Cloud Java Software Development Kit
[中文文档](./README_zh.md)

The Alibaba Cloud Software Development Kit Java (SDK) allows you to access Alibaba Cloud services such as Elastic Compute Service (ECS), Server Load Balancer (SLB), and CloudMonitor. You can access Alibaba Cloud services without the need to handle API related tasks, such as signing and constructing your requests.

This document introduces how to obtain and call Alibaba Cloud Java SDK.

If you have any problem while using Java SDK, please join the **DingTalk group: 11771185 (the official SDK customer service group of Alibaba Cloud)** for consultation.

## Prerequisites

-  To use Alibaba Cloud Java SDK, you must have an Alibaba Cloud account as well as an `AccessKey ID` and an `AccessKey Secret`. Create and view your AccessKey on the [RAM console](https://ram.console.aliyun.com "RAM console") or contact your system administrator.

- To use an Alibaba Cloud Java SDK to access the APIs of a product, you must first activate the product on the [Alibaba Cloud console](https://home.console.aliyun.com/?spm=5176.doc52740.2.4.QKZk8w) if required.

-  Alibaba Cloud Java SDK requires JDK 1.6 or later.

## Install Java SDK

If you use Apache Maven to manage Java projects, you only need to add corresponding dependencies to the pom.xml files of the projects. You can download the Maven dependencies of different cloud products in [Alibaba Cloud SDK](https://www.alibabacloud.com/support/developer-resources?spm=a3c0i.7911826.675768.dnavresources1.32a0737buJ2Rr4).

You must install the SDK core library for any SDK you use. For example, to call the ECS SDK, you must install both the ECS SDK and the SDK core library.

For example, with SDK core library 3.5.0 and ECS SDK 3.0.0, you need to declare the two SDKs in the pom.xml file.

```xml
<dependency>
    <groupId>com.aliyun</groupId>
    <artifactId>aliyun-java-sdk-core</artifactId>
    <version>3.5.0</version>
</dependency>
<dependency>
    <groupId>com.aliyun</groupId>
    <artifactId>aliyun-java-sdk-ecs</artifactId>
    <version>3.0.0</version>
</dependency>
```
## Initiate a call

The following code example shows the three main steps to use Alibaba Cloud Java SDK:

1. Create and initialize a `DefaultAcsClient` instance.

2. Create an API request and set parameters.

3. Initiate the request and handle the response or exceptions.

```java
 package com.testprogram;
 import com.aliyuncs.profile.DefaultProfile;
 import com.aliyuncs.DefaultAcsClient;
 import com.aliyuncs.IAcsClient;
 import com.aliyuncs.exceptions.ClientException;
 import com.aliyuncs.exceptions.ServerException;
 import com.aliyuncs.ecs.model.v20140526.*;
 public class Main {
     public static void main(String[] args) {
         // Create and initialize a DefaultAcsClient instance
         DefaultProfile profile = DefaultProfile.getProfile(
             "<your-region-id>",          // The region ID
             "<your-access-key-id>",      // The AccessKey ID of the RAM account
             "<your-access-key-secret>"); // The AccessKey Secret of the RAM account
         IAcsClient client = new DefaultAcsClient(profile);
         // Create an API request and set parameters
         DescribeInstancesRequest request = new DescribeInstancesRequest();
         request.setPageSize(10);
         // Initiate the request and handle the response or exceptions
         DescribeInstancesResponse response;
         try {
             response = client.getAcsResponse(request);
             for (DescribeInstancesResponse.Instance instance:response.getInstances()) {
                 System.out.println(instance.getPublicIpAddress());
             }
         } catch (ServerException e) {
             e.printStackTrace();
         } catch (ClientException e) {
             e.printStackTrace();
         }
     }
 }
```