package Models;

import com.google.gson.annotations.SerializedName;

public class MovieInfo {
    @SerializedName("Title")  //This is the name in the JSON file
    private String title;     //This is the variable name in Java

    @SerializedName("Year")
    private String year;

    private String imdbID;

    @SerializedName("Type")
    private String type;

    @SerializedName("Poster")
    private String poster;

    public MovieInfo(String title, String year, String imdbID, String type, String poster) {
        setTitle(title);
        setYear(year);
        setImdbID(imdbID);
        setType(type);
        setPoster(poster);
    }

    public void validateInstanceVariables()
    {
        setTitle(title);
        setYear(year);
        setImdbID(imdbID);
        setType(type);
        setPoster(poster);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String toString()
    {
        return String.format("%s produced in %s",title,year);
    }
}
