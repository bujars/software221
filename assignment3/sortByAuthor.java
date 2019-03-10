import java.util.Comparator;

public class sortByAuthor implements Comparator<Item>{

    @Override
    public int compare(Item firstItem, Item secondItem){
        /*NOTICE THIS IS tricky because director is only composed in video, nothing else. So need to cast*/
        if(firstItem instanceof Textbook && secondItem instanceof Textbook){
            /*Store as video so we can have access to director*/
            Textbook textbookOne = (Textbook) firstItem;
            Textbook textbookTwo = (Textbook) secondItem;
            /*Director is a string so it just compares as strings*/
            return textbookOne.getAuthor().compareTo(textbookTwo.getAuthor());
        }
        return 0; /*Return they are the same*/
    }
}