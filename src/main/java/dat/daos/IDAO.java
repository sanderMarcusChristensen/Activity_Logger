package dat.daos;

import java.util.Set;

public interface IDAO<T> {
    T create(T t);
    T update(T t);
    void delete(T t);
    T getById(Long id);
    Set<T> getAll();
}
