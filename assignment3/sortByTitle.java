import java.util.Comparator;

/*NOTE this class is just a method that compares two titles with each other, nothing more. */
public class sortByTitle implements Comparator {
    @Override
    public int compare(Object objectOne, Object objectTwo) {
        /*First we check that the objects put in are actually a string*/
        if(objectOne instanceof String && objectTwo instanceof String) {
            /*Convert Object to string*/
            String stringOne = (String)objectOne;
            String stringTwo = (String)objectTwo;
            /*Use String compare function*/
            return stringOne.compareTo(stringTwo);
        }
        return 0;
    }
}

/*NOTE renamed variables to reunderstand this duanting concept in the future.
Remmeber to refer to comparator and addComparator in chain to realied hows it actually working. */
