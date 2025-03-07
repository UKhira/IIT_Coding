import java.util.ArrayList;
import java.util.List;

public class UserDataStore {
    private List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userList);
    }
}
