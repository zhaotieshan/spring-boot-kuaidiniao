package com.minilia.qianyi.delivery.service;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.minilia.qianyi.delivery.config.KuaidiniaoConfig;
import com.minilia.qianyi.delivery.requestBody.ExpressRequestBody;
import com.minilia.qianyi.delivery.responseBody.ExpressResponseBody;
import com.minilia.qianyi.delivery.utils.KdniaoUtil;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 快递鸟提交订阅
 * @author qianyi
 * http://www.kdniao.com/api-follow
 *
订阅接口
（1）此功能为专业定制，为特殊商户提供订阅服务，快递鸟系统会定时推送新的物流信息到商户系统。
（2）订阅快递号需指定相应的快递公司编码，格式不对或则编码错误都会返失败的信息。
如：EMS物流单号应选择快递公司编码（EMS）查看快递公司编码
（3）接口支持的消息接收方式为HTTP POST，请求方法的编码格式(utf-8)："application/x-www-form-urlencoded;charset=utf-8"。
（4）接口地址： API测试地址：http://testapi.kdniao.cc:8081/api/dist
API正式地址：http://api.kdniao.cc/api/dist
 */
@Service
public class KdniaoSubscribeManager {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	// 配置参数 后定义到配置文件中
	private static final String dataType = "2";
	private static final String requestType = "1008";
	@Autowired
	private KuaidiniaoConfig kuaidiniaoConfig;
	/**
	 * 订阅物流信息推送
	 * @param request
	 * @return 订阅结果
	 */
	public ExpressResponseBody subscribeExpressInfo(ExpressRequestBody request) {
		checkParam(request);
		String requestData = JSON.toJSONString(request);
		System.out.println("requestData:"+requestData);
		Map<String, String> params = buildParam(requestData);
		if (MapUtils.isNotEmpty(params)) {
			String result = KdniaoUtil.sendPost(kuaidiniaoConfig.getSubscriptionUrl(), params);
			return JSON.parseObject(result, ExpressResponseBody.class);
		}
		return null;
	}

	private Map<String, String> buildParam(String requestData) {
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("RequestData", KdniaoUtil.urlEncoder(requestData, "UTF-8"));
			params.put("EBusinessID", kuaidiniaoConfig.getEBusinessID());
			params.put("RequestType", requestType);
			String dataSign = KdniaoUtil.encrypt(requestData, kuaidiniaoConfig.getAppKey(), "UTF-8");
			params.put("DataSign", KdniaoUtil.urlEncoder(dataSign, "UTF-8"));
			params.put("DataType", dataType);
		} catch (Exception e) {
			logger.info("[build param error]", e);
			return new HashMap<String, String>();
		}
		return params;
	}
	private void checkParam(ExpressRequestBody request) {
		if (request == null) {
			throw new RuntimeException("参数不能为空!");
		}
		if (Strings.isNullOrEmpty(request.getShipperCode())) {
			throw new RuntimeException("物流公司编号不能为空!");
		}
		if (Strings.isNullOrEmpty(request.getLogisticCode())) {
			throw new RuntimeException("运单号不能为空!");
		}
	}
}
