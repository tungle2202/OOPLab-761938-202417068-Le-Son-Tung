package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private int amount = 0;
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost){
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
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
