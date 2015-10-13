package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.FunctionaryFormBean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.FunctionaryListItem;

public class FunctionaryFormView extends ActionForm {	

	private static final long serialVersionUID = 1L;
	private FunctionaryListItem[] functionaryListItems= new FunctionaryListItem[0];

	public FunctionaryFormView() { }

	public FunctionaryFormView(FunctionaryListItem[] functionaryListItems, String updateButton, String deleteButton) {
		this.functionaryListItems = functionaryListItems;
	}
		
	public FunctionaryListItem[] getFunctionaryListItems() {
		return functionaryListItems;
	}
	public void setFunctionaryListItems(FunctionaryListItem[] functionaryListItems) {
		this.functionaryListItems = functionaryListItems;
	}
	public FunctionaryListItem getFunctionaryListItems(Integer index) {
		return functionaryListItems[index];
	}
	public void setFunctionaryListItems(Integer index, FunctionaryListItem functionaryListItems) {
		this.functionaryListItems[index] = functionaryListItems;
	}	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		if ("submit".equals(mapping.getParameter())) 
			for (int i = 0; i < functionaryListItems.length; i++) 
				functionaryListItems[i].setChecked(false);
	}

	@SuppressWarnings("rawtypes")
	public void setFunctionaryList(Collection<FunctionaryFormBean> functionarys) {
		List<FunctionaryListItem> functionaryListItems = new ArrayList<FunctionaryListItem>(functionarys.size());
		Iterator iterator = functionarys.iterator();
		
		while(iterator.hasNext()) {
			FunctionaryListItem functionaryListItem = new FunctionaryListItem();
			FunctionaryFormBean functionary = (FunctionaryFormBean) iterator.next();
			functionaryListItem.setFunctionary(functionary);
			functionaryListItems.add(functionaryListItem);
		}
		
		this.functionaryListItems = 
			(FunctionaryListItem[]) functionaryListItems.toArray(new FunctionaryListItem[functionaryListItems.size()]);
	}
		
}
