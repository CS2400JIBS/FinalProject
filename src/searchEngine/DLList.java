package searchEngine;

import java.lang.reflect.Array;

public class DLList implements ListInterface
{
	   private Node firstNode;            // Reference to first node of chain
	   private Node lastNode;
	   private int  numberOfEntries;
	   
	   public DLList()
	   {
		   firstNode=null;
		   lastNode=null;
		   numberOfEntries=0;
	   } // end default constructor
	   
	   public void clear()
	   {
	      initializeDataFields();
	   } // end clear
	   
	   public void add(Word newEntry)          // OutOfMemoryError possible
	   {
		   Node newNode = new Node(newEntry);
		   if(newEntry!=null)
		   {
			   if(this.isEmpty())
			   {
				   firstNode = newNode;
				   lastNode = newNode;
		
			   }
			   else
			   {    		 
				   lastNode.setNext(newNode);
				   newNode.setPrev(lastNode);
				   lastNode = newNode;
				   //lastNode.setNext(null);
			   }
			   this.numberOfEntries++;
		   }
	   } // end add

	   public void add(int givenPosition, Word newEntry) // OutOfMemoryError possible
	   {
		   if(newEntry!=null && (givenPosition >=1) && (givenPosition <= numberOfEntries + 1))
		   {
			   Node newNode = new Node(newEntry);
			   if(givenPosition>this.numberOfEntries)
			   {
				   if(givenPosition==1)
				   {
					   firstNode = newNode;
					   lastNode = newNode;
				   }
				   else
				   {
					   lastNode.setNext(newNode);
					   newNode.setPrev(lastNode);
					   lastNode=newNode;
				   }
			   }
			   else
			   {
				   if(givenPosition==1)
				   {
					   firstNode.setPrev(newNode);
					   newNode.setNext(firstNode);
					   firstNode=newNode;
				   }
				   else
				   {
					   Node moveNext=this.getNodeAt(givenPosition);
					   Node before = moveNext.getPrev();
					   before.setNext(newNode);
					   newNode.setPrev(before);
					   newNode.setNext(moveNext);
					   moveNext.setPrev(newNode);
				   }
			   }
			   this.numberOfEntries++;
		   }

		   else
		         throw new IndexOutOfBoundsException("Illegal position given to add operation.");
		   
	   } // end add

	   public Word remove(int givenPosition)
	   {
		   
		   if((givenPosition >= 1) && (givenPosition <= this.numberOfEntries))
		   {
			   Word result;
			   Node toBeRemoved;
			   if(givenPosition==1)
			   {
				   result=firstNode.getData();
				   firstNode=firstNode.getNext();
				   firstNode.setPrev(null);
				   this.numberOfEntries--;
				   return result;
			   }
			   else
			   {
				   toBeRemoved=this.getNodeAt(givenPosition);
				   Node before=toBeRemoved.getPrev();
				   Node after=toBeRemoved.getNext();
				   if(after!=null)
				   {
					   before.setNext(after);
					   after.setPrev(before);
				   }
				   else
				   {
					   before.setNext(null);
					   lastNode=before;
				   }
				   this.numberOfEntries--;
				   return toBeRemoved.getData(); 
			   }
		   }
		   else
			   throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		   
	   } // end remove

	   public Word replace(int givenPosition, Word newEntry)
	   {
		   if(newEntry!=null && (givenPosition >= 1) && (givenPosition <= this.numberOfEntries))
		   {
			   if(givenPosition==1)
			   {
				   Word result=firstNode.getData();
				   firstNode.setData(newEntry);
				   return result;
			   }
			   else
			   {
				   Node toReplace=this.getNodeAt(givenPosition);
				   Word result = toReplace.getData();
				   toReplace.setData(newEntry);
				   return result; 
			   }
		   }
		   else
			   throw new IndexOutOfBoundsException("Illegal position given to remove operation.");	   
	   } // end replace

	   public Word getEntry(int givenPosition)
	   {
		   if((givenPosition >= 1) && (givenPosition <= this.numberOfEntries))
		   {
			   return this.getNodeAt(givenPosition).getData();
		   }
		   else
			   throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	   } // end getEntry
	   
	   public Word[] toArray()
	   {
	      // The cast is safe because the new array contains null entries
	      @SuppressWarnings("unchecked")
	      Word[] result = (Word[])new Comparable[numberOfEntries];
	      Node currentNode = firstNode;
	      for(int i = 0; i<this.numberOfEntries; i++)
	      {
	    	  result[i]=currentNode.getData();
	    	  currentNode=currentNode.getNext();
	      }
	      return result;
	   } // end toArray
	                                             
	   public boolean contains(Word anEntry)
	   {
		   Node currentNode = firstNode;
		   for(int i = 0; i<this.numberOfEntries; i++)
		   {
			   if(currentNode.getData()==anEntry)
			   {
				   return true;
			   }
			   currentNode=currentNode.getNext();
		   }
		   return false;
	   } // end contains

	   public int getLength()
	   {
	      return numberOfEntries;
	   } // end getLength   

	   public boolean isEmpty()
	   {
	      boolean result;
	      
	      if (numberOfEntries == 0) // Or getLength() == 0
	      {
	         // Assertion: firstNode == null
	         result = true;
	      }
	      else
	      {
	         // Assertion: firstNode != null
	         result = false;
	      } // end if
	      
	      return result;
	   } // end isEmpty
	   
	   public void sortItems()
		{
	    	if(firstNode!=null && this.numberOfEntries>1)
	    	{
	    		Word[] arr = this.toArray();
		        for (int i = 1; i < this.numberOfEntries; i++) { 
		            Word data = arr[i]; 
		            int j = i-1; 
		  
		            while (j >= 0 && (arr[j]).getWord().compareTo(data.getWord())>0){ 
		                arr[j + 1] = arr[j]; 
		                j = j - 1; 
		            } 
		            arr[j + 1] = data; 
		        }
		        Node currentNode=firstNode;
		        for (int i=0; i<this.numberOfEntries; i++)
		        {
		        	currentNode.setData(arr[i]);
		        	currentNode=currentNode.getNext();
		        }
	    	}
		}
	   // Returns a reference to the node at a given position.
	   
	// Initializes the class's data fields to indicate an empty list.
	   private void initializeDataFields()
	   {
	      firstNode = null;
	      lastNode =null;
	      numberOfEntries = 0;
	   } // end initializeDataFields
	 
	   private Node getNodeAt(int givenPosition)
	   {
		   Node currentNode=null;
		   
		   if(firstNode!=null && (givenPosition >= 1) && (givenPosition <= this.numberOfEntries))
		   {
			   if(this.numberOfEntries > 2 && givenPosition >= this.numberOfEntries/2)
			   {
				   currentNode=this.lastNode;
				   for (int counter = this.numberOfEntries; counter > givenPosition; counter--)
				   {
					   currentNode=currentNode.getPrev();
				   }  
			   }
			   
			   else
			   {
				   currentNode=this.firstNode;
				   for (int counter = 1; counter < givenPosition; counter++)
				   {
					   currentNode=currentNode.getNext();
				   }
			   }
		   }
		   else throw new IndexOutOfBoundsException("The given postion in list is not valid.");
		   
		   return currentNode;
	    	  
	   } // end getNodeAt
	   
	   public class Node
	   {
		   private Word data; // Entry in list
		   private Node next; // Link to next node
		   private Node prev; // LInk to previous node
		   
		   private Node(Word dataPortion)
		   {
				this(dataPortion, null, null);
		   }
			
		   private Node(Word data, Node prev, Node next)
		   {
			   this.data = data;
			   this.prev = prev;
			   this.next = next;			
		   }
		   public Word getData() 
		   {
			   return data;
		   }
		
		   public void setData(Word data) 
		   {
			   this.data = data;
		   }
		
			public Node getNext() {
				return next;
			}
		
			public void setNext(Node next) {
				this.next = next;
			}
		
			public Node getPrev() {
				return prev;
			}
		
			public void setPrev(Node prev) {
				this.prev = prev;
			}
	   } // end Node
	} // end LList



