import java.util.Date;

public abstract class MultiMediaItem extends Item{
    private Integer playingTime;

    /* NOTE uml says Intger and not int. Therefore assumption is made for Integer wrapper*/
    public MultiMediaItem(String id, String title, Date addedOn, Integer playingTime){
        super(id, title, addedOn);
        this.playingTime = playingTime;
    }

    public Integer getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(Integer playingTime) {
        this.playingTime = playingTime;
    }


    @Override
    public String toString(){
        return super.toString() + " Playing Time: " + getPlayingTime();
    }

}