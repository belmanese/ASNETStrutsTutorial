package model;

import java.io.Serializable;

public class FunctionaryListItem implements Serializable {	

	private static final long serialVersionUID = 1L;
	private FunctionaryFormBean functionary;
	private boolean checked = false;

	public FunctionaryListItem() { }
	public FunctionaryListItem(FunctionaryFormBean functionary, boolean checked) {
		this.functionary = functionary;
		this.checked = checked;
	}
	
	public FunctionaryFormBean getFunctionary() {
		return functionary;
	}
	public void setFunctionary(FunctionaryFormBean functionary) {
		this.functionary = functionary;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checked ? 1231 : 1237);
		result = prime * result
				+ ((functionary == null) ? 0 : functionary.hashCode());
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
		FunctionaryListItem other = (FunctionaryListItem) obj;
		if (checked != other.checked)
			return false;
		if (functionary == null) {
			if (other.functionary != null)
				return false;
		} else if (!functionary.equals(other.functionary))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "FunctionaryListItem [functionary=" + functionary + ", checked="
				+ checked + "]";
	}
	
}
