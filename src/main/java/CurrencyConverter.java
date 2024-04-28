import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class CurrencyConverter {
    private static final String API_KEY = "0800004aa422914f2f2c76d6";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static JSONObject getRates(String baseCurrency) {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse.getJSONObject("conversion_rates");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
