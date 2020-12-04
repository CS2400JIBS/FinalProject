package searchengine;

import java.util.LinkedList;

public class Word {
	
	private String word;
	private LinkedList<DocRef> references = new LinkedList<DocRef>();
	
	public Word(String word) {
		this.word=word;
	}
	
	public void addRef(String fileName)
	{
		DocRef ref = new DocRef(fileName);
		
		int index = references.indexOf(ref); //If returns -1, then the reference does not exist on the list
		
		if(index!=-1)
		{
			//Duplicate doc reference
			references.get(index).increment();
		}
		else
		{
			references.add(ref);
		}
	}
	
	public DocRef getRef(int index) {
		
		return references.get(index-1);
	}
	
<<<<<<< HEAD
	public String getWord()
	{
	   return word;
=======
	public int getDocFrequency() {
		return references.size();
>>>>>>> 55f2d6b48229dfb5134d9a3ab1106e4207d2d7e9
	}
	
}
