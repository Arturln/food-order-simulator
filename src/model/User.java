package src.model;

import java.util.Random;

public class User {
    Random random = new Random();

    private int id;
    private String name;
    private long phoneNumber;

    public User(String name, long phoneNumber) {
        this.id = random.nextInt(1, 100000);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
