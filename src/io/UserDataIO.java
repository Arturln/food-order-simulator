package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Order;
import model.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UserDataIO {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Path filePath = Path.of("users.json");

    public void writeFile(List<User> data) {

        String ordersJson = gson.toJson(data);

        try {
            Files.writeString(filePath, ordersJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> readFile() {
        try {
            String ordersFromFileString = Files.readString(filePath);
            Type orderListType = new TypeToken<List<Order>>() {}.getType();
            return gson.fromJson(ordersFromFileString, orderListType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
