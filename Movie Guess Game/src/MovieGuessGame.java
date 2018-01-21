import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieGuessGame {

	private static Scanner sc;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] movies= readFormFile("movies.txt");
		
		if(movies!=null)
		{
			Scanner sc = new Scanner(System.in);
			int numberOfMisses=0;
			String missesCharechters="";
			int rand = (int) (Math.random()*(movies.length-1));
			String chosenMovie = movies[rand];
			String movieDashs="";
			for (int i=0;i<chosenMovie.length();i++) {
				if(chosenMovie.charAt(i)==' ')
					movieDashs+=" ";
				else
					movieDashs+="_";
			}
			System.out.println("You are guessing: "+movieDashs);
			System.out.println("You have guessed ("+numberOfMisses+") wrong letters:");

			while(movieDashs.contains("_"))
			{
				boolean flag=false;
				System.out.println("Guess a letter: ");
				char c= sc.next().charAt(0);
				
				char[] chararray = movieDashs.toCharArray();
				for(int i=0;i<chosenMovie.length();i++)
				{
					if(chosenMovie.charAt(i)==c) {
						chararray[i]=c;
						flag=true;
					}
				}
				movieDashs = new String(chararray);
				
				if(!flag) {
					missesCharechters+=c;
					missesCharechters+=" ";
					numberOfMisses++;
				}
				
				System.out.println("You are guessing: "+movieDashs);
				System.out.println("You have guessed ("+numberOfMisses+") wrong letters:"+missesCharechters);

				if(chosenMovie.equals(movieDashs))
				{
					System.out.println("You Win!");
					break;
				}
				
				


				if(numberOfMisses==10)
				{
					System.out.println("You lose!");
					System.out.println("The correct answer is: "+chosenMovie);
					break;
				}
				
				
			}
			
		}
		
	}
	
	public static String[] readFormFile(String fileName) {
		try {
			String[] moviesArray = new String[50];
			File file = new File(fileName);
			sc = new Scanner(file);
			int i = 0;
			while(sc.hasNextLine()) {
				moviesArray[i++]=sc.nextLine();
			}
			String[] resizedArray = new String[i];
			System.arraycopy(moviesArray, 0, resizedArray, 0, i);
			return resizedArray;
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			return null;
		}
	}

}
