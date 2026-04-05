public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc " + disc.getTitle() + " has been added");
        }else{
            System.out.println("The Cart is almost full");
        }
    }

    //14.1
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        int amount = dvdList.length;
        int j = 0;
        for(int i = qtyOrdered; i<qtyOrdered+amount; i++){
            if(qtyOrdered >= MAX_NUMBERS_ORDERED){
                System.out.println("You have reached the limit");
                return;
            }else{
                itemsOrdered[i] = dvdList[j];
                j++;
                qtyOrdered++;
                System.out.println("The disc " + dvdList[j].getTitle() + " has been added");
            }
        }
    }
    //14.1.b
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvds){
//        int amount = dvds.length;
//        int j = 0;
//        for(int qtyOrdered = qtyOrdered; i<qtyOrdered+amount; i++){
//            if(i >= MAX_NUMBERS_ORDERED){
//                System.out.println("You have reached the limit");
//                return;
//            }else{
//                itemsOrdered[i] = dvds[j];
//                j++;
//                qtyOrdered++;
//                System.out.println("The disc " + dvds[j].getTitle() + " has been added");
//            }
//        }
//    }
    //14.2
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        int remain = 2;
        for(int i = qtyOrdered; i<qtyOrdered+2; i++){
            if(qtyOrdered>= MAX_NUMBERS_ORDERED){
                System.out.println("You have reached the limit");
            }else{
                if(remain == 2){
                    itemsOrdered[i]=dvd1;
                    remain--;
                    qtyOrdered++;
                    System.out.println("The disc " + dvd1.getTitle() + " has been added");

                }else if(remain == 1){
                    itemsOrdered[i]=dvd2;
                    remain--;
                    qtyOrdered++;
                    System.out.println("The disc " + dvd2.getTitle() + " has been added");

                }

            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean temp = true;
        for(int i = 0; i< qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                temp = false;
                System.out.println("The disc " + disc.getTitle() + " has been removed");
            }
        }
        if(temp){
            System.out.println("You don't have the disc \"" + disc.getTitle() +  "\" in your cart");
        }
    }
    public float totalCost(){
        float res = 0;
        for(int i = 0; i < qtyOrdered; i++){
            res += itemsOrdered[i].getCost();
        }
        return res;
    }

    //displayList() method
    public void displayList(){
        for(int i = 0; i < qtyOrdered; i++){
            System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost() + "\tid: " + itemsOrdered[i].getId());
        }
    }

}
