package model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatorFormBean extends ActionForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private BigDecimal localMinute;
	private BigDecimal internationalMinute;
	private boolean status;
	
	public boolean getStatus() {
		return this.status;
	}	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		this.id = 0L;
		this.name = "";
		this.localMinute = new BigDecimal(0);
		this.internationalMinute = new BigDecimal(0);;
		this.status = false;
		
	}

}
