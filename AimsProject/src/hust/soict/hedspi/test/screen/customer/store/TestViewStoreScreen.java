package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;
    @Override
    public void start(Stage stage) throws Exception {
        final String STORE_FXML_FILE_PATH = "../../../../aims/screen/customer/view/Store.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        loader.setController(viewStoreController);
        Parent root = loader.load();

        stage.setTitle("Cart");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        store = new Store();
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
        store.add(book1);
        store.add(book2);
        store.add(book3);
        store.add(dvd1);
        store.add(cd1);
        cart = new Cart();
        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);
        cart.addMedia(dvd1);
        cart.addMedia(cd1);
        launch(args);
    }
}
