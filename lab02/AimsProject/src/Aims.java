public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Scifi", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc((dvd3));
        //display list-in-cart method is written in cart-class
        anOrder.displayList();
        //test remove method
        anOrder.removeDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("vip");
        anOrder.removeDigitalVideoDisc(dvd4);
        anOrder.displayList();
        //test done
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

    }
}
