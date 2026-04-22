package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparedByCostTitle implements Comparator<Media>{
    @Override
    public int compare(Media media, Media t1) {
        int temp = (media.getCost() == t1.getCost())?0:1;
        if(temp != 0){
            return (media.getCost() > t1.getCost())?1:-1;
        }else{
            return media.getTitle().toLowerCase().compareTo(t1.getTitle().toLowerCase());
        }
    }
}
