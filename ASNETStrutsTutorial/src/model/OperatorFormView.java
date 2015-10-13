package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.OperatorFormBean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.OperatorListItem;

public class OperatorFormView extends ActionForm {	

	private static final long serialVersionUID = 1L;
	private OperatorListItem[] operatorListItems= new OperatorListItem[0];
	private String updateButton;
	private String deleteButton;

	public OperatorFormView() { }

	public OperatorFormView(OperatorListItem[] operatorListItems, String updateButton, String deleteButton) {
		this.operatorListItems = operatorListItems;
		this.updateButton = updateButton;
		this.deleteButton = deleteButton;
	}
		
	public OperatorListItem[] getOperatorListItems() {
		return operatorListItems;
	}
	public void setOperatorListItems(OperatorListItem[] operatorListItems) {
		this.operatorListItems = operatorListItems;
	}
	public OperatorListItem getOperatorListItems(Integer index) {
		return operatorListItems[index];
	}
	public void setOperatorListItems(Integer index, OperatorListItem operatorListItems) {
		this.operatorListItems[index] = operatorListItems;
	}	
	public String getUpdateButton() {
		return updateButton;
	}
	public void setUpdateButton(String updateButton) {
		this.updateButton = updateButton;
	}
	public String getDeleteButton() {
		return deleteButton;
	}
	public void setDeleteButton(String deleteButton) {
		this.deleteButton = deleteButton;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		if ("submit".equals(mapping.getParameter())) 
			for (int i = 0; i < operatorListItems.length; i++) 
				operatorListItems[i].setChecked(false);
	}

	@SuppressWarnings("rawtypes")
	public void setOperatorList(Collection<OperatorFormBean> operators) {
		List<OperatorListItem> operatorListItems = new ArrayList<OperatorListItem>(operators.size());
		Iterator iterator = operators.iterator();
		
		while(iterator.hasNext()) {
			OperatorListItem operatorListItem = new OperatorListItem();
			OperatorFormBean operator = (OperatorFormBean) iterator.next();
			operatorListItem.setOperator(operator);
			operatorListItems.add(operatorListItem);
		}
		
		this.operatorListItems = 
			(OperatorListItem[]) operatorListItems.toArray(new OperatorListItem[operatorListItems.size()]);
	}
		
}
