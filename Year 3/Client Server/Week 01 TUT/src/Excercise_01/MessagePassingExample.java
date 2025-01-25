package Excercise_01;

public class MessagePassingExample {
    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();

        sender.createMessage(new Message("Sample Message Example"));
        sender.sendMessage();

        receiver.receiveMessage(sender);
    }
}
