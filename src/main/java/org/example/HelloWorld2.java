package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;


import java.util.Map;

public class HelloWorld2 implements RequestHandler<Map<String, Object>, String> {

    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("context.getAwsRequestId() : " + context.getAwsRequestId()+"\n");
        logger.log("context.getLogStreamName() : " + context.getLogStreamName()+"\n");
        logger.log("context.getLogGroupName() : " + context.getLogGroupName()+"\n");
        logger.log("context.getInvokedFunctionArn() : " + context.getInvokedFunctionArn()+"\n");
        logger.log("context.getMemoryLimitInMB() : " + context.getMemoryLimitInMB()+"\n");
        logger.log("context.getFunctionVersion() : " + context.getFunctionVersion()+"\n");

        return "what the~";
    }
}
