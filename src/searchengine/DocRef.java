package searchEngine;

public class DocRef {
	/**
	 * The document's name/ID for a reference instance
	 */
	private int docID;
	
	/**
	 * Frequency counter for the number of times a word has appeared in a document reference
	 */
	private int frequency;
	
	public DocRef() {
		this.docID = 0;
		this.frequency=0;
	}
	
	public DocRef(int docID) {
		this.docID=docID;
		this.frequency=1;
	}
	
	/**
	 * Increments the frequency counter (tracking the number of word occurrences) of the document reference
	 */
	public void increment()
	{
		++this.frequency;
	}

	/**
	 * Access the document's name/ID for a reference instance
	 * 
	 * @return
	 */
	public int getDocID() {
		return this.docID;
	}

	/**
	 * Set the document's name/ID for a reference instance
	 * 
	 * @param docID The document's name/ID for a reference instance
	 */
	public void setDocID(int docID) {
		this.docID = docID;
	}

	/**
	 * Access the frequency counter for a document reference
	 * 
	 * @return the frequency (or number of times a word has appeared) in a document reference
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * 
	 * 
	 * @param frequency The frequency counter for the number of times a word has appeared in a document reference
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	@Override
	public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + docID;
        return result;
    }
	
	/**
	 * Equals() method to resolve document reference object comparisons
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        DocRef other = (DocRef) o;
        if (this.docID!=other.getDocID())
            return false;
        return true;
	}
	

	@Override
	public String toString() {
		return "[Document: " + docID + ", Frequency=" + frequency + "]";
	}
	
	

}
