import java.util.Comparator;


public class sortByTitle implements Comparator<Item>{

    @Override
    public int compare(Item firstItem, Item secondItem){
        /*NOTE, item has its title sorted. Thus acess public method.
        Secondly, uses string compareTo */
        return firstItem.getTitle().compareTo(secondItem.getTitle());
    }

}