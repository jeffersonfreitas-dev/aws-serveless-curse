package dev.jeffersonfreitas.aws;

import java.util.HashMap;
import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class PostHandler implements RequestHandler<Map<String, String>, Map<String, String>> {

    public Map<String, String> handleRequest(final Map<String, String> input, final Context context) {
        Map<String, String> response = new HashMap<>();
        return response;
    }
}
