package domain;

public class Comment {
    Person author;
    String comment;
    int rating;
    public Comment(Person author,String comment, int rating){
        this.author = author;
        this.comment = comment;
        this.rating = rating;
    }
    public Person getAuthor(){
        return author;
    }
    public String getComment(){
        return comment;
    }
    public int getRating(){return rating;}

}
