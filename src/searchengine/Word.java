package searchengine;

import java.util.LinkedList;

public class Word {
	
	private String word;
	private LinkedList<DocRef> references = new LinkedList<DocRef>();
	
	public Word(String word) {
		this.word=word;
	}
	
	public void addRef(DocRef ref)
	{
		references.add(ref);
	}
}
