package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReportFormView;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import service.ReportService;

public class ReportDispatcherController extends DispatchAction {
	
	public ActionForward create(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {		
		
		System.out.println("create");
		return null;
	}

	public ActionForward read(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
				
		((ReportFormView) form).setReportListItems(ReportService.allReports(mapping, form, request, response));
		return mapping.findForward("readReportForward");
		
	}
	
	public ActionForward update(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {		
		
		System.out.println("update");
		return null;

	}
	
	public ActionForward delete(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
		
		System.out.println("delete");
		return null;	

	}
	
	public ActionForward home(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {			
		
		return mapping.findForward("home");
	}

}
