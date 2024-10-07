
public class TutorialWeek02 {
    public static void main(String[] args) {

// Let’s go back to our TutorialWeek02 class. Since we now have the Person class, let’s make some use out of it.  In the "main" method of our TutorialWeek02 class, create a Person named "Ben".
        Person personOne = new Person("Ben");
        personOne.displayName();

// In the main() on TutorialWeek02 class create other three persons and for all of them print on the screen their name , surname and age
        Person personTwo = new Person("Jackson");
        personTwo.setSurname("Jackie");
        personTwo.setAge(20);

        Person personThree = new Person("Jackson");
        personThree.setSurname("Percy");
        personThree.setAge(24);

        Person personFour = new Person("Bob");
        personFour.setSurname("Marley");
        personFour.setAge(30);

        System.out.println(personTwo.getSurName());
        System.out.println(personTwo.getAge());

        System.out.println(personThree.getSurName());
        System.out.println(personThree.getAge());

        System.out.println(personFour.getSurName());
        System.out.println(personFour.getAge());

    }
}