package model;

import java.io.Serializable;

import model.OperatorFormBean;

public class OperatorListItem implements Serializable {	

	private static final long serialVersionUID = 1L;
	private OperatorFormBean operator;
	private boolean checked = false;

	public OperatorListItem() { }

	public OperatorListItem(OperatorFormBean operator, boolean checked) {
		this.operator = operator;
		this.checked = checked;
	}
	
	public OperatorFormBean getOperator() {
		return operator;
	}

	public void setOperator(OperatorFormBean operator) {
		this.operator = operator;
	}

	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}	
		
}
