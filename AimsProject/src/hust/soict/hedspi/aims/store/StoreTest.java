package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;



public class StoreTest {
    public static void main(String[] args) {
        Store vip = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Scifi", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        vip.addDVD(dvd1);
        vip.addDVD(dvd2);
        //vip.addDVD(dvd3);
        vip.removeDVD(dvd1);
        vip.removeDVD(dvd3);

    }
}

