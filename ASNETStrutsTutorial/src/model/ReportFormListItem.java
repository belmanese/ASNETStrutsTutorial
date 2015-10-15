package model;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ReportFormListItem extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String functionaryName;
	private String departmentName;
	private String operatorName;
	private int minutes;
	private BigDecimal cost;

	
	public ReportFormListItem() { }
	public ReportFormListItem(String functionaryName, String departmentName,
			String operatorName, int minutes, BigDecimal cost) {
		this.functionaryName = functionaryName;
		this.departmentName = departmentName;
		this.operatorName = operatorName;
		this.minutes = minutes;
		this.cost = cost;
	}
	
	public String getFunctionaryName() {
		return functionaryName;
	}
	public void setFunctionaryName(String functionaryName) {
		this.functionaryName = functionaryName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result
				+ ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result
				+ ((functionaryName == null) ? 0 : functionaryName.hashCode());
		result = prime * result + minutes;
		result = prime * result
				+ ((operatorName == null) ? 0 : operatorName.hashCode());
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
		ReportFormListItem other = (ReportFormListItem) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (functionaryName == null) {
			if (other.functionaryName != null)
				return false;
		} else if (!functionaryName.equals(other.functionaryName))
			return false;
		if (minutes != other.minutes)
			return false;
		if (operatorName == null) {
			if (other.operatorName != null)
				return false;
		} else if (!operatorName.equals(other.operatorName))
			return false;
		return true;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		this.functionaryName = "";
		this.departmentName = "";
		this.operatorName = "";
		this.minutes = 0;
		this.cost = new BigDecimal(0);
		
	}
	
}
