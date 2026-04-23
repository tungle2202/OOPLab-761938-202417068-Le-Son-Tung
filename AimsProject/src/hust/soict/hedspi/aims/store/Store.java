package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void add(Media a){
        if(itemsInStore.contains(a)){
            System.out.println("San pham da ton tai!");
        }else {
            itemsInStore.add(a);
            System.out.println("San pham da duoc them thanh cong!");
        }
    }

    public void remove(int index){
        for(Media m: itemsInStore){
            if(m.getId() == index){
                itemsInStore.remove(m);
                System.out.println("Da xoa san pham: "+m.getTitle());
            }
        }
    }

    public void remove(String title){
        for(Media m: itemsInStore){
            if(m.getTitle().equalsIgnoreCase(title)){
                itemsInStore.remove(m);
                System.out.println("Da xoa san pham: "+m.getTitle());
            }
        }
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

}
