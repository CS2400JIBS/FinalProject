package searchengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args)  {
		
		
		try
		{
			//Get File Directory from user
			/*
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter path to file directory: ");
			String path =scan.nextLine();
			File directory = new File(path);
			*/
			
			//
			File directory = new File("collection");
			
			int fileCounter = 0;

			for (File file : directory.listFiles()) {
			    Scanner fileScan = new Scanner(file);
			    fileCounter++;
			    System.out.println(fileCounter);
			    fileScan.close();
			}
			
		} 
		catch (Exception e) {
			System.out.println("Error in file directory.");
		}

	}

}
