package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class cartTest{
    public static void main(String[] args) {
        ArrayList<Media> hihi = new ArrayList<Media>();
        Book hehe = new Book("rung na uy", "tieu thuyet", 100);
        CompactDisc huhu = new CompactDisc( "Cai thu 2", "Alt rock", 350, 45, "Thang Ngot", "Thang ngot");
        hihi.add(hehe);
        hihi.add(huhu);
        for(Media m: hihi){
            System.out.println(m.toString());
        }
    }
}