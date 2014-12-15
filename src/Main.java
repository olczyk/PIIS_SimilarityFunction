import java.io.IOException;
import java.util.ArrayList;


public class Main {

	static final String fileName = "records.csv";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Utilities util = new Utilities();
		ArrayList<Movie> Movies = util.GetMoviesFromFile(fileName);
		
		Comparator comparator = new Comparator(Movies.get(0), Movies.get(1), Movies);
		comparator.GetSimilarityRateForBudget();
		
		System.out.println();
	}
}