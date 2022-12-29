package ir.lazydeveloper.dao;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    void  save(T t);

    void  update(T t);

    void remove(T t);

    Optional<T> findById(Number id);

    List<T> findAll();
}
