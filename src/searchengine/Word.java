package searchEngine;

import java.util.LinkedList;
import java.util.*;

public class Word {
	
	/**
	 * The string value of the word being added as a Word Object
	 */
	private String word;
	
	/**
	 * The list of references. References are DocRef objects that store the docID that they come from and the frequency of the word in that document
	 */
	private LinkedList<DocRef> references;
	
	public Word() {
		this.word = "";
		references = null;
	}
	
	/**
	 * Word Class Single Parameter Constructor
	 * 
	 * @param word The string value of the word being added as a Word Object
	 */
	public Word(String word) {
		this.word=word;
		references = new LinkedList<DocRef>();
	}

	/**
	 * Adds new references to the end of the list, otherwise increases frequency counter for existing references
	 * 
	 * @param docID The name of the document/file being added to the word's list of references 
	 */
	public void addRef(DocRef ref)
	{	
		int index=this.references.indexOf(ref);
		
		if(index==-1)
		{
			this.references.add(ref);
			System.out.println("new ref");
		}
		else 
		{
			this.references.get(index).increment();
			System.out.println("dup ref");
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
	
	public void sortReferences() 
	{
		Collections.sort(references);
		Collections.reverse(references);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	
	
	
	
}
