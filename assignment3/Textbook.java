import java.util.Date;

public class Textbook extends Item{
    private String author;
    public Textbook(String id, String title, Date addedOn, String author){
        super(id, title, addedOn);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /*NOTE originall assumed to override compareTo for something like author,
    but it doesnt work because an Item cannot access it's childrens mehtods.
    Then i tired chaning the object to item, but that doesnt work either
    because this has to override item. */


    @Override
    public String toString(){
        return super.toString() + " Author: " + getAuthor();
    }
}