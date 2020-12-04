package searchengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {

	public static void main(String[] args)  {
		
		
		Dictionary dictionary = new Dictionary("collection");
		DocRef test = new DocRef("test");
		test.increment();
		DocRef testEquals = new DocRef("test");
		LinkedList<DocRef> references = new LinkedList<DocRef>();
		Word word = new Word("word");
		word.addRef("testfile");
		word.addRef("testfile");
		System.out.println("The document: " + word.getRef(1).getDocID() + " has a frequency of " + word.getRef(1).getFrequency());
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word(s) to query: ");
		String query = input.nextLine();
		dictionary.query(query);
		
	}

}
