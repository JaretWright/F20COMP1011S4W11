package Models;

import com.google.gson.annotations.SerializedName;

public class ApiResponseModel {
    @SerializedName("Search")
    private MovieInfo[] movies;

    private String totalResults;

    @SerializedName("Response")
    private String response;

    public MovieInfo[] getMovies() {
        return movies;
    }

    public void setMovies(MovieInfo[] movies) {
        this.movies = movies;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
