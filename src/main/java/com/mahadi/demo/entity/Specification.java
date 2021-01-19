package com.mahadi.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;

import com.mahadi.demo.util.Component;



@Entity
@Table(name = "specification")
public class Specification extends Component{
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	
//    @Column(name = "budget")
//    @Enumerated(EnumType.STRING)
//    private Budget budget;
//    
//    @Column(name = "monitor_Requrement")
//    @Enumerated(EnumType.STRING)
//    private MonitorRequrement monitorRequrement;
//    
//    @Column(name = "purpose")
//    @Enumerated(EnumType.STRING)
//    private Purpose purpose;

	
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_id")
    private Budget budget;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monitorRequrement_id")
    private MonitorRequrement monitorRequrement;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purpose_id")
    private Purpose purpose;
    
    @Column(name = "credit", nullable = true)
	private String credit;
    
    @Column(name = "remarks", nullable = true)
	private String remarks;
    
    @Column(name = "is_active", nullable = true)
    private Boolean isActive = false;
    
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public MonitorRequrement getMonitorRequrement() {
		return monitorRequrement;
	}

	public void setMonitorRequrement(MonitorRequrement monitorRequrement) {
		this.monitorRequrement = monitorRequrement;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
    
    
	

}
