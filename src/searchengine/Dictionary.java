package searchEngine;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
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
	 * The list of "stop words" or words that are considered unimportant for the dictionary of words found in a set of documents
	 */
	private String [] stopWord = 
	   {
			   "a","an",/*"and",*/"are","as","at",
			   /*"be",*/"by",
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
			    String fileName = file.getName();
			    
                String[] id = fileName.split("[-.]");
                
                int docID = Integer.parseInt(id[1]);
                

		        while(fileScan.hasNext()) //Read every line in each of the documents
		        {
		            String reader = fileScan.nextLine();
		            String delims = "(['$?/\" ,;-]+)";
		            String [] line = reader.split(delims);
		            
		            for(int n = 0; n < line.length; n++) //Iterate through each word in the line
		            {
		              String str = line[n];
                      str = str.toLowerCase(); //set all words to lowercase
                      Word word  = new Word(str);
                      
		                if(!str.equals("s") && checkStopWord(word))//(does not match with stopword)
		                {
		                    
		                    // Add doc reference to word object
		                   int index = dictionary.indexOf(word);
		                   DocRef ref = new DocRef(docID);
		                   
		                   if(index==-1)
		                   {
		                	   word.addRef(ref);
		                	   dictionary.add(word);
		                   }
		                   else
		                   {
		                	   dictionary.get(index).addRef(ref);
		                   }
		              
		                }
		            }
		        }
		        
		        fileCounter++;
			    if(fileCounter>50) {
			    	break;
			    }
			    fileScan.close();

		        
		        //Test to see if all files are being read

			    
			}
			System.out.println("Words in dictionary: "+dictionary.size());
			
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
	
	public Word search(String str) {
		Word word = new Word(str);
		int index = dictionary.indexOf(word);
		if(index==-1) { //if not found return null
			return null;
		}
		else //return the word node
		{
			return dictionary.get(index);
		}
	}
	
	/**
	 * Traverses the dictionary of words to search for a word(s) query and process the references to output the top 10 most relevant documents to the query
	 * 	
	 * @param strings The words or groups of words the user wishes to search from the documents
	 */
	public void query(String strings) {
		Instant before = Instant.now();
		
		String[] words = strings.split("[ ,:.]");
		if(words.length==1) {
			Word word = this.search(words[0]);
			if(word!=null) //if found in dictionary
			{
				//print the sorted reference list
				word.sortReferences();
				LinkedList<DocRef> references = word.getReferenceList();
				for(int i=0; i<word.getDocFrequency(); i++) {
					System.out.println(references.get(i).toString());
				}
				System.out.println("Length of list: "+references.size());
			}
			else 
			{
				System.out.println("Not found");
			}

		}
		else 
		{
			LinkedList<DocRef> combList = new LinkedList<DocRef>();
			
			LinkedList<DocRef> duplicates = new LinkedList<DocRef>();
			//check intersections
			for(int i=0; i<words.length; i++)
			{
				Word word = this.search(words[i]);
				
				if(word!=null)
				{
					word.sortReferences();
					for(int j=0; j<word.getDocFrequency() && j<20; j++) {
						combList.add(word.getReferenceList().get(j));
					}
				}
			}
			LinkedList<DocRef> finalList = new LinkedList<DocRef>();
			finalList.addAll(combList);
			
			System.out.println("Appended List:");
			Collections.sort(combList);
			Collections.reverse(combList);
			combList.stream().forEach(System.out::println);

			while(!combList.isEmpty())
			{
				DocRef ref=combList.remove();
				int f = ref.getFrequency();
				while(combList.contains(ref))
				{
					ref.setFrequency(ref.getFrequency()+combList.remove(combList.indexOf(ref)).getFrequency());
				}
				if(ref.getFrequency()>f)
					duplicates.add(ref);
			}
			System.out.println("Duplicates List:");
			duplicates.stream().forEach(System.out::println);
			
			System.out.println("Final List:");
			
			finalList.removeAll(duplicates);
			finalList.addAll(duplicates);
			
			Collections.sort(finalList);
			Collections.reverse(finalList);
			finalList.stream().forEach(System.out::println);
			
		}
		
		
		
		Instant after = Instant.now();
		
		System.out.println(Duration.between(before, after).toMillis()+ " miliseconds");
		
	}
}
