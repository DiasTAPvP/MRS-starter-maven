package dk.easv.mrs.DAL;
//Project Imports
import dk.easv.mrs.BE.Movie;

//Java Imports
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDAO_File implements IMovieDataAccess {

    //Relative path ((checks from the project root folder))
    private static final String MOVIES_FILE = "data/movie_titles.txt";
    //private Path filePath = Paths.get(MOVIES_FILE);
    //^ Alternative way to define path for the getAllMovies method

    /**
     * Reads all movies from the file
     * @return
     * @throws IOException
     */
    //The @Override annotation is not required, but is recommended for readability
    // and to force the compiler to check and generate error msg. if needed etc.

    @Override
    public List<Movie> getAllMovies() throws IOException {

        // Read all lines from file
        List<String> lines = Files.readAllLines(Paths.get(MOVIES_FILE));
        //readAllLines(filePath); if using alternative Path filePath

        //Create list of movie objects
        List<Movie> movies = new ArrayList<>();

        // Parse each line as movie
        //Loop through all lines in the file (List)
        for (String line : lines) {
            //Map data to object
            String[] separatedLine = line.split(",");

            int id = Integer.parseInt(separatedLine[0]);
            int year = Integer.parseInt(separatedLine[1]);
            String title = separatedLine[2];

            if (separatedLine.length > 3) {
                for (int i = 3; i < separatedLine.length; i++) {
                    title += "," + separatedLine[i];
                }
            }
            //Create movie object and add to the movies list
            Movie movie = new Movie(id, year, title);
            movies.add(movie);
        }
        return movies;
    }

    /**
     * Creates a new movie in the file
     * @param title
     * @param year
     * @return
     * @throws Exception
     */
    @Override
    public Movie createMovie(String title, int year) throws Exception {
        List<String> movies = Files.readAllLines(Paths.get(MOVIES_FILE));

        if (movies.size() > 0) {
            // get next id
            String[] separatedLine = movies.get(movies.size() - 1).split(",");
            int nextId = Integer.parseInt(separatedLine[0]) + 1;
            String newMovieLine = nextId + "," + year + "," + title;
            Files.write(Paths.get(MOVIES_FILE), (newMovieLine + "\r\n").getBytes(), StandardOpenOption.APPEND);

            return new Movie(nextId, year, title);
        }
        return null;
    }

    /**
     * Updates a movie in the file
     * @param movie
     * @throws Exception
     */
    @Override
    public void updateMovie(Movie movie) throws Exception {
    }

    /**
     * Deletes a movie from the file
     * @param movie
     * @throws Exception
     */
    @Override
    public void deleteMovie(Movie movie) throws Exception {
    }
}