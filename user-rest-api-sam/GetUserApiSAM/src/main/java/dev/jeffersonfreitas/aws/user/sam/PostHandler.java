package dev.jeffersonfreitas.aws.user.sam;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PostHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("Handling HTTP Post request for the /users API endpoint");

        String requestBody = input.getBody();
        Gson gson = new Gson();

        Map<String, String> userDetails = gson.fromJson(requestBody, Map.class);
        userDetails.put("userId", UUID.randomUUID().toString());

        Map returnValue = new HashMap();
        returnValue.put("firstName", userDetails.get("firstName"));
        returnValue.put("lastName", userDetails.get("lastName"));
        returnValue.put("userId", userDetails.get("userId"));

        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.withStatusCode(200);
        responseEvent.withBody(gson.toJson(returnValue, Map.class));

        Map responseHeaders = new HashMap();
        responseHeaders.put("Content-Type", "application/json");
        responseEvent.withHeaders(responseHeaders);
        return responseEvent;
    }

}
