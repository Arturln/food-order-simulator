package repository.impl;

import repository.Crudable;

public class Menu implements Crudable {

    private int id;
    private String name;
    private double cost;
    private double weight;

    @Override
    public void create(int id) {

    }

    @Override
    public String read() {
        return "";
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }
}
