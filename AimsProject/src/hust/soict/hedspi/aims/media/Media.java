package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Scanner;
import hust.soict.hedspi.aims.exception.InvalidValueException;
import hust.soict.hedspi.aims.exception.PlayerException;

public abstract class Media {
    private Scanner scanner = new Scanner(System.in);
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparedByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparedByCostTitle();
    private static int nbMedia = 1;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public Media(String title, String category, float cost) throws InvalidValueException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidValueException("Media title cannot be null or empty.");
        }
        if (cost < 0) {
            throw new InvalidValueException("Media cost cannot be negative: " + cost);
        }
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbMedia;
        nbMedia++;
    }

    public Media() {
        this.title = "Unknown Media";
        this.category = "Unknown Category";
        this.cost = 0.0f;
        this.id = nbMedia;
        nbMedia++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Media)) {
            return false;
        }
        Media other = (Media) o;
        
        if (this.title == null || other.title == null) {
            return false;
        }
        
        return this.title.equals(other.title) && Float.compare(this.cost, other.cost) == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append("\tCategory: ");
        sb.append(this.category);
        sb.append("\tTitle: ");
        sb.append(this.title);
        String result = sb.toString();
        return result;
    }

    public void play() throws PlayerException {
        if (this instanceof Playable) {
            ((Playable) this).play();
        } else {
            System.out.println("San pham nay khong ho tro tinh nang play!");
        }
    }


}
