package Models;

import com.google.gson.annotations.SerializedName;

public class ApiResponseModel {
    @SerializedName("Search")
    private MovieInfo[] movies;

    private String totalResults;

    @SerializedName("Response")
    private String response;
}
