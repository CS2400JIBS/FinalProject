package searchEngine;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Dictionary {
	
	/**
	 * List of words
	 */
	public LinkedList<Word> dictionary = new LinkedList<Word>();
	
	/**
	 * Name of folder/directory where all the documents are stored
	 */
	private String folder;
	
	/**
	 * The list of stopwords or words that are considered unimportant for the dictionary of words found in a set of documents
	 */
	private String [] stopWord = 
	   {
			   "a","an","and","are","as","at",
			   "be","by",
			   "for","from",
			   "has","he",
			   "in","is","it","its",
			   "of","on",
			   "that","the","to",
			   "was","were","will","with",
			   "."
         };
   
	/**
	 * Dictionary Class Constructor
	 * 
	 * @param folder The folder/directory that the dictionary class will be reading and processing from
	 */
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
		            String delims = "(['$?\" ,;-]+)";
		            String [] line = reader.split(delims);
		            
		            for(int n = 0; n < line.length; n++) //Iterate through each word in the line
		            {
		               String str = line[n];
                      str = str.toLowerCase(); //set all words to lowercase
                      Word word  = new Word(str);
                      
		                if(!str.equals("s") && checkStopWord(word))//(does not match with stopword)
		                {

		                    System.out.println(str);
		                    
		                    // Add doc reference to word object
		                    word.addRef(file.getName());
		                    
		                    // Add to tree dictionary if it does not already exist in dictionary
		                    dictionary.add(word);
		                }
		            }
		        }
		        
		        fileCounter++;
			    
			    System.out.println("Files successfully read: " + fileCounter);
			    
			    fileScan.close();
			    
		        break;
		        
		        //Test to see if all files are being read

			    
			}
			
		} 
		catch (Exception e) {
			System.out.println("Error in file directory.");
		}
	}
	
	/**
	 * Checks if a string is a match to any of the words in our list of unimportant words
	 * 
	 * @param word The string that will be compared to the list of unimportant words
	 * @return true if the word is not on the list of unimportant words, return false otherwise
	 */
	public boolean checkStopWord (Word word)
	{
	   for(int i = 0; i < stopWord.length; i++)
	   {
	      if(word.getWord().equals(stopWord[i]))
	      {
	         return false;
	      }
	   }
	   
	   return true;
	}
	
	/**
	 * Traverses the dictionary of words to search for a word(s) query and process the references to output the top 10 most relevant documents to the query
	 * 	
	 * @param strings The words or groups of words the user wishes to search from the documents
	 */
	public void query(String strings) {
		String[] words = strings.split("[ ,:.]");
		if(words.length==1) {
			
		}
	}
}
