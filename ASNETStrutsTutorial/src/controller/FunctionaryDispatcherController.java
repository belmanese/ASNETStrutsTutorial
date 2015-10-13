package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FunctionaryFormBean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.FunctionaryDaoImpl;

import model.FunctionaryListItem;
import model.FunctionaryFormView;

public class FunctionaryDispatcherController extends DispatchAction {
	
	public ActionForward create(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

		new FunctionaryDaoImpl().create((FunctionaryFormBean) form);
		((FunctionaryFormBean) form).reset(mapping, request);
		
		return update(mapping, new FunctionaryFormView(), request, response);
	}
	
	public ActionForward read(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {		
		
		((FunctionaryFormView) form).setFunctionaryList(new FunctionaryDaoImpl().all());
		return mapping.findForward("readFunctionaryForward");
		
	}
	
	public ActionForward update(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
		
		FunctionaryListItem[] operatorListItems = ((FunctionaryFormView) form).getFunctionaryListItems();
		
		for (int i = 0; i <	operatorListItems.length; i++) 
			if(operatorListItems[i].isChecked())
				new FunctionaryDaoImpl().update(operatorListItems[i].getFunctionary());		
		
		return read(mapping, form, request, response);

	}
	
	public ActionForward delete(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
		
		FunctionaryListItem[] operatorListItems = ((FunctionaryFormView) form).getFunctionaryListItems();		
		
		for (int i = 0; i <	operatorListItems.length; i++) 
			if(operatorListItems[i].isChecked())
				new FunctionaryDaoImpl().delete(operatorListItems[i].getFunctionary());	
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
