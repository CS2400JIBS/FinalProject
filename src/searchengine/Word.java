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
	
}
