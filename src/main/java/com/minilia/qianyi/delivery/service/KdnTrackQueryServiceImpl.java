package com.minilia.qianyi.delivery.service;

import com.alibaba.fastjson.JSON;
import com.minilia.qianyi.delivery.config.KuaidiniaoConfig;
import com.minilia.qianyi.delivery.requestBody.TrackQueryRequestBody;
import com.minilia.qianyi.delivery.responseBody.TrackQueryResponseBody;
import com.minilia.qianyi.delivery.utils.KdniaoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qianyi on 2017/9/6.
 * @author qianyi
 *
 * http://www.kdniao.com/api-track
 *
 *
一、接口描述/说明
（1）查询接口支持按照运单号查询(单个查询)。
（2）接口需要指定快递单号的快递公司编码，格式不对或则编码错误都会返失败的信息。
如：EMS物流单号应选择快递公司编码（EMS）查看快递公司编码
（3）返回的物流跟踪信息按照发生的时间升序排列。
（4）接口指令1002。
（5）接口支持的消息接收方式为HTTP POST，请求方法的编码格式(utf-8)："application/x-www-form-urlencoded;charset=utf-8"。
（6）接口地址： API地址：http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx
 */
@Service
public class KdnTrackQueryServiceImpl implements KdnTrackQueryService {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private KuaidiniaoConfig kuaidiniaoConfig;


    @Override
    public TrackQueryResponseBody trackQuery(TrackQueryRequestBody trackQueryRequestBody) {
        //请求数据
        String requestData = "{'OrderCode':'','ShipperCode':'" + trackQueryRequestBody.getShipperCode() + "','LogisticCode':'" + trackQueryRequestBody.getLogistiCode() + "'}";
        String result = "";
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("RequestData", KdniaoUtil.urlEncoder(requestData, "UTF-8"));
            params.put("EBusinessID", kuaidiniaoConfig.getEBusinessID());
            params.put("RequestType", "1002");
            String dataSign = KdniaoUtil.encrypt(requestData, kuaidiniaoConfig.getAppKey(), "UTF-8");
            params.put("DataSign", KdniaoUtil.urlEncoder(dataSign, "UTF-8"));
            params.put("DataType", "2");
            result = KdniaoUtil.sendPost(kuaidiniaoConfig.getQueryUrl(), params);
        } catch (Exception e) {
            logger.error("接口调用失败");
        }
        TrackQueryResponseBody responseBody= JSON.parseObject(result,TrackQueryResponseBody.class);
        return responseBody;
    }
}

