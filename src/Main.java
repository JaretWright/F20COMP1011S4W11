import Models.ApiResponseModel;
import Models.MovieInfo;
import Utilities.JsonFileUtility;
import Utilities.OMDBApiUtility;

import java.io.File;

public class Main {
    public static void main(String[] args) {
//        ApiResponseModel apiResponse = JsonFileUtility.getApiInfoFromJson(new File("src/Utilities/movies.json"));
        OMDBApiUtility.getMovieFromSearch("Howard");
        System.out.println();
    }
}
