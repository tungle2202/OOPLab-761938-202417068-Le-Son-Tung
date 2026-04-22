package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static  void main(String[] args){
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("jungle");
        DigitalVideoDisc cinderella = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderella);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderella.getTitle());

        changeTitle(jungleDVD, cinderella.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    public static void swap (Object o1, Object o2){
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
