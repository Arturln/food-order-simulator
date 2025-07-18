package model;

public class Food {

    private int id;
    private String name;
    private double cost;
    private double weight;

    public Food(int id, String name, double cost, double weight) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.weight = weight;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Food ID: " + id + " Name: " + name + " Cost: " + cost + " Weight: " + weight;
    }
}
