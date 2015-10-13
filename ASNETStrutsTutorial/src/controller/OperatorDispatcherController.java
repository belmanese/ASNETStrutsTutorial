package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OperatorFormBean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.OperatorDaoImpl;

import model.OperatorListItem;
import model.OperatorFormView;

public class OperatorDispatcherController extends DispatchAction {
	
	public ActionForward create(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

		new OperatorDaoImpl().create((OperatorFormBean) form);
		((OperatorFormBean) form).reset(mapping, request);
		
		return update(mapping, new OperatorFormView(), request, response);
	}
	
	public ActionForward read(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {		
		
		((OperatorFormView) form).setOperatorList(new OperatorDaoImpl().all());
		return mapping.findForward("readOperatorsForward");
		
	}
	
	public ActionForward update(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
		
		OperatorListItem[] operatorListItems = ((OperatorFormView) form).getOperatorListItems();
		
		for (int i = 0; i <	operatorListItems.length; i++) 
			if(operatorListItems[i].isChecked())
				new OperatorDaoImpl().update(operatorListItems[i].getOperator());		
		
		return read(mapping, form, request, response);

	}
	
	public ActionForward delete(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
		
		OperatorListItem[] operatorListItems = ((OperatorFormView) form).getOperatorListItems();		
		
		for (int i = 0; i <	operatorListItems.length; i++) 
			if(operatorListItems[i].isChecked())
				new OperatorDaoImpl().delete(operatorListItems[i].getOperator());	
		return read(mapping, form, request, response);
	}
	
	public ActionForward home(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {	
		return mapping.findForward("home");
	}

}
