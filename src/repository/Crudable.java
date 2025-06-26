package repository;

public interface Crudable {

    void create(int id);

    String read();

    void update(int id);

    void delete(int id);



}
