package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc{
    private String artist;
    private ArrayList<Track>tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public void addTrack(Track a){
        if(tracks.contains(a)){
            System.out.println("Da ton tai track!");
        }else{
            tracks.add(a);
        }
    }
    public void removeTrack(Track a){
        if(tracks.contains(a)){
            tracks.remove(a);
        }else{
            System.out.println("Khong ton tai track!");
        }
    }

    public int getLength(){
        int length = 0;
        for(Track a: tracks){
            length += a.getLength();
        }
        return length;
    }
}
