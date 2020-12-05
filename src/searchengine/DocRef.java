package searchEngine;

public class DocRef {
	/**
	 * The document's name/ID for a reference instance
	 */
	private String docID;
	
	/**
	 * Frequency counter for the number of times a word has appeared in a document reference
	 */
	private int frequency;
	
	public DocRef() {
		this.docID = "";
		this.frequency=0;
	}
	
	public DocRef(String docID) {
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
	public String getDocID() {
		return docID;
	}

	/**
	 * Set the document's name/ID for a reference instance
	 * 
	 * @param docID The document's name/ID for a reference instance
	 */
	public void setDocID(String docID) {
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
        result = prime * result + ((docID == null) ? 0 : docID.hashCode());
        return result;
    }
	
	/**
	 * Equals() method to resolve document reference object comparisons
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocRef other = (DocRef) obj;
        if (this.docID == null) {
            if (other.getDocID() != null)
                return false;
        } 
        else if (!this.docID.equalsIgnoreCase(other.getDocID()))
            return false;
        return true;
	}
	

	@Override
	public String toString() {
		return "[Document: " + docID + ", Frequency=" + frequency + "]";
	}
	
	

}
