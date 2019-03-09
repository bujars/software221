import java.util.Date;

public abstract class Item implements Comparable<Item>{
    private String id;
    private String title;
    private Date addedOn;

    /*NOTE not sure if I need this but added it as just default.*/
    /*public Item(){
        id ="";
        title="";
        addedOn = new Date();
    }*/

    /*Constructor*/
    public Item(String id, String title, Date addedOn){
        this.id = id;
        this.title = title;
        this.addedOn = addedOn;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract int compareTo(Item item);

    public String toString(){
        return "Id: " + getId() + " Title: " + getTitle() + " Added ON: " + getAddedOn();
    }
}