package model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.struts.action.ActionForm;

public class FunctionaryFormBean extends ActionForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private BigDecimal salary;
	private DepartmentFormBean department;
	
	public FunctionaryFormBean() { }
	public FunctionaryFormBean(Long id, String name, BigDecimal salary, DepartmentFormBean department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public DepartmentFormBean getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentFormBean department) {
		this.department = department;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunctionaryFormBean other = (FunctionaryFormBean) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "FunctionaryFormBean [id=" + id + ", name=" + name + ", salary="
				+ salary + ", department=" + department + "]";
	}
	
}
