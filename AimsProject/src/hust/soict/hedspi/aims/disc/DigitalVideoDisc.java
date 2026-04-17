package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbDigitalVideoDisc = 0;

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public int getId() {
        return id;
    }

    public float getCost() {
        return cost;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.cost = -1;
        this.length = -1;
        this.id = nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = nbDigitalVideoDisc;
        this.length = -1;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.length = -1;
        this.id = nbDigitalVideoDisc;
        nbDigitalVideoDisc++;

    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        String result = "";
        result += "DVD ";
        if(this.title != null){
            result += ("- ");
            result += (this.title);
        }
        if(this.category != null){
            result += ("- ");
            result += (this.category);
        }
        if(this.director != null){
            result += ("- ");
            result += (this.director);
        }
        if(this.length != -1){
            result += ("- ");
            result += (String.valueOf(this.length));
        }
        if(this.cost != -1){
            result += (": ");
            result += (String.valueOf(this.cost));
        }
        return result;
    }
    public Boolean isMatch(String title){
        return title.equalsIgnoreCase(this.title.toLowerCase());
    }
}
