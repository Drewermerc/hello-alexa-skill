#!/bin/bash
# Package and upload lambda to S3, require your own configuration
S3Buckte="s3://alexa-skill-hello-lambdas"
HelloSkillJar="target/HelloAlexaSkillLambda-1.0-jar-with-dependencies.jar"
AWSProfile="test-lambdas"

mvn org.apache.maven.plugins:maven-assembly-plugin:2.6:assembly -DdescriptorId=jar-with-dependencies package

aws s3 mb $S3Buckte --profile $AWSProfile
aws s3 cp $HelloSkillJar $S3Buckte --profile $AWSProfile