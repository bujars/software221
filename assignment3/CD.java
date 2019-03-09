import java.util.Date;

public class CD extends MultiMediaItem{
    private String artist;
    public CD(String id, String title, Date addedOn, Integer playingTime, String artist){
        super(id, title, addedOn, playingTime);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    /*NOTE originall assumed to override compareTo for something like artist,
    but it doesnt work because an Item cannot access it's childrens mehtods.
    Then i tired chaning the object to item, but that doesnt work either
    because this has to override item. */


    @Override
    public String toString(){
        return super.toString() + " Artist: " + getArtist();
    }
}