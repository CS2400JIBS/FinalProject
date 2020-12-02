package searchengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args)  {
		
		
		try
		{		
			//
			File directory = new File("collection");
			
			int fileCounter = 0;

			for (File file : directory.listFiles()) {
			    Scanner fileScan = new Scanner(file);
			    /*
			    ObjectList list;
		        ObjectList pos;
		        ObjectListNode p;
		        LinePosition lineRef;
		        Word word = new Word(pw);
		        Word dup = new Word(pw);
		        */        
		        int lineCount = 0;
		        while(fileScan.hasNextLine())
		        {
		            lineCount++;
		            String reader = fileScan.nextLine();
		            String delims = "[ ,.;-]+";
		            String [] line = reader.split(delims);
		            
		            for(int n = 0; n < line.length; n++)
		            {
		                
		                if(true)//(does not match with stopword)
		                {
		                    String word = line[n];
		                    word = word.toLowerCase(); //set all words to lowercase
		                    
		                    // Add doc reference to word object
		                    // Add to tree dictionary
		                    // If duplicate increase frequency
		                }
		            }
		        }
		        
		        //Test to see if all files are being read
		        /*
			    fileCounter++;
			    System.out.println(fileCounter);
			    */
			    fileScan.close();
			}
			
		} 
		catch (Exception e) {
			System.out.println("Error in file directory.");
		}

	}

}
