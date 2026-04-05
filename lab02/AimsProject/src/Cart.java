public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }else{
            System.out.println("The Cart is almost full");
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
            System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());
        }
    }

}
