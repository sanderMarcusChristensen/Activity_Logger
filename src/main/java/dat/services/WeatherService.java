package dat.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherService {
    public static <T> T getWeatherService(Class<T> dtoClass, String uri) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Create an HttpClient instance with automatic redirect handling
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .followRedirects(HttpClient.Redirect.ALWAYS) // Follow redirects automatically
                    .build();

            // Create a request
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .header("Accept", "application/json")
                    .uri(new URI(uri))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check the status code and return the DTO if successful
            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), dtoClass);
            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
