package dao;

import java.util.Collection;

import model.DepartmentFormBean;

public interface DepartmentDao {
	
	public void create(DepartmentFormBean departmentFormBean);
	
	public DepartmentFormBean read(Long id);
	
	public void update(DepartmentFormBean departmentFormBean);
	
	public void delete(DepartmentFormBean departmentFormBean);
	
	public Collection<DepartmentFormBean> all();

}
