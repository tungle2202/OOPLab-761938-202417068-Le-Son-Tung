package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.hedspi.aims.exception.InvalidValueException;
import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist) throws InvalidValueException {
        super(title, category, cost, length, director);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost) throws InvalidValueException {
        super(title, category, cost);
    }

    public CompactDisc() {
        super();
    }

    public void addTrack(Track a) {
        if (tracks.contains(a)) {
            System.out.println("Da ton tai track!");
        } else {
            tracks.add(a);
            getLength();
        }
    }

    public void removeTrack(Track a) {
        if (tracks.contains(a)) {
            tracks.remove(a);
            getLength();
        } else {
            System.out.println("Khong ton tai track!");
        }
    }

    @Override
    public int getLength() {
        int length2 = 0;
        for (Track a : tracks) {
            length2 += a.getLength();
        }
        setLength(length2);
        return length2;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("CD length is non-positive: " + this.getLength());
        }
        System.out.println("CD: " + this.getTitle() + "\tArtist: " + artist);
        System.out.println("Thoi luong CD: " + this.getLength());
        Iterator<Track> iter = tracks.iterator();
        Track nextTrack;
        while (iter.hasNext()) {
            nextTrack = (Track) iter.next();
            try{
                nextTrack.play();
            }catch(PlayerException e){
                throw e;
            }
        }
    }
}
