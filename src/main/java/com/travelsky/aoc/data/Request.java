package com.travelsky.aoc.data;

import java.io.Serializable;

/**
 * 
 *
 */
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public int getActionCode() {
		return actionCode;
	}

	public void setActionCode(int actionCode) {
		this.actionCode = actionCode;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	int actionCode;
	
	String reqMes;
	
	public String getReqMes() {
		return reqMes;
	}

	public void setReqMes(String reqMes) {
		this.reqMes = reqMes;
	}

	String ip;

	String service;

	byte[] data;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
