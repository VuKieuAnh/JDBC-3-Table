package org.example.jdbc3table.service;

import java.sql.SQLException;
import java.util.List;

public interface IGenericService<T> {
    public void insert(T object) throws SQLException;

    public T selectById(int id);

    public List<T> selectAll();

    public boolean deleteById(int id) throws SQLException;

    public boolean update(T user) throws SQLException;
}
