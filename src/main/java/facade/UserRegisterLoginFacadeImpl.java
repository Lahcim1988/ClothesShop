package facade;

import entity.User;
import service.UserRegisterLoginFacade;
import service.UserService;
import serviceImpl.UserServiceImpl;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {
    private UserService userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginFacade instance = null;

    private UserRegisterLoginFacadeImpl() {

    }

    public static UserRegisterLoginFacade getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    public boolean registerUser(User user) {
        return userService.addUser(user);
    }

    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }

        return false;
    }
}
