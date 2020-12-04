package searchEngine;

import java.util.LinkedList;

public class Word {
	
	/**
	 * The string value of the word being added as a Word Object
	 */
	private String word;
	
	/**
	 * The list of references. References are DocRef objects that store the docID that they come from and the frequency of the word in that document
	 */
	private LinkedList<DocRef> references = new LinkedList<DocRef>();
	
	/**
	 * Word Class Single Parameter Constructor
	 * 
	 * @param word The string value of the word being added as a Word Object
	 */
	public Word(String word) {
		this.word=word;
	}

	/**
	 * Adds new references to the end of the list, otherwise increases frequency counter for existing references
	 * 
	 * @param docID The name of the document/file being added to the word's list of references 
	 */
	public void addRef(DocRef ref)
	{	
		int index = this.references.indexOf(ref); //If returns -1, then the reference does not exist on the list
		
		if(index==-1) //New doc reference
		{
			System.out.println("new");
		}
		else //Duplicate doc reference
		{
			
		}
	}
	
	/**
	 * Access the string value/attribute of the Word object
	 * 
	 * @return the string value of the word
	 */
	public String getWord()
	{
	   return word;
	}
	
	/**
	 * Access the document frequency (or the number of documents a word appears in). Represented by the size of the references linked list
	 * 
	 * @return the number of documents the word appears in
	 */
	public int getDocFrequency() 
	{
		return references.size();
	}
	
	/**
	 * Access the list of references attached to the Word Object
	 * 
	 * @return The word's list of document references
	 */
	public LinkedList<DocRef> getReferenceList() {
		return this.references;
	}
	
	public void sortReferences() {
		//this.references.sort(c);
	}
	
	@Override
	public boolean equals(Object o) {
		Word word = (Word) o;
		return this.word.compareTo(word.getWord())==0;
	}
}
