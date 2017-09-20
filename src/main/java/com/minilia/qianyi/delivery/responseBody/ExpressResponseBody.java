package com.minilia.qianyi.delivery.responseBody;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 请求订阅之后，订阅结果返回
 * http://www.kdniao.com/api-follow
 * @author qianyi
 */
public class ExpressResponseBody implements Serializable {

	private static final long serialVersionUID = 6959185839809448376L;
	/**
	 * EBusinessID	String	用户ID	R
	 */
	@JsonProperty(value = "EBusinessID")
	private String eBusinessID;
	/**
	 * UpdateTime	String	时间	R
	 */
	@JsonProperty(value = "UpdateTime")
	private String updateTime;
	/**
	 * Success	Bool	成功与否：true，false	R
	 */
	@JsonProperty(value = "Success")
	private boolean success;
	/**
	 * Reason	String	失败原因	O
	 */
	@JsonProperty(value = "Reason")
	private String reason;
	/**
	 * EstimatedDeliveryTime	String	订单预计到货时间yyyy-mm-dd（即将上线）	O
	 */
	@JsonProperty(value = "EstimatedDeliveryTime")
	private String estimatedDeliveryTime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String geteBusinessID() {
		return eBusinessID;
	}

	public void seteBusinessID(String eBusinessID) {
		this.eBusinessID = eBusinessID;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getEstimatedDeliveryTime() {
		return estimatedDeliveryTime;
	}

	public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		this.estimatedDeliveryTime = estimatedDeliveryTime;
	}
}
