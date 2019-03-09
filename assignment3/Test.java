import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;


//import org.apache.commons.collections.comparators.ComparatorChain;

/*

import java.util.Calendar;
import java.util.Date;
import java.util.Comparator;
import java.util.Collections; *//*This is needed for the chain otherwise gives error*/

/*NOTE THIS CAME FROM https://commons.apache.org/proper/commons-collections/javadocs/api-2.1.1/org/apache/commons/collections/comparators/ComparatorChain.html#ComparatorChain()*/
//import org.apache.commons.collections.comparators.ComparatorChain;

public class Test {
    /*This is just a test file since nothing was given...*/
    public static void main(String args[]) {
        ComparatorChain chain = new ComparatorChain();
        Database library = new Database();
        Calendar cal = Calendar.getInstance();

        // adding database entries
        cal.set(1890, Calendar.AUGUST, 10);
        Date date = (Date) cal.getTime();
        library.addItem(new Textbook("TB15", "TextX", date, "John Doe"));

        cal.set(1954, Calendar.JANUARY, 18);
        date = (Date) cal.getTime() ;
        library.addItem(new Video("V09", "VideoB", date, 70000, "J. Smith"));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime() ;
        library.addItem(new Textbook("TB01", "TextY", date, "John Doe"));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime() ;
        library.addItem(new CD("CD07", "CD1", date, 1000, "B.D."));

        cal.set(1990, Calendar.APRIL, 30);
        date = (Date) cal.getTime() ;
        library.addItem(new CD("CD10", "CD1", date, 800, "X.Y."));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime();
        library.addItem(new CD("CD05", "CD1", date, 1000, "B.C."));

        cal.set(1890, Calendar.JULY, 2);
        date = (Date) cal.getTime();
        library.addItem(new Video("V12", "VideoA", date, 7000, "Joe Smith"));

        // print unsorted database
        System.out.println("----- DATABASE BEFORE SORTING: -----\n");
        library.list();


        /* NOTE NOTE NOTE, THE ITEM[] MUST BE PYBLIC SO I WILL USE A GET AND SET METHOD. AND MAKE A TEMPORARY VARIABLE. */

        ArrayList<Item> tempArray = library.getItem();

        // sort and print sorted database (by id)
        Collections.sort(tempArray); /*NOTE PROFESSOR SAID THIS NEEDS TO BE PRIVATE.*/
        System.out.println("----- DATABASE AFTER SORTING BY ID (default): -----\n");

        library.setItem(tempArray);
        library.list();

        // sort by other fields
        System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
        System.out.println("------------ (title, addedOn, director) -----------\n");
        chain.addComparator(new sortByTitle());
        chain.addComparator(new sortByAddedOn());
        chain.addComparator(new sortByDirector());
        tempArray = library.getItem();
        Collections.sort(tempArray, chain);
        library.setItem(tempArray);
        library.list();
    }



}
