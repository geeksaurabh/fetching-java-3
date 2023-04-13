import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Main {
    public static void main(String[] args) {
        try {
            // Set the API endpoint URL
            URL url = new URL("https://api.nationalize.io/?name=nathaniel");

            // Create a new HTTP connection and open it
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Get the response code
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response data in JSON format
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response data in JSON format
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}