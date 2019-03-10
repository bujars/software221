import java.util.Comparator;

public class sortByTitle implements Comparator<Item>{

    public int compare(Item firstItem, Item secondItem){
        return firstItem.getTitle().compareTo(secondItem.getTitle());
    }

}