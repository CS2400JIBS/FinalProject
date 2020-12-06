package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {

<<<<<<< Updated upstream
	public static void main(String[] args)  {
		
		Dictionary dictionary = new Dictionary("collection");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word(s) to query: ");		
=======
	public static void main(String[] args) throws FileNotFoundException {
		
		Dictionary dictionary = new Dictionary("collection");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word(s) to query: ");	
>>>>>>> Stashed changes
		String query = input.nextLine();
		dictionary.query(query);
	    input.close();

	}

}
