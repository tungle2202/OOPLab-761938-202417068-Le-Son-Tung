package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;


    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media m){
        if(itemsOrdered.size()>20){
            System.out.println("Da vuot qua so luong san pham cho phep!");
        }else {
            if (itemsOrdered.contains(m)) {
                System.out.println("Da ton tai san pham!");
            }else{
                itemsOrdered.add(m);
                System.out.println("Da them san pham vao gio hang!");
            }
        }
    }

    public void removeMedia(Media m){
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
            System.out.println("Da xoa san pham khoi gio hang!");
        }else{
            System.out.println("Khong ton tai san pham trong gio hang!");
        }
    }

    public double totalCost(){
        double total = 0;
        for(Media m : itemsOrdered){
            total += (double)m.getCost();
        }
        return total;
    }






    // LEGACY
//    public float totalCost(){
//        float res = 0;
//        for(int i = 0; i < qtyOrdered; i++){
//            res += itemsOrdered[i].getCost();
//        }
//        return res;
//    }
//
//    //displayList() method
//    public void displayList(){
//        for(int i = 0; i < qtyOrdered; i++){
//            System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost() + "\tid: " + itemsOrdered[i].getId());
//        }
//    }
//
//    //detail list
//    public void detailList(){
//        for(DigitalVideoDisc a: itemsOrdered){
//            if(a == null){
//                break;
//            }
//            System.out.println(a.toString());
//        }
//    }
//
//    public void search(int id){
//        Boolean foundDVD = true;
//        for(DigitalVideoDisc a: itemsOrdered){
//            if(a == null){
//                break;
//            }
//            if(a.getId() == id){
//                System.out.println(a.toString());
//                foundDVD = false;
//                break;
//            }
//        }
//        if(foundDVD){
//            System.out.println("Khong ton tai DVD co id: " + id);
//        }
//    }
//
//    public void search(String title){
//        Boolean foundDVD = true;
//        System.out.println("Result: ");
//        for(DigitalVideoDisc a: itemsOrdered){
//            if(a == null){
//                break;
//            }
//            if(a.isMatch(title)){
//                System.out.println(a.toString());
//                foundDVD = false;
//            }
//        }
//        if(foundDVD){
//            System.out.println("Khong ton tai DVD co title: " + title);
//        }
//    }

}
