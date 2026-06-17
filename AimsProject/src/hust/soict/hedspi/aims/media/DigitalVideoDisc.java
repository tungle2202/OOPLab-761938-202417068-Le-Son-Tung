package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.InvalidValueException;
import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title, String category, float cost, int length, String director) throws InvalidValueException {
        super(title, category, cost, length, director);
    }

    public DigitalVideoDisc(String title, String category, float cost) throws InvalidValueException {
        super(title, category, cost);
    }

    public DigitalVideoDisc() {
        super();
    }

    public Boolean isMatch(String title) {
        if (this.getTitle() == null) {
            return false;
        }
        return title.equalsIgnoreCase(this.getTitle().toLowerCase());
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("DVD length is non-positive: " + this.getLength());
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
