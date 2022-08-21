package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Map;

public class HelloWorld3 implements RequestHandler<Map<String, Object>, String> {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorld3.class);

    @Override
    public String handleRequest(Map<String, Object> input, Context context) {

        logger.info(">> this : {}", this.hashCode());

        logger.info("context.getAwsRequestId() : " + context.getAwsRequestId() + "\n");
        logger.info("context.getLogStreamName() : " + context.getLogStreamName() + "\n");
        logger.info("context.getLogGroupName() : " + context.getLogGroupName() + "\n");
        logger.info("context.getInvokedFunctionArn() : " + context.getInvokedFunctionArn() + "\n");
        logger.info("context.getMemoryLimitInMB() : " + context.getMemoryLimitInMB() + "\n");
        logger.info("context.getFunctionVersion() : " + context.getFunctionVersion() + "\n");

        return "what the HelloWorld3";
    }
}
