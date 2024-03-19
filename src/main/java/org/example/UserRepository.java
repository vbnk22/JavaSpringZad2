package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public User getUser(String login){
        for (var u: users){
            if (u.getLogin().equals(login)){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers(){
        return users;
    }

    @Override
    public void save(String path){
        File newFile = new File(path);

        try{
            if (!newFile.exists()){
                newFile.createNewFile();
            }

            FileWriter fw = new FileWriter(path);
            fw.write("");
            for (var u: users) {
                fw.write(u.toCSV() + "\n");
            }
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user){
        users.add(user);
    }
}
