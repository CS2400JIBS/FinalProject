package searchengine;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Dictionary {
	
	/**
	 * List of words
	 */
	@SuppressWarnings("unused")
	private LinkedList<Word> dictionary = new LinkedList<Word>();
	
	/**
	 * Name of folder/directory where all the documents are stored
	 */
	@SuppressWarnings("unused")
	private String folder;
	
	Dictionary(String folder) {
		try
		{		
			this.folder=folder;
			File directory = new File(folder);
			
			int fileCounter = 0;

			for (File file : directory.listFiles()) { //Iterate through each file in the "collection" directory
				
			    Scanner fileScan = new Scanner(file);
			    System.out.println("File name: " + file.getName());

		        while(fileScan.hasNext()) //Read every line in each of the documents
		        {
		            String reader = fileScan.nextLine();
		            String delims = "[ ,.;-]+";
		            String [] line = reader.split(delims);
		            
		            for(int n = 0; n < line.length; n++) //Iterate through each word in the line
		            {
		                if(true)//(does not match with stopword)
		                {
		                    String str = line[n];
		                    str = str.toLowerCase(); //set all words to lowercase
		                    Word word  = new Word(str);
		                    System.out.println(str);
		                    
		                    // Add doc reference to word object
		                    
		                    // If doc reference exists, increase frequency
		                    
		                    // Add to tree dictionary if it does not already exist in dictionary
		                    dictionary.add(word);
		                    		                                       
		                    
		                }
		            }
		        }
		        
		        fileCounter++;
			    
			    System.out.println(fileCounter);
			    
			    fileScan.close();
		        break;
		        
		        //Test to see if all files are being read

			    
			}
			
		} 
		catch (Exception e) {
			System.out.println("Error in file directory.");
		}
	}
	
	public Word query(String str) {
		Word word = new Word(str);
		//Return Word object if it is in the dictionary
		int index = (dictionary.indexOf(word));
		if (index == -1){
			return null;
		}
		else {
			word = dictionary.get(index);
			
		}
		//If Word object does not exist in dictionary, return null
		return null;
	}
	
	public String getWordOne()
   {
      return dictionary.get(0).getWord();
   }

	
	
}
