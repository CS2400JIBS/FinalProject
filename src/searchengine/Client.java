package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws FileNotFoundException  {
		
		Dictionary dictionary = new Dictionary("collection");
		dictionary.invertedIndex();
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word(s) to query: ");		
		String query = input.nextLine();
		dictionary.query(query);
	    input.close();

	}

}
