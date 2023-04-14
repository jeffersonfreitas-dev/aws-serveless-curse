package helloworld;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class App implements RequestHandler<Map<String, String>, Map<String, String>> {

    public Map<String, String> handleRequest(final Map<String, String> input, final Context context) {
        String firstName = input.get("firstName");
        String lastName = input.get("lastName");
        String email = input.get("email");
        String password = input.get("password");
        String repeatPassword = input.get("repeatPassword");

        LambdaLogger logger = context.getLogger();
        logger.log("\n firstName = " + firstName);
        logger.log("\n lastName = " + lastName);
        logger.log("\n email = " + email);

        Map<String, String> response = new HashMap<>();
        response.put("id", UUID.randomUUID().toString());
        response.put("firstName", firstName);
        response.put("lastName", lastName);
        response.put("email", email);
        return response;
    }

}
