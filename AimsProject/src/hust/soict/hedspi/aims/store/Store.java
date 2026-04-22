package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    //private int id = 0;
    public void addDVD(Media a){
        if(itemsInStore.contains(a)){
            System.out.println("San pham da ton tai!");
        }else {
            itemsInStore.add(a);
            System.out.println("San pham da duoc them thanh cong!");
        }
    }

    public void removeDVD(DigitalVideoDisc a){
        if(itemsInStore.contains(a)){
            itemsInStore.remove(a);
            System.out.println("Da xoa thanh cong san pham");
        }else{
            System.out.println("Khong ton tai san pham!");
        }
    }

}
