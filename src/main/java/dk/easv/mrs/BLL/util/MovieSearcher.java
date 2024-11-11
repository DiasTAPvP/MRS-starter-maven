package dk.easv.mrs.BLL.util;
//Project Imports
import dk.easv.mrs.BE.Movie;
//Java Imports
import java.util.ArrayList;
import java.util.List;

public class MovieSearcher {


    /**
     * Searches for movies in the searchBase that matches the query.
     * @param searchBase The list of movies to search in.
     * @param query The query to search for.
     * @return A list of movies that matches the query.
     */
    public List<Movie> search(List<Movie> searchBase, String query) {
        List<Movie> searchResult = new ArrayList<>();

        for (Movie movie : searchBase) {
            if(compareToMovieTitle(query, movie) || compareToMovieYear(query, movie))
            {
                searchResult.add(movie);
            }
        }

        return searchResult;
    }

    /**
     * Compares the query to the year of the movie.
     * @param query The query to compare.
     * @param movie The movie to compare.
     * @return True if the year of the movie contains the query.
     */
    private boolean compareToMovieYear(String query, Movie movie) {
        return Integer.toString(movie.getYear()).contains(query);
    }

    /**
     * Compares the query to the title of the movie.
     * @param query The query to compare.
     * @param movie The movie to compare.
     * @return True if the title of the movie contains the query.
     */
    private boolean compareToMovieTitle(String query, Movie movie) {
        return movie.getTitle().toLowerCase().contains(query.toLowerCase());
    }

}
