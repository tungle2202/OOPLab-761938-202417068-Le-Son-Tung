package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Scanner;

public abstract class Media {
    private Scanner scanner = new Scanner(System.in);
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparedByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparedByCostTitle();
    private static int nbMedia = 1;
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbMedia;
        nbMedia++;
    }

    public Media(){
        simpleBuild();
    }

    @Override
    public boolean equals(Object o){
        if(((Media)o).title.equals(this.title)){
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append("\tCategory: ");
        sb.append(this.category);
        sb.append("\tTitle: ");
        sb.append(this.title);
        String result = sb.toString();
        return result;
    }

    public void play(){
        if(this instanceof Book){
            System.out.println("San pham nay khong ho tro tinh nang play!");
        }else{
            this.play();
        }
    }

    public void simpleBuild(){
        String title;
        String category;
        float cost;
        System.out.println("Nhap title: ");
        this.title = scanner.nextLine();
        System.out.println("Nhap category: ");
        this.category = scanner.nextLine();
        System.out.println("Nhap gia: ");
        this.cost = scanner.nextFloat();
    }
}
