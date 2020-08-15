# Hello-alexa-skill project 

### What is this?
This is an example project with the original intention to learning how to make an Alexa skill for Echo devices and at the same time to share knowledge how to configure and deploy Lambda skill with CDK.

### Instructions
Deploy cloud infrastructure on AWS.

Go to root directory which is an AWS CDK project, here you will need the following requirements.

- Need an AWS account with permissions to deploy all services, for details see the CDK Stack in this project.
- Have aws cli installed and configurations al ready set locally for cdk deploy to pick ir up.
- Will need S3 bucket to hold package lambda. Refer to script in ```AWS/HelloAlexaSkillLambda/build-and-upload-lambda.sh```
- Project is a maven app, make sure to have maven installed to build the project.
- Will need to create a Alexa Skill on ```developer.amazon.com``` and create an **HolaMundoIntent** intent, add AWS Lambda ARN in Service Endpoint Type and set Skill Invocation Name 

Sample setup:
```bash
# From AWS/HelloAlexaSkillLambda
# This package and upload lambda jar file into S3 buckets, this will be pricked up by CDK Stack
sh build-and-package-lambda.sh

# From /project root
# Provision everthon on AWS as a Stack 
cdk synth --profile AWSProfile
cdk bootstrap --profile AWSProfile
mvn package
cdk deploy --profile AWSProfile
```