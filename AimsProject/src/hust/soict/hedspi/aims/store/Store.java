package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public String add(Media a){
        if(itemsInStore.contains(a)){
            return ("San pham da ton tai!");
        }else {
            itemsInStore.add(a);
            return ("San pham da duoc them thanh cong!");
        }
    }

    public String remove(int index){
        String title = "";
        for(Media m: itemsInStore){
            if(m.getId() == index){
                itemsInStore.remove(m);
                title += m.getTitle();
                break;
            }
        }
        return ("Da xoa san pham: "+ title);
    }

    public String remove(String title){
        for(Media m: itemsInStore){
            if(m.getTitle().equalsIgnoreCase(title)){
                itemsInStore.remove(m);
            }
        }
        return ("Da xoa san pham: "+ title);
    }


    public void list() {
        System.out.println("List of items:");
        for(Media m: itemsInStore){
            System.out.println(m.toString());
        }
    }

    public Media search(String a){
        Media found = null;
        for(Media m: itemsInStore){
            if(m.getTitle().equalsIgnoreCase(a)){
                System.out.println(m.toString());
                found = m;
                break;
            }
        }
        return found;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
