package io.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.IO;
import model.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UserDataIO implements IO<User> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Path filePath = Path.of("users.json");

    @Override
    public void writeFile(List<User> data) {

        String usersJson = gson.toJson(data);

        try {
            Files.writeString(filePath, usersJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> readFile() {
        try {
            String usersFromFileString = Files.readString(filePath);
            Type userListType = new TypeToken<List<User>>() {}.getType();
            return gson.fromJson(usersFromFileString, userListType);
        } catch (IOException e) {
            throw  new RuntimeException(e.getMessage());
        }
    }
}
