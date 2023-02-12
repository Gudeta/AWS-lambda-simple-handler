package dev.gbesso;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

/*AWS Lambda Java Tutorial: How to use the AWS Lambda Java Core Library*/
/*https://tanzu.vmware.com/developer/guides/serverless-spring/*/
/*<!--Pass this below package name , classname and method in Lambda under Runtime settings and handler--Edit->*/
//dev.gbesso.SimpleHandler::handleRequest
public class SimpleHandler implements RequestHandler<String,String> {

    @Override
    public String handleRequest(String input, Context context) {
        LambdaLogger logger =context.getLogger();
        logger.log("Function ' "+context.getFunctionName() +"' called");
        return input.toUpperCase();
    }
}
