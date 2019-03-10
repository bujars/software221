import java.util.Comparator;

public class sortByDirector implements Comparator<Item>{

    @Override
    public int compare(Item firstItem, Item secondItem){
        /*NOTICE THIS IS tricky because director is only composed in video, nothing else. So need to cast*/
        if(firstItem instanceof Video && secondItem instanceof Video){
            /*Store as video so we can have access to director*/
            Video videoOne = (Video)firstItem;
            Video videoTwo = (Video)secondItem;
            /*Director is a string so it just compares as strings*/
            return videoOne.getDirector().compareTo(videoTwo.getDirector());
        }
        return 0; /*Return they are the same*/
    }
}