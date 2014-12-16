import java.io.IOException;
import java.util.ArrayList;


public class Main {

	static final String fileName = "records.csv";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Utilities util = new Utilities();
		ArrayList<Movie> Movies = util.GetMoviesFromFile(fileName);
		
		Comparator comparator = new Comparator(Movies.get(78), Movies.get(110), Movies); //comparing Kill Bill: Vol. 1 with Pulp Fiction
		comparator.GetMoviesSimilarityRate();
	}
}