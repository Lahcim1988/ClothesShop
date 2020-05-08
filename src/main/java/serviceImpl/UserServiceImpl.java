package serviceImpl;

import dao.UserDaoImpl;
import entity.User;
import validator.UserValidator;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserDao;
import service.UserService;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() {}

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

//    public UserServiceImpl(List<User> users) {
//        this.users = users;
//    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    // Validator
    @Override
    public void addUser(User user) throws IOException, UserShortLengthPasswordException, UserLoginAlreadyExistException,
            UserShortLengthLoginException {
            if(userValidator.isValidate(user)){
                userDao.saveUser(user);
            }
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
//        for (User user : users) {
//            boolean userIdEqual = user.getId() == userId;
//            if (userIdEqual) {
//                users.remove(user);
//                break;
//            }
//        }
    }
}
