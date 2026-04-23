package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static int command;
    private static Scanner scanner = new Scanner(System.in);
    private static boolean RUNNING = true;
    private static Cart anOrder = new Cart();
    private static Store theStore = new Store();
    private static String title;

    public static void main(String[] args){


        //for test purpose
        Book book1 = new Book("Rung na uy", "tieu thuyet", 120);
        book1.addAuthor("Haruki Murakami");
        Book book2 = new Book("Kafka ben bo bien", "tieu thuyet", (float)125.4);
        book2.addAuthor("Haruki Murakami");
        Book book3 = new Book("Vip", "nhat ky", 14);
        book3.addAuthor("Tung Le");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Sieu nhan gao", "phim", 16, 15, "Tung gaming");
        CompactDisc cd1 = new CompactDisc("Cai thu hai", "alt rock", 350, 45, "ngot", "thang");
        Track track1 = new Track("Khoc day", 160);
        Track track2 = new Track("But chi bac", 160);
        Track track3 = new Track("Can gac lang", 160);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);
        theStore.add(book1);
        theStore.add(book2);
        theStore.add(book3);
        theStore.add(dvd1);
        theStore.add(cd1);
        while(RUNNING){
            showMenu();
        }
    }

    public static void showMenu(){
        int myId = 1;
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3: ");
        command = scanner.nextInt();
        switch(command){
            case 1:
                storeMenu();
                break;
            case 2:
                updateMenu();
                break;
            case 3:
                cartMenu(myId);
                break;
            case 0:
                RUNNING=false;
                break;
        }
    }

    public static void storeMenu(){
        int myId = 2;
        theStore.list();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4: ");
        command = scanner.nextInt();
        switch(command){
            case 1:
                title = scanner.nextLine(); //khu enter
                System.out.print("Nhap title: ");
                title = scanner.nextLine();
                Media found = theStore.search(title);
                if(found != null){
                    mediaDetailsMenu(found);
                }else{
                    System.out.println("Khong ton tai san pham: " + title);
                }
                storeMenu();
                break;
            case 2:
                title = scanner.nextLine(); //khu enter
                System.out.print("Nhap title: ");
                title = scanner.nextLine();
                Media found2 = theStore.search(title);
                if(found2 != null){
                    anOrder.addMedia(found2);
                }else{
                    System.out.println("Khong ton tai san pham: " + title);
                }
                storeMenu();
                break;
            case 3:
                title = scanner.nextLine(); //khu enter
                System.out.print("Nhap title: ");
                title = scanner.nextLine();
                Media found3 = theStore.search(title);
                if(found3 != null){
                    found3.play();
                }else{
                    System.out.println("Khong ton tai san pham: " + title);
                }
                System.out.print("Nhap title: ");
                storeMenu();
                break;
            case 4:
                cartMenu(myId);
                break;
            case 0:
                showMenu();
                break;
        }

    }

    public static void mediaDetailsMenu(Media m) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2: ");
        command = scanner.nextInt();
        switch(command){
            case 1:
                anOrder.addMedia(m);
                break;
            case 2:
                m.play();
                break;
            case 0:
                break;
        }
    }

    public static void updateMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to the store");
        System.out.println("2. Remove media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2: ");
        command = scanner.nextInt();
        switch (command){
            case 1:
                System.out.print("Title: ");
                title = scanner.nextLine();
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Add a book");
                System.out.println("2. Add a dvd");
                System.out.println("3. Add a cd");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-3: ");
                command = scanner.nextInt();
                switch (command){
                    case 1:
                        Book b = new Book();
                        theStore.add(b);
                        break;
                    case 2:
                        DigitalVideoDisc dvd = new DigitalVideoDisc();
                        theStore.add(dvd);
                        break;
                    case 3:
                        CompactDisc cd = new CompactDisc();
                        theStore.add(cd);
                        break;
                    case 0:
                        break;
                }
                updateMenu();
                break;
            case 2:
                theStore.list();
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. By id");
                System.out.println("2. By title");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2: ");
                command = scanner.nextInt();
                switch (command){
                    case 1:
                        System.out.print("Nhap id: ");
                        command = scanner.nextInt();
                        theStore.remove(command);
                        break;
                    case 2:
                        title = scanner.nextLine(); //khu enter
                        System.out.print("Nhap title: ");
                        title = scanner.nextLine();
                        theStore.remove(title);
                        break;
                    case 0:
                        break;
                }
                updateMenu();
                break;
            case 3:
                showMenu();
                break;
        }
    }

    public static void cartMenu(int backId){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5: ");
        command = scanner.nextInt();
        switch(command){
            case 1:
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Filter by id");
                System.out.println("2. Filter by title");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2: ");
                command = scanner.nextInt();
                switch(command){
                    case 1:
                        System.out.print("Nhap id: ");
                        int id = scanner.nextInt();
                        anOrder.filter(id);
                        break;
                    case 2:
                        title = scanner.nextLine(); //khu enter
                        System.out.print("Nhap title: ");
                        title = scanner.nextLine();
                        anOrder.filter(title);
                        break;
                    case 0:
                        break;
                }
                cartMenu(backId);
                break;
            case 2:
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Sort by cost");
                System.out.println("2. Sort by title");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2: ");
                command = scanner.nextInt();
                switch(command){
                    case 1:
                        anOrder.sortByCost();
                        break;
                    case 2:
                        anOrder.sortByTitle();
                        break;
                    case 0:
                        break;
                }
                cartMenu(backId);
                break;
            case 3:
                title = scanner.nextLine(); //khu scanner
                System.out.print("Nhap title: ");
                title = scanner.nextLine();
                Media m = anOrder.search(title);
                if(m != null){
                    anOrder.removeMedia(m);
                }else{
                    System.out.println("San pham khong ton tai trong gio hang!");
                }
                cartMenu(backId);
                break;
            case 4:
                title = scanner.nextLine(); //khu scanner
                System.out.print("Nhap title: ");
                title = scanner.nextLine();
                Media m2 = anOrder.search(title);
                if(m2 != null){
                    m2.play();
                }else{
                    System.out.println("San pham khong ton tai trong gio hang!");
                }
                cartMenu(backId);
                break;
            case 5:
                System.out.println("An order is created!");
                anOrder.kill();
                cartMenu(backId);
                break;
            case 0:
                if(backId == 1){
                    showMenu();
                }else{
                    storeMenu();
                }
                break;
        }
    }

}

