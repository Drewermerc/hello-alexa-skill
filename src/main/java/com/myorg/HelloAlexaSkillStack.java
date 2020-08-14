package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.FunctionProps;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.s3.Bucket;

public class HelloAlexaSkillStack extends Stack {
    public HelloAlexaSkillStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public HelloAlexaSkillStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // Get source code code from S3 bucket
        Code sourceCode = Code.fromBucket(
                Bucket.fromBucketName(this,
                        "alexa-skill",
                        "alexa-skill-hello-lambdas"),
                "HelloAlexaSkillLambda-1.0-jar-with-dependencies.jar"
        );

        // Lambda properties
        FunctionProps properties = FunctionProps.builder()
                .runtime(Runtime.JAVA_8)
                .code(sourceCode)
                .handler("com.alexa.skill.HelloWorldStreamHandler").build();

        // Define a new Lambda resource
        final Function alexaskill = new Function(this, "SkillHandler", properties);
    }
}
