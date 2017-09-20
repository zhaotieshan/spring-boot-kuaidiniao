package com.minilia.qianyi.delivery.callback;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 物流信息
 *
 * @author qianyi
 *
 */
public class TraceInfo {
	/**
	 * EBusinessID	String	商户ID	O
	 */
	@JsonProperty(value = "EBusinessID")
	private String eBusinessID;
	/**
	 * OrderCode	String	订单编号	O
	 */
	@JsonProperty(value = "OrderCode")
	private String orderCode;
	/**
	 * ShipperCode	String	快递公司编码	R
	 */
	@JsonProperty(value = "ShipperCode")
	private String shipperCode;
	/**
	 * LogisticCode	String	快递单号	R
	 */
	@JsonProperty(value = "LogisticCode")
	private String logisticCode;
	/**
	 * Success	Bool	成功与否：true,false	R
	 */
	@JsonProperty(value = "Success")
	private String success;
	/**
	 * Reason	String	失败原因	O
	 */
	@JsonProperty(value = "Reason")
	private String Reason;
	/**
	 * State	String	物流状态: 0-无轨迹，1-已揽收，2-在途中 201-到达派件城市，3-签收,4-问题件	R
	 */
	@JsonProperty(value = "State")
	private String state;
	/**
	 * CallBack	String	订阅接口的Bk值	O
	 */
	@JsonProperty(value = "CallBack")
	private String callBack;



	@JsonProperty(value = "Traces")
	private List<Trace> traces;

	public List<Trace> getTraces() {
		return traces;
	}

	public void setTraces(List<Trace> traces) {
		this.traces = traces;
	}

	public String geteBusinessID() {
		return eBusinessID;
	}

	public void seteBusinessID(String eBusinessID) {
		this.eBusinessID = eBusinessID;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getShipperCode() {
		return shipperCode;
	}

	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}

	public String getLogisticCode() {
		return logisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCallBack() {
		return callBack;
	}

	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}
}
