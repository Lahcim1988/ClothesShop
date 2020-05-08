package entity;

import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public class UserValidator {

    private static UserValidator instance = null;

    private UserValidator() {
    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException,
            UserShortLengthPasswordException {

        if (isPasswordLengthEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short");
        }

        if (isLoginLengthEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short");
        }

        if (isLoginAlreadyExist(user.getLogin())) {
            throw new UserLoginAlreadyExistException("User with this login already exists.");
        }

        return true;
    }
}
