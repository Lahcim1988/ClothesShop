package serviceImpl;

import entity.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
    }

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUserById(Long userId) {
        for (User user : users) {
            boolean userIdEqual = user.getId() == userId;
            if(userIdEqual){
                users.remove(user);
                break;
            }
        }
    }
}
