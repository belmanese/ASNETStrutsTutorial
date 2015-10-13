package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import service.MysqlConnect;

import model.DepartmentFormBean;

public class DepartmentDaoImpl implements DepartmentDao {

	public void create(DepartmentFormBean department) {
		String sql = "INSERT INTO department (name, status) VALUES ('"+department.getName()+"', "+department.getStatus()+")";
		MysqlConnect.create(sql);
	}

	public DepartmentFormBean read(Long id) {
		String sql = "SELECT * FROM department WHERE id="+id;

		DepartmentFormBean department = new DepartmentFormBean();
		Iterator<?> iterator = MysqlConnect.read(sql).getRows().iterator();
		
	    while(iterator.hasNext()) {
	        DynaBean bean = (DynaBean)iterator.next();
	        department = new DepartmentFormBean(
	            Long.parseLong(bean.get("id").toString()), 
		        bean.get("name").toString(), 
		        Boolean.parseBoolean(bean.get("status").toString())	
            );
	    }
	    
		return department;
	}

	public void update(DepartmentFormBean department) {		
		
		String id = department.getId().toString();
		String name = department.getName();
		String salary = String.valueOf(department.getStatus());
		
		String sql = "UPDATE department SET id=" + id + ", name='" + name + "', salary=" + salary + " WHERE id=" + id + "";
		MysqlConnect.update(sql);
		
	}
	
	public void delete(DepartmentFormBean department) {	
		
		String id = department.getId().toString();
		
		String sql = "DELETE FROM department WHERE id=" + id;
		MysqlConnect.delete(sql);
		
	}

	public Collection<DepartmentFormBean> all() {
		
	    List<DepartmentFormBean> departments = new ArrayList<DepartmentFormBean>();
		String sql = "SELECT * FROM department";
		Iterator<?> iterator = MysqlConnect.read(sql).getRows().iterator();
		
	    while(iterator.hasNext()) {
	        DynaBean bean = (DynaBean)iterator.next();
	        departments.add(
	            new DepartmentFormBean(
	            	Long.parseLong(bean.get("id").toString()), 
		            bean.get("name").toString(), 
		            Boolean.parseBoolean(bean.get("status").toString())	
	            )
	        );
	    }
	    
		return departments;
		
	}

}
