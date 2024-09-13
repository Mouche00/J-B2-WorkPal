package service.interfaces;

import java.sql.SQLException;
import java.util.HashMap;

public interface ServiceInterface<T> {

    void save(T t) throws SQLException;

    HashMap<String, T> getAll() throws SQLException;
}
