package com.minilia.qianyi.delivery.responseBody;

import com.minilia.qianyi.delivery.callback.Trace;

import java.util.List;

/**
 * 请求实时查询-快递鸟返回body
 *
 */
public class TrackQueryResponseBody {
    /**
     *EBusinessID	String	用户ID	R
     */
    private String EBusinessID;
    /**
     * OrderCode	String	订单编号	O
     */
    private String OrderCode;
    /**
     * ShipperCode	String	快递公司编码	R
     */
    private String ShipperCode;
    /**
     *
     *LogisticCode	String	物流运单号	O
     */
    private String LogistiCode;
    /**
     * Success	Bool	成功与否：true，false	R
     */
    private boolean Success;
    /**
     * Reason	String	失败原因	O
     */
    private String Reason;
    /**
     * State	String	物流状态：2-在途中,3-签收,4-问题件	R
     */
    private  String State;

    /**
     * 物流轨迹
     */
    private List<Trace> Traces;

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getLogistiCode() {
        return LogistiCode;
    }

    public void setLogistiCode(String logistiCode) {
        LogistiCode = logistiCode;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public List<Trace> getTraces() {
        return Traces;
    }

    public void setTraces(List<Trace> traces) {
        Traces = traces;
    }
}
