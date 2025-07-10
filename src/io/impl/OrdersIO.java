package io.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.IO;
import model.Order;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class OrdersIO implements IO<Order> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Path filePath = Path.of("orders.json");

    @Override
    public void writeFile(List<Order> data) {
        String ordersJson = gson.toJson(data);

        try {
            Files.writeString(filePath, ordersJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> readFile() {
        try {
            String ordersFromFileString = Files.readString(filePath);
            Type orderListType = new TypeToken<List<Order>>() {}.getType();
            return gson.fromJson(ordersFromFileString, orderListType);
        } catch (IOException e) {
            throw  new RuntimeException(e.getMessage());
        }
    }
}
