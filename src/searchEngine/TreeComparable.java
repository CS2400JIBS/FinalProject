package searchEngine;


/**
 * Interface for TreeComparable Methods
 * 
 * @author William A. Baires
 * @version 5/15/2020
 */
public interface TreeComparable
{
    int compareTo(Object o);
    void operate (Object o);
    void visit();
}
