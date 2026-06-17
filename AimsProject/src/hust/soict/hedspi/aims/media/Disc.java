package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.InvalidValueException;

public class Disc extends Media {
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Disc(String title, String category, float cost, int length, String director) throws InvalidValueException {
        super(title, category, cost);
        if (length <= 0) {
            throw new InvalidValueException("Disc length must be positive: " + length);
        }
        this.length = length;
        this.director = director;
    }

    public Disc(String title, String category, float cost) throws InvalidValueException {
        super(title, category, cost);
    }

    public Disc() {
        super();
    }
}
