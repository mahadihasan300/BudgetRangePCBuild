package com.mahadi.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "monitor_requrement")
public class MonitorRequrement {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	
	@Column(name = "monitorRequrementName", nullable = true)
	private String monitorRequrementName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonitorRequrementName() {
		return monitorRequrementName;
	}

	public void setMonitorRequrementName(String monitorRequrementName) {
		this.monitorRequrementName = monitorRequrementName;
	}

	
	
}
