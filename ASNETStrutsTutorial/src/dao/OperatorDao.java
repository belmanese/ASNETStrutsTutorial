package dao;

import java.util.Collection;

import model.OperatorFormBean;

public interface OperatorDao {
	
	public void create(OperatorFormBean operator);
	
	public OperatorFormBean read(Long id);
	
	public void update(OperatorFormBean operator);
	
	public void delete(OperatorFormBean operator);
	
	public Collection<OperatorFormBean> all();

}
