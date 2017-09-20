package com.minilia.qianyi.delivery.endpoint;

import com.minilia.qianyi.delivery.requestBody.ExpressRequestBody;
import com.minilia.qianyi.delivery.responseBody.ExpressResponseBody;
import com.minilia.qianyi.delivery.service.KdniaoSubscribeManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
/**
 * 请求订阅接口
 */
@RestController
@RequestMapping("api/v1/express")
@Api(tags = "提交订阅接口",description = "快递公司编码ShipperCode和快递单号LogisticCode")
public class SubmitExpressTraceEndpoint {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KdniaoSubscribeManager kdniaoSubscribeManager;

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    @ApiOperation(value = "请求订阅", notes = "请求订阅发送快递公司编码和快递单号到快递鸟，等待回调", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExpressResponseBody pushTest(@RequestBody ExpressRequestBody requestBody) {
        logger.info(String.valueOf(requestBody));
        return  kdniaoSubscribeManager.subscribeExpressInfo(requestBody);
    }
}
