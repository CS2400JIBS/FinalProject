package searchengine;

public class DocRef {
	private String docID;
	private int frequency;
	
	public DocRef(String docID) {
		this.docID=docID;
		this.frequency=0;
	}
	
	public void increment()
	{
		this.frequency++;
	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	@Override
	public boolean equals(Object o) {
		DocRef ref = (DocRef) o;
		return(this.docID.equals(ref.getDocID()));
	}

}
