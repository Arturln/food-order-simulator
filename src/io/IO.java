package io;

import java.util.List;

public interface IO<T> {

    void writeFile(List<T> data);

    List<T> readFile();


}
