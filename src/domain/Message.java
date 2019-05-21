package domain;

public class Message {
    private Person author;
    private String text;
    private Person reciever;

    public Message(Person author,String text, Person reciever){
        this.author=author;
        this.text=text;
        this.reciever=reciever;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getReciever() {
        return reciever;
    }

    public void setReciever(Person reciever) {
        this.reciever = reciever;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }
    public String toString(){
        return author + ":" + text;
    }
}
