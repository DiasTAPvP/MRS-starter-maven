package dk.easv.mrs.GUI.Model;
//Project Imports
import dk.easv.mrs.BE.Movie;
import dk.easv.mrs.BLL.MovieManager;
//JavaFX Imports
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class MovieModel {

    private ObservableList<Movie> moviesToBeViewed;

    private MovieManager movieManager;

    /**
     * Constructor for MovieModel
     * @throws Exception
     */
    public MovieModel() throws Exception {
        movieManager = new MovieManager();
        moviesToBeViewed = FXCollections.observableArrayList();
        moviesToBeViewed.addAll(movieManager.getAllMovies());
    }

    /**
     * Returns the observable list of movies
     * @return
     */
    public ObservableList<Movie> getObservableMovies() {
        return moviesToBeViewed;
    }

    /**
     * Searches for a movie
     * @param query
     * @throws Exception
     */
    public void searchMovie(String query) throws Exception {
        List<Movie> searchResults = movieManager.searchMovies(query);
        moviesToBeViewed.clear();
        moviesToBeViewed.addAll(searchResults);
    }
}
