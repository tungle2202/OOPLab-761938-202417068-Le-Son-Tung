package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
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

    @Override
    public int getLength(){
        int length = 0;
        for(Track a: tracks){
            length += a.getLength();
        }
        return length;
    }

    public void play() {
        if (this.getLength() > 0) {
            System.out.println("CD: " + this.getTitle() + "\tArtist: " + artist);
            System.out.println("Thoi luong CD: " + this.getLength());
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("CD TRANG THONG TIN!");
        }
    }
}
