package searchengine;

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
	public void addRef(String docID)
	{
	   // Create reference object using the document's name
		DocRef ref = new DocRef(docID);
		
		int index = references.indexOf(ref); //If returns -1, then the reference does not exist on the list
		
		if(index!=-1) //Duplicate doc reference
		{
			
			references.get(index).increment();
		}
		else //New doc reference
		{
			references.add(ref);
		}
	}
	
	/**
	 * Access the Document Reference at a given index of the References list
	 * 
	 * @param index of the Document Reference on the list of References
	 * @return the Document Reference at the given index
	 */
	public DocRef getRef(int index) {
		
		return references.get(index);
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
	
	public LinkedList<DocRef> getReferenceList() {
		return this.references;
	}
	
}
