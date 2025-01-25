package Excercise_01;

public class Message {
    private String content;

    public Message(){
        this.content = "Sample Content";
    }

    public Message(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public String toString(){
        return String.format(this.content);
    }
}
