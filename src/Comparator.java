import java.util.ArrayList;


public class Comparator {
	
	Movie movie1;
	Movie movie2;
	
	ArrayList<Movie> Movies;
	
    double maxBudgetInSet;
    double minBudgetInSet;
    
    double maxPopularityInSet;
    double minPopularityInSet;

    int maxReleaseDateInSet;
    int minReleaseDateInSet;
    
    double maxRevenue;
    double minRevenue;
    
    int maxRuntime;
    int minRuntime;

    double maxVoteAverage;
    double minVoteAverage;
    
    int maxVoteCount;
    int minVoteCount;
	
	Comparator(Movie movie1, Movie movie2, ArrayList<Movie> Movies)
	{
		this.movie1 = movie1;
		this.movie2 = movie2;
		this.Movies = Movies;
		
		CalculateMinMaxValues();
	}
	
	public void CalculateMinMaxValues()
	{
	    this.maxBudgetInSet = GetMaxBudgetInSet();
	    this.minBudgetInSet = GetMinBudgetInSet();
	    
	    this.maxPopularityInSet = GetMaxPopularityInSet();
	    this.minPopularityInSet = GetMinPopularityInSet();

	    this.maxReleaseDateInSet = GetMaxReleaseDateInSet();
	    this.minReleaseDateInSet = GetMinReleaseDateInSet();
	    
	    this.maxRevenue = GetMaxRevenue();
	    this.minRevenue = GetMinRevenue();
	    
	    this.maxRuntime = GetMaxRuntime();
	    this.minRuntime = GetMinRuntime();

	    this.maxVoteAverage = GetMaxVoteAverage();
	    this.minVoteAverage = GetMinVoteAverage();
	    
	    this.maxVoteCount = GetMaxVoteCount();
	    this.minVoteCount = GetMinVoteCount();
	}
	
	public double GetSimilarityRateForCollection()
	{
		double similarityRate = 0;
		
		if(movie1.collectionId == movie2.collectionId) //if the same collection or if no collection
		{
			similarityRate = 1;
		}
		else if(movie1.collectionId != 0 && movie2.collectionId != 0) //if different collections
		{
			similarityRate = 0.5;
		}
		else //if one belongs to the collection and second doesn't
		{
			similarityRate = 0;
		}
		
		System.out.println("Collection similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForBudget()
	{
		double similarityRate = calculateNumbersSimilarity(movie1.budget, movie2.budget, minBudgetInSet, maxBudgetInSet);
		
		System.out.println("Budget similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForGenre() //TODO more sophisticated way, e.g. thriller is similar to action movie
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.genresIds, movie2.genresIds);
		
		System.out.println("Genre similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForPopularity()
	{
		double similarityRate = calculateNumbersSimilarity(movie1.popularity, movie2.popularity, minPopularityInSet, maxPopularityInSet);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForProductionCompanies()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.productionCompaniesIds, movie2.productionCompaniesIds);
		
		System.out.println("Production companies similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForProductionCountries()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.productionCountriesIso, movie2.productionCountriesIso);
		
		System.out.println("Production countries similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForReleaseDate() //TODO more sophisticated way, e.g. division for decades 60s, 70s, 80s, 90s etc.
	{
		double similarityRate = calculateNumbersSimilarity(movie1.releaseDate, movie2.releaseDate, minReleaseDateInSet, maxReleaseDateInSet);
		
		System.out.println("Release date similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForRevenue()
	{
		double similarityRate = calculateNumbersSimilarity(movie1.revenue, movie2.revenue, minRevenue, maxRevenue);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForRuntime()
	{
		double similarityRate = calculateNumbersSimilarity(movie1.runtime, movie2.runtime, minRuntime, maxRuntime);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForSpokenLanguages()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.spokenLanguagesIso, movie2.spokenLanguagesIso);
		
		System.out.println("Spoken language similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForVoteAverage()
	{
		double similarityRate = calculateNumbersSimilarity(movie1.voteAverage, movie2.voteAverage, minVoteAverage, maxVoteAverage);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForVoteCount()
	{
		double similarityRate = calculateNumbersSimilarity(movie1.voteCount, movie2.voteCount, minVoteCount, maxVoteCount);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForCast() //probably it will have quite a high weight
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.castIds, movie2.castIds);
		
		System.out.println("Cast similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForCostumeMakeUp()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.costumeMakeUpIds, movie2.costumeMakeUpIds);
		
		System.out.println("Costume & Make-Up similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForDirecting()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.directingIds, movie2.directingIds);
		
		System.out.println("Directing similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForCamera()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.cameraIds, movie2.cameraIds);
		
		System.out.println("Camera similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForEditing()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.editingIds, movie2.editingIds);
		
		System.out.println("Editing similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForProduction()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.productionIds, movie2.productionIds);
		
		System.out.println("Production similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForSound()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.soundIds, movie2.soundIds);
		
		System.out.println("Sound similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForWriting()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.writingIds, movie2.writingIds);
		
		System.out.println("Writing similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForArt()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.artIds, movie2.artIds);
		
		System.out.println("Art similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForCrew()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.crewIds, movie2.crewIds);
		
		System.out.println("Crew similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	public double GetSimilarityRateForVisualEffects()
	{
		double similarityRate = calculateTwoSetsSimilarity(movie1.visualEffectsIds, movie2.visualEffectsIds);
		
		System.out.println("Visual effects similarity = " + similarityRate);
		
		return similarityRate;
	}
	
	//*********** UTILITIES ***********
	
	private double GetMaxBudgetInSet() {

		double maxBudget = Double.MIN_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(maxBudget < Movies.get(i).budget)
			{
				maxBudget = Movies.get(i).budget;
			}
		}
		return maxBudget;
	}
	
	private double GetMinBudgetInSet() {
		
		double minBudget = Double.MAX_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(minBudget > Movies.get(i).budget)
			{
				minBudget = Movies.get(i).budget;
			}
		}
		return minBudget;
	}
	
	private double GetMaxPopularityInSet() {

		double maxPopularity = Double.MIN_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(maxPopularity < Movies.get(i).popularity)
			{
				maxPopularity = Movies.get(i).popularity;
			}
		}
		return maxPopularity;
	}
	
	private double GetMinPopularityInSet() {

		double minPopularity = Double.MAX_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(minPopularity > Movies.get(i).popularity)
			{
				minPopularity = Movies.get(i).popularity;
			}
		}
		return minPopularity;
	}
	
	private int GetMaxReleaseDateInSet() {

		int maxReleaseDate = Integer.MIN_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(maxReleaseDate < Movies.get(i).releaseDate)
			{
				maxReleaseDate = Movies.get(i).releaseDate;
			}
		}
		return maxReleaseDate;
	}
	
	private int GetMinReleaseDateInSet() {

		int minReleaseDate = Integer.MAX_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(minReleaseDate > Movies.get(i).releaseDate)
			{
				minReleaseDate = Movies.get(i).releaseDate;
			}
		}
		return minReleaseDate;
	}
	
	private double GetMaxRevenue() {

		double maxRevenue = Double.MIN_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(maxRevenue < Movies.get(i).revenue)
			{
				maxRevenue = Movies.get(i).revenue;
			}
		}
		return maxRevenue;
	}
	
	private double GetMinRevenue() {

		double minRevenue = Double.MAX_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(minRevenue > Movies.get(i).revenue)
			{
				minRevenue = Movies.get(i).revenue;
			}
		}
		return minRevenue;
	}
	
	private int GetMaxRuntime() {

		int maxRuntime = Integer.MIN_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(maxRuntime < Movies.get(i).runtime)
			{
				maxRuntime = Movies.get(i).runtime;
			}
		}
		return maxRuntime;
	}
	
	private int GetMinRuntime() {

		int minRuntime = Integer.MAX_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(minRuntime > Movies.get(i).runtime)
			{
				minRuntime = Movies.get(i).runtime;
			}
		}
		return minRuntime;
	}
	
	private double GetMaxVoteAverage() {

		double maxVoteAverage = Double.MIN_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(maxVoteAverage < Movies.get(i).voteAverage)
			{
				maxVoteAverage = Movies.get(i).voteAverage;
			}
		}
		return maxVoteAverage;
	}
	
	private double GetMinVoteAverage() {

		double minVoteAverage = Double.MAX_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(minVoteAverage > Movies.get(i).voteAverage)
			{
				minVoteAverage = Movies.get(i).voteAverage;
			}
		}
		return minVoteAverage;
	}
	
	private int GetMaxVoteCount() {

		int maxVoteCount = Integer.MIN_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(maxVoteCount < Movies.get(i).voteCount)
			{
				maxVoteCount = Movies.get(i).voteCount;
			}
		}
		return maxVoteCount;
	}
	
	private int GetMinVoteCount() {

		int minVoteCount = Integer.MAX_VALUE;
		
		for(int i=0; i<Movies.size(); i++)
		{
			if(minVoteCount > Movies.get(i).voteCount)
			{
				minVoteCount = Movies.get(i).voteCount;
			}
		}
		return minVoteCount;
	}
	
	private double calculateNumbersSimilarity(double x, double y, double min, double max)
	{
		return (1 - (Math.abs(x - y)/(max - min)));
	}
	
	private double calculateTwoSetsSimilarity(int[] set1, int[] set2)
	{
		double similarityRate = 0;
		
		int maxPossibleMatches = 0;
		int numberOfMathingElements = 0;
		
		if(set1 != null && set2 != null)
		{
			if(set1.length == set2.length)
			{
				maxPossibleMatches = set1.length;
			}
			else
			{
				if(set1.length > set2.length)
				{
					maxPossibleMatches = set2.length;
				}
				else
				{
					maxPossibleMatches = set1.length;
				}
			}
			numberOfMathingElements = getNumberOfMatchingElements(set1, set2);
		}
		
		similarityRate = numberOfMathingElements / maxPossibleMatches;
		
		return similarityRate;
	}
	
	private double calculateTwoSetsSimilarity(String[] set1, String[] set2)
	{
		double similarityRate = 0;
		
		int maxPossibleMatches = 0;
		int numberOfMathingElements = 0;
		
		if(set1 != null && set2 != null)
		{
			if(set1.length == set2.length)
			{
				maxPossibleMatches = set1.length;
			}
			else
			{
				if(set1.length > set2.length)
				{
					maxPossibleMatches = set2.length;
				}
				else
				{
					maxPossibleMatches = set1.length;
				}
			}
			numberOfMathingElements = getNumberOfMatchingElements(set1, set2);
		}
		
		similarityRate = numberOfMathingElements / maxPossibleMatches;
		
		return similarityRate;
	}
	
	private int getNumberOfMatchingElements(int[] set1, int[] set2)
	{
		int numberOfMathingElements = 0;
		
		if(set1 != null && set2 != null)
		{
			for(int i=0; i<set1.length; i++)
			{
				for(int j=0; j<set2.length; j++)
				{
					if(set1[i] == set2[j])
					{
						numberOfMathingElements++;
					}
				}
			}
		}
		return numberOfMathingElements;
	}
	
	private int getNumberOfMatchingElements(String[] set1, String[] set2)
	{
		int numberOfMathingElements = 0;
		
		if(set1 != null && set2 != null)
		{
			for(int i=0; i<set1.length; i++)
			{
				for(int j=0; j<set2.length; j++)
				{
					if(set1[i] == set2[j])
					{
						numberOfMathingElements++;
					}
				}
			}
		}
		return numberOfMathingElements;
	}
}
