package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int id = 0;
    public void addDVD(DigitalVideoDisc a){
        itemsInStore[id] = a;
        id++;
    }

    public void removeDVC(DigitalVideoDisc a){
        boolean isRemoved = false;
        for(int i = 0; i<=id; i++){
            if(itemsInStore[i]==a){
                for(int j = i; j<id; j++){
                    itemsInStore[j] = itemsInStore[j+1];
                }
                id--;
                isRemoved = true;
            }
        }
        if(isRemoved){
           System.out.println("Da xoa thanh cong DVD: " + a.getTitle());
        }else{
            System.out.println("Khong tim thay DVD: " + a.getTitle());
        }
    }
    
}
