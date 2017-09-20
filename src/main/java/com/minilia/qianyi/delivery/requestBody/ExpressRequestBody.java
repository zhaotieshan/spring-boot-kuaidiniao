package com.minilia.qianyi.delivery.requestBody;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 订阅请求参数
 * http://www.kdniao.com/api-follow
 * @author qianyi
 */
public class ExpressRequestBody implements Serializable {


	private static final long serialVersionUID = 1643281099509897132L;
	/**
	 * ShipperCode	String	快递公司编码	R
	 */
	private String ShipperCode;
	/**
	 * LogisticCode	String	快递单号	R
	 */
	private String LogisticCode;
	/**
	 * CallBack	String	用户自定义回调信息	O
	 */
	private String Callback;
	/**
	 * OrderCode	String	订单编号	O
	 */
	private String OrderCode;

	public String getShipperCode() {
		return ShipperCode;
	}

	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}

	public String getLogisticCode() {
		return LogisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}

	public String getCallback() {
		return Callback;
	}

	public void setCallback(String callback) {
		Callback = callback;
	}

	public String getOrderCode() {
		return OrderCode;
	}

	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}

}
