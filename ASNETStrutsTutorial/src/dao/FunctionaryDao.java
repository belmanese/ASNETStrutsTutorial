package dao;

import java.util.Collection;

import model.FunctionaryFormBean;

public interface FunctionaryDao {
	
	public void create(FunctionaryFormBean functionary);
	
	public FunctionaryFormBean read(Long id);
	
	public void update(FunctionaryFormBean functionary);
	
	public void delete(FunctionaryFormBean functionary);
	
	public Collection<FunctionaryFormBean> all();

}
