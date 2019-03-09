import java.util.Comparator;
import java.util.Date;


/*NOTE this class is just a method that compares two dates with each other, nothing more. */
public class sortByAddedOn implements Comparator {
    @Override

    public int compare(Object objectOne, Object objectTwo) {
        /*First we chek that the objects put in are actually a Date*/
        if(objectOne instanceof Date && objectTwo instanceof Date) {
            /*Convert Object to Date*/
            Date dateOne = (Date)objectOne;
            Date dateTwo = (Date)objectTwo;
            /*USES date compareTo function*/
            return dateOne.compareTo(dateTwo);
        }
        return 0;
    }
}

/*NOTE renamed variables to reunderstand this duanting concept in the future.
Remmeber to refer to comparator and addComparator in chain to realied hows it actually working. */