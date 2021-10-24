package com.bioskop.main.dao;

import java.sql.SQLException;
import java.util.List;

import com.bioskop.main.model.Model;

public interface DaoInterfaces<T extends Model> {
	
	public int save(T model) throws SQLException;
	public void delete(T  model) throws SQLException;
	public void delete(int id) throws SQLException;
	public void update(T  model) throws SQLException;
	public T  getById(T  model) throws SQLException;
	public T  getById(int id) throws SQLException;
	public List<T> getAll() throws SQLException;

}
