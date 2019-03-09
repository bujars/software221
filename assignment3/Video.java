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

    @Override
    public int compareTo(Item video){
        return this.getId().compareTo(video.getId());
    }

    @Override
    public String toString(){
        return super.toString() + " Director: " + getDirector();
    }
}