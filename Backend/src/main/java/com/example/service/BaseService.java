package com.example.service;

import java.util.List;

public interface BaseService <T> {

	public List<T> getAll();
	public T getOne(int id);
	public T post(T t);
	public T put(T t, int id);
	public boolean delete(int id);
	
}
