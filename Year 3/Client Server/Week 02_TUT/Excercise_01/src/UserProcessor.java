public class UserProcessor implements Runnable {

    UserValidator validator;
    UserDataStore dataStore;
    Object lock;
    String name;
    int age;

    public UserProcessor(UserValidator validator, UserDataStore dataStore, Object lock, String name, int age) {
        this.validator = validator;
        this.dataStore = dataStore;
        this.lock = lock;
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (validator.isValidAge(age)) {
                dataStore.addUser(new User(name, age));
            } else {
                System.out.println("Invalid age for User " + name);
            }
        }
    }
}