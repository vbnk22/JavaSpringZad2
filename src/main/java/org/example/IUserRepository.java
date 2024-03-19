package org.example;

import java.util.List;

public interface IUserRepository {
    public User getUser(String login);

    public List<User> getUsers();

    public void save(String path);

    public void addUser(User user);
}
