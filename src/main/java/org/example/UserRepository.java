package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository implements IUserRepository{
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        readCSV("C:\\Users\\olesz\\Desktop\\danne\\users.txt");
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

    public void readCSV(String path) {
        File newFile = new File(path);

        try {
            Scanner sc = new Scanner(newFile);

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] stringUser = line.split(";");
                User user = new User(stringUser[0], stringUser[1], User.Role.valueOf(stringUser[2]), stringUser[3]);

                users.add(user);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user){
        users.add(user);
    }
}
