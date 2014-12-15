import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Utilities {
	
	static final int numberOfMovies = 200;
	static final int numberOfFeatures = 23;
	
	ArrayList<Record> Records;
	
	public ArrayList<Movie> GetMoviesFromFile(String fileName) throws NumberFormatException, IOException
	{
		ArrayList<Movie> Movies = new ArrayList<Movie>();
		
		readFile(fileName);
		
		Movies = ConvertRecordsToMovies();
		
		return Movies;
	}
	
	private void readFile(String fileName) throws NumberFormatException, IOException
	{
		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		Records = new ArrayList<Record>();
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			
			String lineParts[] = line.split(";");
			
			if(lineParts.length != 4) continue;
			
			int id = Integer.parseInt(lineParts[0]);
			int movieId = Integer.parseInt(lineParts[1]);
			int featureId = Integer.parseInt(lineParts[2]);
			String value = lineParts[3];

			Record record = new Record(id, movieId, featureId, value);			
			Records.add(record);
		}
		br.close();
	}
	
	private ArrayList<Movie> ConvertRecordsToMovies()
	{
		ArrayList<Movie> Movies = new ArrayList<Movie>();
		
		for(int i=1; i<=numberOfMovies; i++)
		{
			int collectionId = 0;
		    double budget = 0;
		    int[] genresIds = null;
		    double popularity = 0;
		    int[] productionCompaniesIds = null;
		    String[] productionCountriesIso = null;
		    int releaseDate= 0;
		    double revenue= 0;
		    int runtime= 0;
		    String[] spokenLanguagesIso = null;
		    double voteAverage= 0;
		    int voteCount= 0;
		    int[] castIds = null;
		    int[] costumeMakeUpIds = null;
		    int[] directingIds = null;
		    int[] cameraIds = null;
		    int[] editingIds = null;
		    int[] productionIds = null;
		    int[] soundIds = null;
		    int[] writingIds = null;
		    int[] artIds = null;
		    int[] crewIds = null;
		    int[] visualEffectsIds = null;
		    
			for(int j=1; j<=numberOfFeatures; j++)
			{
			    int recordId = GetRecordId(i, j);
			    
				switch(j)
				{
				case 1:
					if(Records.get(recordId-1).Value.equals("null"))
					{
						collectionId = 0;
					}
					else
					{
						collectionId = Integer.parseInt(Records.get(recordId-1).Value);
					}
					break;
				case 2:
					budget = Double.parseDouble(Records.get(recordId-1).Value);
					break;
				case 3:
					genresIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 4:
					popularity = Double.parseDouble(Records.get(recordId-1).Value);
					break;
				case 5:
					productionCompaniesIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 6:
					productionCountriesIso = ConvertNumerousStringsToStringTable(Records.get(recordId-1).Value);
					break;
				case 7:
					releaseDate = GetReleaseYear(Records.get(recordId-1).Value);
					break;
				case 8:
					revenue = Double.parseDouble(Records.get(recordId-1).Value);
					break;
				case 9:
					runtime = Integer.parseInt(Records.get(recordId-1).Value);
					break;
				case 10:
					spokenLanguagesIso = ConvertNumerousStringsToStringTable(Records.get(recordId-1).Value);
					break;
				case 11:
					voteAverage = Double.parseDouble(Records.get(recordId-1).Value);
					break;
				case 12:
					voteCount = Integer.parseInt(Records.get(recordId-1).Value);
					break;
				case 13:
					castIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 14:
					costumeMakeUpIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 15:
					directingIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 16:
					cameraIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 17:
					editingIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 18:
					productionIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 19:
					soundIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 20:
					writingIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 21:
					artIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 22:
					crewIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				case 23:
					visualEffectsIds = ConvertNumerousStringsToIntTable(Records.get(recordId-1).Value);
					break;
				}
			}
			Movie movie = new Movie(collectionId, budget, genresIds, popularity, productionCompaniesIds, productionCountriesIso, releaseDate, revenue, runtime, spokenLanguagesIso, voteAverage, voteCount, castIds, costumeMakeUpIds, directingIds, cameraIds, editingIds, productionIds, soundIds, writingIds, artIds, crewIds, visualEffectsIds);
			Movies.add(movie);
		}	
		return Movies;
	}

	private int GetRecordId(int movieId, int featureId)
	{
		int recordId = 0;
		
		for(int i=0; i<Records.size(); i++)
		{
			if(Records.get(i).movieId == movieId && Records.get(i).featureId == featureId)
			{
				recordId = Records.get(i).id;
			}
		}
		return recordId;
	}
	
	private int[] ConvertNumerousStringsToIntTable(String text)
	{
		if(!text.equals("null"))
		{
			String[] tempTable = text.split("/");
			int[] table = new int[tempTable.length];
			
			for(int i=0; i<tempTable.length; i++)
			{
				table[i] = Integer.parseInt(tempTable[i]);
			}
			return table;
		}
		else
		{
			return null;
		}
	}
	
	private String[] ConvertNumerousStringsToStringTable(String text)
	{
		if(!text.equals("null"))
		{
			String[] table = text.split("/");
			return table;
		}
		else
		{
			return null;
		}
	}
	
	private int GetReleaseYear(String text) {
		
		String[] table = text.split("-");
		return Integer.parseInt(table[0]);
	}
}
