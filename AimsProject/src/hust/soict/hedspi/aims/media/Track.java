package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.InvalidValueException;
import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) throws InvalidValueException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidValueException("Track title cannot be null or empty.");
        }
        if (length <= 0) {
            throw new InvalidValueException("Track length must be positive: " + length);
        }
        this.title = title;
        this.length = length;
    }

    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("Track length is non-positive: " + this.getLength());
        }
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Track)) {
            return false;
        }
        Track vip = (Track) o;
        if (vip.title != null && vip.title.equals(this.title) && vip.length == this.length) {
            return true;
        }
        return false;
    }
}
