package com.minilia.qianyi.delivery.callback;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 物流轨迹
 * @author qianyi
 *
 */
public class Trace {

	/**
	 * acceptStation	String	描述	R
	 */
	@JsonProperty(value = "acceptStation")
	private String acceptStation;
	/**
	 * acceptTime	String	时间	R
	 */
	@JsonProperty(value = "acceptTime")
	private String acceptTime;

	/**
     *remark	String	备注	O
	 */
	@JsonProperty(value = "remark")
	private String remark;

	public String getAcceptStation() {
		return acceptStation;
	}

	public void setAcceptStation(String acceptStation) {
		this.acceptStation = acceptStation;
	}

	public String getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
