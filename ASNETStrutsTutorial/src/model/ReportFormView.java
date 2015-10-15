package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ReportFormView extends ActionForm {

	private static final long serialVersionUID = 1L;
	private List<ReportFormListItem> reportListItems = new ArrayList<ReportFormListItem>();

	public ReportFormView() { }
	public ReportFormView(List<ReportFormListItem> reportListItems) {
		this.reportListItems = reportListItems;
	}

	public List<ReportFormListItem> getReportListItems() {
		return reportListItems;
	}
	public void setReportListItems(List<ReportFormListItem> reportListItems) {
		this.reportListItems = reportListItems;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.reportListItems = new ArrayList<ReportFormListItem>();	
	}
	
	@Override
	public String toString() {
		return "ReportFormView [reportListItems=" + reportListItems + "]";
	}
	
	/*
	private  ReportFormListItem reportListItems [] = new ReportFormListItem[0];
	
	public ReportFormView() { }
	public ReportFormView(ReportFormListItem[] reportListItems) {
		this.reportListItems = reportListItems;
	}
	
	public ReportFormListItem[] getReportListItems() {
		return reportListItems;
	}
	public void setReportListItems(ReportFormListItem[] reportListItems) {
		this.reportListItems = reportListItems;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	@Override
	public String toString() {
		return "ReportFormView [reportListItems="
				+ Arrays.toString(reportListItems) + "]";
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		this.reportListItems = new ReportFormListItem[0];
		
	}
	*/
}
