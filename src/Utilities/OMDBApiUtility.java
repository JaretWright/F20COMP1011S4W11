package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OMDBApiUtility {

    public static void getMovieFromSearch(String searchText)
    {
        //precautionary step to clear out the old file.
        File file = new File("src/Utilities/movies.json");
        if (file.exists())
            file.delete();

        String searchURL = "http://www.omdbapi.com/?apikey=4a1010ab&s="+searchText;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(searchURL)).build();

        try {
            HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(
                                                            Paths.get("src/Utilities/movies.json")));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
