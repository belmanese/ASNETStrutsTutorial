package model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.struts.action.ActionForm;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentFormBean extends ActionForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private boolean status;
		
	public boolean getStatus() {
		return status;
	}
	
}
