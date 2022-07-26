import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //GET HTTP REQUEST
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI enderecoUrl = URI.create(url);

        var newHttpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(enderecoUrl).GET().build();

        HttpResponse<String> response = newHttpClient.send(request, BodyHandlers.ofString());
        String body = response.body();

        // System.out.println(body);
        var parser = new JsonParse();
        List<Map<String, String>> listFilmes = parser.parse(body);


        for (Map<String,String> filme : listFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            // System.out.println(filme.get());
        }
    }
}
