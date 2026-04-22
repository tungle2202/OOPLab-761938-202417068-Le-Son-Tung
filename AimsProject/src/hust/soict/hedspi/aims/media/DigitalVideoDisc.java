package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media{

    private String director;
    private int length;
    private static int nbDigitalVideoDisc = 0;
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }



    public DigitalVideoDisc(String title) {
        this.setTitle(title);
        this.setCost(-1);
        this.length = -1;
        this.setId(nbDigitalVideoDisc);
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        this.setId(nbDigitalVideoDisc);
        this.length = -1;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        this.length = -1;
        this.setId(nbDigitalVideoDisc);
        nbDigitalVideoDisc++;

    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
        this.setCost(cost);
        this.setId(nbDigitalVideoDisc);
        nbDigitalVideoDisc++;
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
        if(this.director != null){
            result += ("- ");
            result += (this.director);
        }
        if(this.length != -1){
            result += ("- ");
            result += (String.valueOf(this.length));
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
