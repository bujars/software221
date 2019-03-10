import java.util.Comparator;


public class sortById implements Comparator<Item>{

    @Override
    public int compare(Item firstItem, Item secondItem){
        /*NOTE, item has its title sorted. Thus acess public method.
        Secondly, uses string compareTo */
        return firstItem.getId().compareTo(secondItem.getId());
    }

}