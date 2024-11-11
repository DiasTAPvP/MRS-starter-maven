package dk.easv.mrs.DAL;
//Project Imports
import dk.easv.mrs.BE.Movie;
//Java Imports
import java.util.List;

public interface IMovieDataAccess {

    List<Movie> getAllMovies() throws Exception;

    Movie createMovie(String title, int year) throws Exception;

    void updateMovie(Movie movie) throws Exception;

    void deleteMovie(Movie movie) throws Exception;

}
