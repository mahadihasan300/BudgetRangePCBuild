package com.mahadi.demo.util;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Component extends AuditableEntity{
	
	@Column(name = "cpu", nullable = true)
	private String cpu;
	
	@Column(name = "cpu_ooler", nullable = true)
	private String cpuCooler;
	
	
	@Column(name = "mother_board", nullable = true)
	private String motherBoard;
	
	@Column(name = "ram", nullable = true)
	private String ram;
	
	@Column(name = "ssd", nullable = true)
	private String ssd;
	
	@Column(name = "hdd", nullable = true)
	private String hdd;

	@Column(name = "gpu", nullable = true)
	private String gpu;
	
	@Column(name = "psu", nullable = true)
	private String psu;
	
	@Column(name = "casing", nullable = true)
	private String casing;
	
	@Column(name = "monitor", nullable = true)
	private String monitor;
	
	@Column(name = "keyboard", nullable = true)
	private String keyboard;
	
	@Column(name = "mouse", nullable = true)
	private String mouse;
	
	@Column(name = "ups", nullable = true)
	private String ups;

	@Column(name = "aproximateCost", nullable = true)
	private String aproximateCost;
	
	
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCpuCooler() {
		return cpuCooler;
	}

	public void setCpuCooler(String cpuCooler) {
		this.cpuCooler = cpuCooler;
	}

	public String getMotherBoard() {
		return motherBoard;
	}

	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getPsu() {
		return psu;
	}

	public void setPsu(String psu) {
		this.psu = psu;
	}

	public String getCasing() {
		return casing;
	}

	public void setCasing(String casing) {
		this.casing = casing;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public String getUps() {
		return ups;
	}

	public void setUps(String ups) {
		this.ups = ups;
	}

	public String getAproximateCost() {
		return aproximateCost;
	}

	public void setAproximateCost(String aproximateCost) {
		this.aproximateCost = aproximateCost;
	}
	
	
	
	
}
