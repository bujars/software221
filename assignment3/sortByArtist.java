import java.util.Comparator;

public class sortByArtist implements Comparator<Item>{

    @Override
    public int compare(Item firstItem, Item secondItem){
        /*NOTICE THIS IS tricky because director is only composed in video, nothing else. So need to cast*/
        if(firstItem instanceof CD && secondItem instanceof CD){
            /*Store as video so we can have access to director*/
            CD cdOne = (CD)firstItem;
            CD cdTwo = (CD)secondItem;
            /*Director is a string so it just compares as strings*/
            return cdOne.getArtist().compareTo(cdTwo.getArtist());
        }
        return 0; /*Return they are the same*/
    }
}