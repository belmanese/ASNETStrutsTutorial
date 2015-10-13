package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import service.MysqlConnect;

import model.OperatorFormBean;

public class OperatorDaoImpl implements OperatorDao {

	public void create(OperatorFormBean operator) {
		String sql = "INSERT INTO operator (name, local_minute, international_minute, status) VALUES ('"+operator.getName()+"', '"+operator.getLocalMinute()+"', '"+operator.getInternationalMinute()+"', "+operator.getStatus()+")";
		MysqlConnect.create(sql);
	}

	public OperatorFormBean read(Long id) {
		return null;
	}

	public void update(OperatorFormBean operator) {		
		
		String id = operator.getId().toString();
		String name = operator.getName();
		String localMinute = operator.getLocalMinute().toString();
		String internationalMinute = operator.getInternationalMinute().toString();
		String status = String.valueOf(operator.getStatus());
		
		String sql = "UPDATE operator SET name='" + name + "', local_minute=" + localMinute + ", international_minute=" + internationalMinute + ", status=" + status + " WHERE id=" + id + "";
		MysqlConnect.update(sql);
		
	}
	
	public void delete(OperatorFormBean operator) {	
		
		String id = operator.getId().toString();
		
		String sql = "DELETE FROM operator WHERE id=" + id;
		MysqlConnect.delete(sql);
		
	}

	public Collection<OperatorFormBean> all() {
		
	    List<OperatorFormBean> operators = new ArrayList<OperatorFormBean>();
		String sql = "SELECT * FROM operator";
		Iterator<?> iterator = MysqlConnect.read(sql).getRows().iterator();
		
	    while(iterator.hasNext()) {
	        DynaBean bean = (DynaBean)iterator.next();
	        operators.add(
	            new OperatorFormBean(
		            Long.parseLong(bean.get("id").toString()), 
	                bean.get("name").toString(), 
	                new BigDecimal(bean.get("local_minute").toString()), 
	                new BigDecimal(bean.get("international_minute").toString()), 
	                Boolean.parseBoolean(bean.get("status").toString())
	            )
	        );
	    }
	    
		return operators;
		
	}

}
