import java.util.ArrayList;

public class Database {

    private ArrayList<Item> item;

    public Database(){
        item = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.item.add(item);
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void list(){
        for(int i = 0; i < item.size(); i++){
            System.out.println(item.get(i).toString());
        }
    }

}