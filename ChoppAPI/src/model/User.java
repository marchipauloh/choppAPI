package model;

import java.time.LocalDate;

public class User {
	
	private Integer id;
	private Integer idCustomers;
	private LocalDate dtAccess;
	private Integer codeIMEI;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCustomers() {
		return idCustomers;
	}
	public void setIdCustomers(Integer idCustomers) {
		this.idCustomers = idCustomers;
	}
	public LocalDate getDtAccess() {
		return dtAccess;
	}
	public void setDtAccess(LocalDate dtAccess) {
		this.dtAccess = dtAccess;
	}
	public Integer getCodeIMEI() {
		return codeIMEI;
	}
	public void setCodeIMEI(Integer codeIMEI) {
		this.codeIMEI = codeIMEI;
	}
	
	
	
	

	
}
