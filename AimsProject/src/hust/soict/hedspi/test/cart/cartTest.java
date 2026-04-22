package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class cartTest{
    public static void main(String[] args) {
        Cart cart = new Cart();
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Scifi", "George Lucas", 87, 24.95f);
//        cart.addDigitalVideoDisc(dvd1, dvd2);
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//        cart.addDigitalVideoDisc((dvd3));

        cart.search("The Lion King");
        cart.search(20);
    }
}