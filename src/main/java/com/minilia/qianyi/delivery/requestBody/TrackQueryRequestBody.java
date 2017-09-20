package com.minilia.qianyi.delivery.requestBody;

import javax.validation.constraints.NotNull;

/**
 * Created by qianyi on 2017/9/6.
 * 快递公司单号实时查询请求体
 */

public class TrackQueryRequestBody {

    //String shipperCode, String logistiCode
    /**
     * 快递公司编码
     */
    @NotNull
    private  String shipperCode;

    /**
     * 快递公司单号
     */
    @NotNull
    private  String logistiCode;

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getLogistiCode() {
        return logistiCode;
    }

    public void setLogistiCode(String logistiCode) {
        this.logistiCode = logistiCode;
    }
}
