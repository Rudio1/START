import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ViaCep {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Informe o cep:");
            String Infocep = sc.nextLine();
            String url = "https://viacep.com.br/ws/" + Infocep + "/json";
            
            URI endereco = URI.create(url);

            var newHttpClient = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();

            HttpResponse<String> response = newHttpClient.send(request, BodyHandlers.ofString());
            String body = response.body();

            List<String> list = new ArrayList<>();
            list.add(body);
            

            System.out.println(response);

            for (String info: list) {
                System.out.println(info);

            }


        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("...");
        }
        
        sc.close();
    }
}
