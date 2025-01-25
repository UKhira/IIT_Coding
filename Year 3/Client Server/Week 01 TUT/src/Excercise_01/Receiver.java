package Excercise_01;

public class Receiver {

    public void receiveMessage(Sender sender){
        System.out.println("Message has been Received");
        System.out.println("Message is: " + sender.sendMessage());
    }
}
