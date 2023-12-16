package hifresh.repository;

import java.util.Optional;

public interface Repository <T>{
    public T findById(int id);

    public void update(T t);

    public T save(T t);

    public void clear();

}
