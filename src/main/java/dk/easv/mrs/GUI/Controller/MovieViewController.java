package dk.easv.mrs.GUI.Controller;
//Project Imports
import dk.easv.mrs.BE.Movie;
import dk.easv.mrs.GUI.Model.MovieModel;
//Java Imports
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieViewController implements Initializable {


    public TextField txtMovieSearch;
    public ListView<Movie> lstMovies;
    private MovieModel movieModel;


    /**
     * Constructor for MovieViewController
     */
    public MovieViewController()  {

        try {
            movieModel = new MovieModel();
        } catch (Exception e) {
            displayError(e);
            e.printStackTrace();
        }
    }

    /**
     * Initializes the MovieViewController
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        lstMovies.setItems(movieModel.getObservableMovies());

        txtMovieSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                movieModel.searchMovie(newValue);
            } catch (Exception e) {
                displayError(e);
                e.printStackTrace();
            }
        });

    }

    /**
     * Displays an error message
     * @param t
     */
    private void displayError(Throwable t)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Something went wrong");
        alert.setHeaderText(t.getMessage());
        alert.showAndWait();
    }
}
