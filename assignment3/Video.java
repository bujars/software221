import java.util.Date;

public class Video extends MultiMediaItem{
    private String director;
    public Video(String id, String title, Date addedOn, Integer playingTime, String director){
        super(id, title, addedOn, playingTime);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    /*NOTE originall assumed to override compareTo for something like director,
    but it doesnt work because an Item cannot access it's childrens mehtods.
    Then i tired chaning the object to item, but that doesnt work either
    because this has to override item. */

    @Override
    public String toString(){
        return super.toString() + " Director: " + getDirector();
    }
}