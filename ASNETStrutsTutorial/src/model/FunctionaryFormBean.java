package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@Data
@NoArgsConstructor
public class FunctionaryFormBean extends ActionForm implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	private Long id;
	private String name;
	private BigDecimal salary;
	private DepartmentFormBean department = new DepartmentFormBean();
	private List<DepartmentFormBean> departmentList;
	
	public FunctionaryFormBean(Long id, String name, BigDecimal salary, DepartmentFormBean department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		this.id = 0L;
		this.name = "";
		this.salary = new BigDecimal(0);
		this.department = new DepartmentFormBean();
		this.departmentList = new ArrayList<DepartmentFormBean>();
		
	}
	
}
