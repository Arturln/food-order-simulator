package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Food;
import model.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FoodDataIO implements IO<Food>{

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Path filePath = Path.of("foods.json");

    @Override
    public void writeFile(List<Food> data) {
        String foodsJson = gson.toJson(data);

        try {
            Files.writeString(filePath, foodsJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Food> readFile() {
        try {
            String foodsFromFileString = Files.readString(filePath);
            Type foodListType = new TypeToken<List<Food>>() {}.getType();
            return gson.fromJson(foodsFromFileString, foodListType);
        } catch (IOException e) {
            throw  new RuntimeException(e.getMessage());
        }
    }
}
