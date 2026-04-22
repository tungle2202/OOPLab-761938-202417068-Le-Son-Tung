package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparedByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media, Media t1) {
        int temp = media.getTitle().toLowerCase().compareTo(t1.getTitle().toLowerCase());
        if(temp != 0){
            return temp;
        }else{
            return (media.getCost() > t1.getCost())?1:-1;
        }
    }
}
