import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class MyHttpClient {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://localhost:8080/hello");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            Map<String, List<String>> defaultHeaders = con.getRequestProperties();
            printHeader(defaultHeaders);

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while((line = reader.readLine()) != null){
                    response.append(line);
                }
                reader.close();
                System.out.println("Response: " + response.toString());
            }
            else{
                System.out.println("Request failed");
            }

        }
        catch(IOException e){
            System.out.println("Error during connection " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printHeader(Map<String, List<String>>headers){
        System.out.println("DEFAULT REQUEST HEADERS");
        headers.forEach((key, value) -> {
            if(key != null){
                System.out.println(key + ": " + String.join(", ", value));
            }
        });
    }
}
