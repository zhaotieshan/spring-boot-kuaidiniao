package com.minilia.qianyi.delivery.endpoint;

import com.alibaba.fastjson.JSON;
import com.minilia.qianyi.delivery.callback.CallBackExpressTraceInfo;
import com.minilia.qianyi.delivery.config.KuaidiniaoConfig;
import com.minilia.qianyi.delivery.responseBody.ExpressResponseBody;
import com.minilia.qianyi.delivery.utils.KdniaoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 接收快递鸟的推送请求
 * 接受回调接口
 * http://www.kdniao.com/UserCenter/Dev/SubscribePush.aspx
 * 接受地址：http://qianyi.s1.natapp.cc/api/v1/kdniao/push
 *
 *
 推送接口(商户实现)
 （1）客户需要按快递鸟要求开发接口，保证信息的正常接收。
 （2）快递鸟主动推送时，物流信息接收接口由客户提供。
 （3）接口支持的消息接收方式为HTTP POST，请求方法的编码格式(utf-8)："application/x-www-form-urlencoded;charset=utf-8"。
 （4）运单物流信息全量推送(每次推送的运单物流信息包括运单当前所有的的物流信息)。
 */
@RestController
@RequestMapping("api/v1/kdniao")
@Api(tags = "接受回调", description = "接受快递鸟回调到本接口")
public class CallBackExpressTraceEndpoint {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KuaidiniaoConfig kuaidiniaoConfig;

    /**
     * 接受回调
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "push", method = RequestMethod.POST)
    @ApiOperation(value = "等待回调", notes = "快递鸟调用", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExpressResponseBody push(HttpServletRequest request) throws IOException {
        logger.info("等待回调开始");

        String DataSign = request.getParameter("DataSign");
        String RequestData = request.getParameter("RequestData");
        String RequestType = request.getParameter("RequestType");


        System.out.println("签名:" + DataSign);//Zjc1MDg5YTY4NmI0ZDA3YWZmOWU4ZTYxMWUxMjMyNDA=
        System.out.println("请求数据：" + RequestData);
        System.out.println("请求类型:" + RequestType);
        Boolean result = KdniaoUtil.verifySign(RequestData, kuaidiniaoConfig.getAppKey(), DataSign);
        if (result) {
            //签名通过,业务处理
            //订阅的推送订单数据，可能会有多笔订单，count统计订单数量
            CallBackExpressTraceInfo traceInfo = JSON.parseObject(RequestData, CallBackExpressTraceInfo.class);
            /**
             * 业务处理代码，异步通知下游系统
             */


        }

        //封装返回的结果
        ExpressResponseBody body = new ExpressResponseBody();
        body.seteBusinessID("1301824");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        body.setEstimatedDeliveryTime(String.valueOf(df.format(new Date())));
        body.setSuccess(Boolean.TRUE);
        System.out.println(body);
        return body;
    }
}
