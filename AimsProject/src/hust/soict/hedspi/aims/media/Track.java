package hust.soict.hedspi.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title) {
        this.title = title;
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    @Override
    public boolean equals(Object o){
        Track vip = (Track)o;
        if(vip.title.equals(this.title) && vip.length == this.length){
            return true;
        }
        return false;
    }
}
