package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100];
    private int id = 0;
    public void addDVD(DigitalVideoDisc a){
        boolean existed = false;
        if(this.id != 0) {
            for (DigitalVideoDisc b : itemsInStore) {
                if (a == b) {
                    existed = true;
                    break;
                }
            }
        }
        if(existed){
            System.out.println("DVD " + a.getTitle() + " Da ton tai!");
        }else {
            itemsInStore[id] = a;
            id++;
            System.out.println("DVD " + a.getTitle() + "Da duoc them thanh cong!");
        }
    }

    public void removeDVD(DigitalVideoDisc a){
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
