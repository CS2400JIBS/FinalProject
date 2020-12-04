package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {

	public static void main(String[] args)  {
		
		Dictionary dictionary = new Dictionary("collection");
		
		DocRef test = new DocRef("test");
		LinkedList<DocRef> references = new LinkedList<DocRef>();
		Word word = new Word("word");
		word.addRef("testfile");
		word.addRef("testfile");
		System.out.println("The document: " + word.getRef(1).getDocID() + " has a frequency of " + word.getRef(1).getFrequency());
		System.out.println("Size of reference list: " + word.getReferenceList().size());
		//Scanner input = new Scanner(System.in);
		//System.out.println("Enter a word(s) to query: ");		
		//String query = input.nextLine();
		//dictionary.query(query);
		//String query = input.nextLine();
		
		System.out.print("Current Time in milliseconds = ");
	    System.out.println(System.currentTimeMillis());
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word(s) to query: ");

		//String query = input.nextLine();
		//dictionary.query(query);
		//String query = input.nextLine();
	}

}
