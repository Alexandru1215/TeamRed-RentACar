package rent_a_car2;

import java.util.List;

public interface CrudManagement<T> {
    void insert(T item);
    void update(T item);
    List<T> getAll();
    T getById(int id);
    void delete(int item);
}

