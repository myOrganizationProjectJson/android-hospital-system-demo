package com.hospital.dao;

import java.util.List;

// BaseDao�ӿ�
public interface BaseDao<T> {
	public boolean save(T t);
	public boolean delete(int id);
	public T get(int id);
	public boolean update(T t);
	public List<T> getAll();
}
