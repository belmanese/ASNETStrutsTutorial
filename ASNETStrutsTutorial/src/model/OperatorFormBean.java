package model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class OperatorFormBean extends ActionForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private BigDecimal localMinute;
	private BigDecimal internationalMinute;
	private boolean status;
			
	public OperatorFormBean() { }

	public OperatorFormBean(Long id, String name, BigDecimal localMinute, BigDecimal internationalMinute, Boolean status) {
		this.id = id;
		this.name = name;
		this.localMinute = localMinute;
		this.internationalMinute = internationalMinute;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}	
	public BigDecimal getLocalMinute() {
		return localMinute;
	}
	public void setLocalMinute(BigDecimal localMinute) {
		this.localMinute = localMinute;
	}

	public BigDecimal getInternationalMinute() {
		return internationalMinute;
	}

	public void setInternationalMinute(BigDecimal internationalMinute) {
		this.internationalMinute = internationalMinute;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((internationalMinute == null) ? 0 : internationalMinute
						.hashCode());
		result = prime * result
				+ ((localMinute == null) ? 0 : localMinute.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperatorFormBean other = (OperatorFormBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (internationalMinute == null) {
			if (other.internationalMinute != null)
				return false;
		} else if (!internationalMinute.equals(other.internationalMinute))
			return false;
		if (localMinute == null) {
			if (other.localMinute != null)
				return false;
		} else if (!localMinute.equals(other.localMinute))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OperatorFormBean [id=" + id + ", name=" + name
				+ ", localMinute=" + localMinute + ", internationalMinute="
				+ internationalMinute + ", status=" + status + "]";
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		this.id = 0L;
		this.name = "";
		this.localMinute = new BigDecimal(0);
		this.internationalMinute = new BigDecimal(0);;
		this.status = false;
		
	}

}
