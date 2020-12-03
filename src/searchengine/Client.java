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
		references.add(test);
		
		if(references.contains(testEquals))
			System.out.println("Equals overrided");
		else
			System.out.println("Override equals failed");
	}

}
