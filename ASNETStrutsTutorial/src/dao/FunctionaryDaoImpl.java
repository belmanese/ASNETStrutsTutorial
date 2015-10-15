package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import service.MysqlConnect;

import model.DepartmentFormBean;
import model.FunctionaryFormBean;

public class FunctionaryDaoImpl implements FunctionaryDao {

	public void create(FunctionaryFormBean functionary) {
		String sql = "INSERT INTO funtionary (name, salary, department_ID) VALUES ('"+functionary.getName()+"', "+functionary.getSalary()+", "+functionary.getDepartment().getId()+")";
		MysqlConnect.create(sql);
	}

	public FunctionaryFormBean read(Long id) {
		return null;
	}

	public void update(FunctionaryFormBean functionary) {		
		
		String id = functionary.getId().toString();
		String name = functionary.getName();
		String salary = functionary.getSalary().toString();
		String department_ID = functionary.getDepartment().getId().toString();
		
		String sql = "UPDATE funtionary SET name='" + name + "', salary=" + salary + ", department_ID=" + department_ID + " WHERE id=" + id;
		MysqlConnect.update(sql);
		
	}
	
	public void delete(FunctionaryFormBean functionary) {	
		
		String id = functionary.getId().toString();
		
		String sql = "DELETE FROM funtionary WHERE id=" + id;
		MysqlConnect.delete(sql);
		
	}

	public Collection<FunctionaryFormBean> all() {
		
	    List<FunctionaryFormBean> functionaries = new ArrayList<FunctionaryFormBean>();
		String sql = "SELECT * FROM funtionary";
		Iterator<?> iterator = MysqlConnect.read(sql).getRows().iterator();
		
	    while(iterator.hasNext()) {
	        DynaBean bean = (DynaBean)iterator.next();
	        DepartmentFormBean department = new DepartmentDaoImpl().read(Long.parseLong(bean.get("department_id").toString()));
	        functionaries.add(
	            new FunctionaryFormBean(
		            Long.parseLong(bean.get("id").toString()), 
	                bean.get("name").toString(), 
	                new BigDecimal(bean.get("salary").toString()),
	                department
	            )
	        );
	    }
	    
		return functionaries;
		
	}

}
