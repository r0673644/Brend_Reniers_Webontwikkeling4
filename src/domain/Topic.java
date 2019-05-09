package domain;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private int id;
    private String thema;
    private String description;
    private List<Comment>comments;

    public Topic(int id,String thema,String description){
        this.id=id;
        this.thema= thema;
        this.description= description;
        comments = new ArrayList<>();
    }

    public int getId(){return id;}
    public String getThema() {
        return thema;
    }
    public void setThema(String thema) {
        this.thema = thema;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description=description;
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }
    public List<Comment> getComments(){return comments;}
}
