package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws FileNotFoundException {
		
		Word word = new Word("word");
		DocRef ref = new DocRef(1000);
		word.addRef(ref);
		
		System.out.println(word.getWord());
		LinkedList<DocRef> references = word.getReferenceList();
		System.out.println(references.getFirst());
		
		Dictionary dictionary = new Dictionary("collection");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word(s) to query: ");	
		
		String query = input.nextLine();
		dictionary.query(query);
	    input.close();

	}

}
