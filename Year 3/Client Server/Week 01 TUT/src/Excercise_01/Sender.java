package Excercise_01;

public class Sender {

    private Message message;

    public void createMessage(Message message){
        this.message = message;
        System.out.println("Message has been created");;
    }

    public Message sendMessage(){
        System.out.println("Message has been sent to receiver");
        return (this.message);
    }
}
