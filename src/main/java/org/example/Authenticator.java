package org.example;

import org.apache.commons.codec.digest.DigestUtils;
public class Authenticator {
    public static User login(String login, String password){
        UserRepository userRepository = new UserRepository();
        User userFromFile = userRepository.getUser(login);
        if ( hashPassword(password).equals(userFromFile.getPassword()) ) {
            return userFromFile;
        }
        return null;
    }

    public static String hashPassword(String password){
        return DigestUtils.sha256Hex(password);
    }
}
