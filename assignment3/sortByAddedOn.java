import java.util.Comparator;


public class sortByAddedOn implements Comparator<Item>{

    @Override
    public int compare(Item firstItem, Item secondItem){
        /*NOTE, item has its date sorted. Thus acess public method.
        Secondly, uses date compareTo */
        return firstItem.getAddedOn().compareTo(secondItem.getAddedOn());
    }

}