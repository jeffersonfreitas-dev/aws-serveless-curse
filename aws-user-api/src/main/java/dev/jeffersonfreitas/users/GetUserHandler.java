package dev.jeffersonfreitas.users;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;

import java.util.Map;

public class GetUserHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        Map<String, String> pathParameters = input.getPathParameters();
        String userId = pathParameters.get("userId");
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        JsonObject returnObject = new JsonObject();
        returnObject.addProperty("firstName", "Jefferson");
        returnObject.addProperty("lastName", "Moreira");
        returnObject.addProperty("id", userId);

        response.withStatusCode(200).withBody(returnObject.toString());
        return response;
    }
}
