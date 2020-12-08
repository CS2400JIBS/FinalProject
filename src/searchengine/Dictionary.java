package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Dictionary {
	public static int fileCounter=0;
	
	
	/**
	 * List of words
	 */
	private LinkedList<Word> dictionary = new LinkedList<Word>();
	
	/**
	 * Our own data structure
	 */
	private BinarySearchTree dictionaryTree;

	/**
	 * Name of folder/directory where all the documents are stored
	 */
	private String folder;
	
	private PrintWriter pw;
	 
	/**
	 * The list of "stop words" or words that are considered unimportant for the dictionary of words found in a set of documents
	 */
	private String [] stopWord = 
	   {
			   "a","an","and","are","as","at",
			   "be","by",
			   "for","from",
			   "has","he",
			   "in","is","it","its",
			   "of","on",
			   "s",
			   "that","the","to",
			   "was","were","will","with",
			   "."
         };
   
	/**
	 * Dictionary Class Constructor
	 * 
	 * @param folder The folder/directory that the dictionary class will be reading and processing from
	 * @throws FileNotFoundException 
	 */
	Dictionary(String folder, PrintWriter pw) throws FileNotFoundException {
		
		Instant before = Instant.now();
		
		this.pw = pw;
		
		dictionaryTree = new BinarySearchTree(this.pw);
		
		this.folder=folder;
		
		File directory = new File(folder);
		
		for (File file : directory.listFiles()) { //Iterate through each file in the "collection" directory
			
		    Scanner fileScan = new Scanner(file);
		    String fileName = file.getName();
		    
            String[] id = fileName.split("[-.]");
            
            int docID = Integer.parseInt(id[1]);
            

	        while(fileScan.hasNext()) //Read every line in each of the documents
	        {
	            String reader = fileScan.nextLine();
	            String delims = "([0123456789:#!()&'$?/\" ,\\[;-])";
	            String [] line = reader.split(delims);
	            
	            for(int n = 0; n < line.length; n++) //Iterate through each word in the line
	            {
	              String str = line[n].toLowerCase();

                  //Create word object
                  Word word  = new Word(str);
                  
                  //Create reference for that word
                  DocRef ref = new DocRef(docID);
                  
	                if(checkStopWord(word) && !str.isBlank())//(does not match with stopword)
	                {
	                	//add
	                	//search the list for a match to a word
	                	//get the list
	                	
	                	
	                	//DICTIONARY TREE
	                	//Add word to dictionary if not already there
	                	//Otherwise add a reference to the word thats already there
	                	if(this.dictionaryTree.get(word)==null)
	                	{
	                		word.addRef(ref);
	                		this.dictionaryTree.add(word);
	                	}
	                	
	                	else
	                	{
	                		this.dictionaryTree.get(word).addRef(ref);
	                	}
	                   
	                }
	            }
	        }
	        
	        fileCounter++;
	        
	        /*
		    if(fileCounter>20) {
		    	break;
		    }
		    */
		    
		    fileScan.close();

	        
	        //Test to see if all files are being read

		    
		}
		System.out.println("Words in dictionary: "+this.dictionaryTree.size);
		pw.write("Words in dictionary: "+this.dictionaryTree.size+"\n");
		Instant after = Instant.now();
		long duration = Duration.between(before, after).toMillis();
		System.out.println("Time to build dictionary BST: "+duration+ " miliseconds");
		this.pw.write("Time to build dictionary BST: "+duration+ " miliseconds\n");
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
		//Search dictionary for the word
		//If not found will return null
		/*
		
		
		
		
		 */
		Word word = new Word(str);
		int index = dictionary.indexOf(word);
		word=this.dictionaryTree.get(word);
		if(word==null) { //if not found return null
			return null;
		}
		else //return the word node
		{
			return this.dictionaryTree.get(word);
		}
	}
	
	/**
	 * Traverses the dictionary of words to search for a word(s) query and process the references to output the top 10 most relevant documents to the query
	 * 	
	 * @param strings The words or groups of words the user wishes to search from the documents
	 */
	public void query(String strings) {
		Instant before = Instant.now();
		
		String[] words = strings.toLowerCase().split("[ ,:]");
		if(words.length==1) {
			
			//Searches the dictionary for the word
			Word word = this.search(words[0]);
			
			
			if(word!=null) //if found in dictionary
			{
				//print the sorted reference list
				word.sortReferences();
				LinkedList<DocRef> references = word.getReferenceList();
				for(int i=0; i<word.getDocFrequency() && i<10 ; i++) {
					String s = references.get(i).toString();
					System.out.println(s);
					pw.write(s);
				}
				
				this.pw.write("Length of list: "+references.size()+"\n");
				System.out.println("Length of list: "+references.size());
			}
			else 
			{
				this.pw.write("Not found\n");
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
				//Searches the dictionary for the word
				Word word = this.search(words[i]);
				
				if(word!=null)
				{
					//
					word.sortReferences();
					for(int j=0; j<word.getDocFrequency() && j<50; j++) {
						combList.add(word.getReferenceList().get(j));
					}
				}
			}
			LinkedList<DocRef> finalList = new LinkedList<DocRef>();
			finalList.addAll(combList);
			
			this.pw.write("Appended List:\n");
			System.out.println("Appended List:");
			Collections.sort(combList);
			Collections.reverse(combList);
			combList.stream().forEach(System.out::println);
			for(int i=0; i<combList.size(); i++)
				pw.write(combList.get(i).toString()+"\n");

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
			this.pw.write("\nDuplicates List:\n");
			System.out.println("\nDuplicates List:");
			for(int i=0; i<duplicates.size(); i++)
				pw.write(duplicates.get(i).toString()+"\n");
			pw.write("\n");
			duplicates.stream().forEach(System.out::println);
			System.out.println();
			
			this.pw.write("Final List:\n");
			System.out.println("Final List:");
			
			finalList.removeAll(duplicates);
			finalList.addAll(duplicates);
			Collections.sort(finalList);
			Collections.reverse(finalList);
			
			for(int i=0; i<duplicates.size() && i < 10; i++)
			{
				String finalRef = finalList.get(i).toString();
				pw.write(finalRef+"\n");
				System.out.println(finalRef);
				
			}
			
		}
		
		
		
		Instant after = Instant.now();
		long duration = Duration.between(before, after).toMillis();
		System.out.println("\nQuery time: "+ duration+ " miliseconds\n");
		this.pw.write("\nQuery time: "+ duration + " miliseconds\n\n");
		
	}
	
	public void invertedIndex() {
		//for each word in the dictionary
		//print out doc frequency
		//print out references in doc order
		Instant before = Instant.now();
		this.dictionaryTree.traversal();
		Instant after = Instant.now();
		long duration = Duration.between(before, after).toMillis();
		System.out.println("\nTime to build index "+duration+ " miliseconds");
		this.pw.write("\nTime to build index "+duration+ " miliseconds\n");
	}
}
