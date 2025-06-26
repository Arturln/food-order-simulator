package repository.impl;

import repository.Crudable;

public class Order implements Crudable {

    private int id;
    private User user;
    private Menu menu;

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
