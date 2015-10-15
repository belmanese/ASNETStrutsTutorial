package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReportFormListItem;

import org.apache.commons.beanutils.DynaBean;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ReportService {
	
	public static List<ReportFormListItem> allReports(
			ActionMapping mapping, 
			ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response) {
		String sql = 
				"select f.name as functionary, d.name as department, o.name as operator, c.minute as minutes, c.cost as cost " +
					"from bd_test_1.operator o " +
					"inner join bd_test_1.call c on o.id = c.operator_id " +
					"inner join bd_test_1.liquidation l on c.liquidation_id = l.id " +
					"inner join bd_test_1.funtionary f on l.funtionary_id = f.id " +
					"inner join bd_test_1.department d on f.department_id = d.id";
			
		List<ReportFormListItem> reportsFormList = new ArrayList<ReportFormListItem>();
		
		Iterator<?> iterator = MysqlConnect.read(sql).getRows().iterator();
		while(iterator.hasNext()) {
	        DynaBean bean = (DynaBean)iterator.next();
	        reportsFormList.add(
	        	new ReportFormListItem(
	        		bean.get("functionary").toString(), 
	        		bean.get("department").toString(), 
	        		bean.get("operator").toString(), 
	        		Integer.parseInt(bean.get("minutes").toString()), 
	        		new BigDecimal(bean.get("cost").toString())
	        	)
	        );
		}

			return reportsFormList;
	}
}
