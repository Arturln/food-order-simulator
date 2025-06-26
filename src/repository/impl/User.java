package repository.impl;

import repository.Crudable;

public class User implements Crudable {

    private int id;
    private String name;
    private int phone;

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
