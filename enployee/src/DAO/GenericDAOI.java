package DAO;

import java.util.List;

import Model.Holiday;

public interface GenericDAOI<T> {
	

	    public void add(T t);

	    public void update(T t, int id);

	    public void delete(int id);

	   // public T findById(int id);

	    public List<T> findAll();

		public Holiday getById(int id);

	

	
}