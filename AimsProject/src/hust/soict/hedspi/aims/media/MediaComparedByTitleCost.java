package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparedByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media, Media t1) {
        if (media == null || t1 == null) {
            throw new NullPointerException("Arguments to compare cannot be null.");
        }
        if (!(media instanceof Media) || !(t1 instanceof Media)) {
            throw new ClassCastException("Arguments must be of type Media.");
        }

        // Title comparison
        if (media.getTitle() == null && t1.getTitle() == null) {
            // compare by cost since titles are both null
            if (media.getCost() > t1.getCost()) {
                return 1;
            } else if (media.getCost() < t1.getCost()) {
                return -1;
            } else {
                return 0;
            }
        }
        if (media.getTitle() == null) {
            return -1;
        }
        if (t1.getTitle() == null) {
            return 1;
        }

        int temp = media.getTitle().compareToIgnoreCase(t1.getTitle());
        if (temp != 0) {
            return temp;
        } else {
            if (media.getCost() > t1.getCost()) {
                return 1;
            } else if (media.getCost() < t1.getCost()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
