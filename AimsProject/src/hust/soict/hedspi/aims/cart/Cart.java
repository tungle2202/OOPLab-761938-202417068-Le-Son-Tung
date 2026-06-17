package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    public static int amount = 0;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public String addMedia(Media m) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("Cannot add media. The cart has reached its maximum limit of " + MAX_NUMBERS_ORDERED + " items.");
        }
        if (itemsOrdered.contains(m)) {
            return "Da ton tai san pham!";
        } else {
            itemsOrdered.add(m);
            amount++;
            return "Da them san pham vao gio hang!\nSo san pham hien tai: " + amount;
        }
    }

    public void removeMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
            amount--;
            System.out.println("Da xoa san pham khoi gio hang!");
        } else {
            System.out.println("Khong ton tai san pham trong gio hang!");
        }
    }

    public double totalCost() {
        double total = 0;
        for (Media m : itemsOrdered) {
            total += (double) m.getCost();
        }
        return total;
    }

    public void filter(int id) {
        for (Media m : itemsOrdered) {
            if (id == m.getId()) {
                System.out.println(m.toString());
            }
        }
    }

    public void filter(String title) {
        for (Media m : itemsOrdered) {
            if (title.equalsIgnoreCase(m.getTitle())) {
                System.out.println(m.toString());
            }
        }
    }

    private void list() {
        for (Media m : itemsOrdered) {
            System.out.println(m.toString());
        }
    }

    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
        list();
    }

    public void sortByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
        list();
    }

    public Media search(String a) {
        Media found = null;
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(a)) {
                System.out.println(m.toString());
                found = m;
                break;
            }
        }
        return found;
    }

    public void kill() {
        itemsOrdered.clear();
        amount = 0;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public ObservableList<Media> getItemsOrdered(String target) {
        ObservableList<Media> list = FXCollections.observableArrayList();
        for (Media m : itemsOrdered) {
            if (m.getTitle().toLowerCase().contains(target.toLowerCase())) {
                list.add(m);
            }
        }
        return list;
    }

    public ObservableList<Media> getItemsOrdered(int target) {
        ObservableList<Media> list = FXCollections.observableArrayList();
        for (Media m : itemsOrdered) {
            if (m.getId() == target) {
                list.add(m);
                break;
            }
        }
        return list;
    }
}
