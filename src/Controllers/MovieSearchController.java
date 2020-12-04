package Controllers;

import Models.ApiResponseModel;
import Models.MovieInfo;
import Utilities.JsonFileUtility;
import Utilities.OMDBApiUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieSearchController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<MovieInfo> listView;

    @FXML
    private ImageView imageView;

    @FXML
    private Label totalMoviesLabel;

    @FXML
    private Label numberShowingLabel;

    private ApiResponseModel response;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberShowingLabel.setText("");
        totalMoviesLabel.setText("");

        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, movieSelected) -> {
                    imageView.setImage(new Image(movieSelected.getPoster()));
                });
    }

    @FXML
    private void searchButton()
    {
        String searchText = searchTextField.getText();
        searchText = searchText.replace(" ", "%20");

        //call the API and save the JSON file to the hard drive
        OMDBApiUtility.getMovieFromSearch(searchText);

        //read the json file and create an APIResponseModel
        File jsonFile = new File("src/Utilities/movies.json");
        response = JsonFileUtility.getApiInfoFromJson(jsonFile);

        updateScene();
    }

    private void updateScene()
    {
        listView.getItems().clear();
        totalMoviesLabel.setText("Total Movies: "+response.getTotalResults());
        listView.getItems().addAll(response.getMovies());
        numberShowingLabel.setText("Number showing: "+listView.getItems().size());
    }
}