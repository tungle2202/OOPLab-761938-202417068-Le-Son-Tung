package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc{
    private static int nbDigitalVideoDisc = 0;


    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public String toString(){
        String result = "";
        result += "DVD ";
        if(this.getTitle() != null){
            result += ("- ");
            result += (this.getTitle());
        }
        if(this.getCategory() != null){
            result += ("- ");
            result += (this.getCategory());
        }
        if(this.getDirector() != null){
            result += ("- ");
            result += (this.getDirector());
        }
        if(this.getLength() != -1){
            result += ("- ");
            result += (String.valueOf(this.getLength()));
        }
        if(this.getCost() != -1){
            result += (": ");
            result += (String.valueOf(this.getCost()));
        }
        return result;
    }
    public Boolean isMatch(String title){
        return title.equalsIgnoreCase(this.getTitle().toLowerCase());
    }
}
