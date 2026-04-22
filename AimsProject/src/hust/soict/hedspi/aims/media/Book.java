package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private int amount = 0;
    private List<String> authors = new ArrayList<String>();

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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    public Book(int id, String title, String category, float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public void addAuthor(String name){
        boolean existed = false;
        for(String n : authors){
            if(n.equals(name)){
                existed = true;
                break;
            }
        }
        if(existed){
            System.out.println("Tac gia " + name + " Da co trong danh sach tac gia!");
        }else{
            authors.add(name);
            System.out.println("Them thanh cong");
        }
    }

    public void removeAuthor(String name){
        boolean existed = false;
        for(String n : authors){
            if(n.equals(name)){
                existed = true;
                break;
            }
        }
        if(existed){
            authors.remove(name);
            System.out.println("Xoa thanh cong");
        }
    }
}
