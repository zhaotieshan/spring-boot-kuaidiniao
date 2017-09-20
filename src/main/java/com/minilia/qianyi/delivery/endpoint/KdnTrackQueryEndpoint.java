package com.minilia.qianyi.delivery.endpoint;

import com.minilia.qianyi.delivery.requestBody.TrackQueryRequestBody;
import com.minilia.qianyi.delivery.responseBody.TrackQueryResponseBody;
import com.minilia.qianyi.delivery.service.KdnTrackQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by qianyi on 2017/9/6.
 *
 * 实时查询订单
 *
 */
@RestController
@RequestMapping(value = "api/v1/kdn")
@Api(tags = "实时查询",description = "编码ShipperCode和快递单号LogisticCode")
public class KdnTrackQueryEndpoint {
    @Autowired
    private KdnTrackQueryService kdnTrackQueryService;
    /**
     * Json方式 查询订单物流轨迹
     *
     * @throws Exception
     */
    @RequestMapping(value = "/trackQuery",method = RequestMethod.POST)
    @ApiOperation(value = "实时查询", notes = "实时查询许传入快递公司编码和快递单号到快递鸟", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public TrackQueryResponseBody getOrderTracesByJson(@RequestBody @Valid TrackQueryRequestBody requestBody) throws Exception {
        //校验参数
        TrackQueryResponseBody queryResponseBody = kdnTrackQueryService.trackQuery(requestBody);
        //根据公司业务处理返回的信息......
        return queryResponseBody;
    }
}
