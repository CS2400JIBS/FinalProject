package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException  {
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		Dictionary dictionary = new Dictionary("collection", pw);
		dictionary.invertedIndex();
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		pw.write("Enter a word(s) to query:\n");
		System.out.println("Enter a word(s) to query: ");		
		String query = input.nextLine();
		pw.write(query+"\n");
		dictionary.query(query);
	    input.close();
	    pw.close();

	}

}
