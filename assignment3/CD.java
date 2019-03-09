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

    @Override
    public int compareTo(Item cd) { return this.getId().compareTo(cd.getId()); }

    @Override
    public String toString(){
        return super.toString() + " Artist: " + getArtist();
    }
}