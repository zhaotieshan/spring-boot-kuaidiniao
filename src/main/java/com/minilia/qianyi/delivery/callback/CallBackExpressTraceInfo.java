package com.minilia.qianyi.delivery.callback;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author  qianyi
 * 快递鸟推送信息VO
 * 快递鸟推送到千fan科技VO
 */
public class CallBackExpressTraceInfo implements Serializable {

	/**
	 * Count	String	推送物流单号轨迹个数	R
	 */
	@JsonProperty(value = "Count")
	private Integer count;
	/**
	 * EBusinessID	String	用户电商ID	R
	 */
	@JsonProperty(value = "EBusinessID")
	private String eBusinessID;
	/**
	 * PushTime	String	推送时间	R
	 */
	@JsonProperty(value = "PushTime")
	private String pushTime;
	/**
	 * Data	String	推送物流单号轨迹集合	R
	 */
	@JsonProperty(value = "Data")
	private List<TraceInfo> data;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String geteBusinessID() {
		return eBusinessID;
	}

	public void seteBusinessID(String eBusinessID) {
		this.eBusinessID = eBusinessID;
	}

	public String getPushTime() {
		return pushTime;
	}

	public void setPushTime(String pushTime) {
		this.pushTime = pushTime;
	}

	public List<TraceInfo> getData() {
		return data;
	}

	public void setData(List<TraceInfo> data) {
		this.data = data;
	}
}
