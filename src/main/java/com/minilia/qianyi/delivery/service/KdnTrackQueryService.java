package com.minilia.qianyi.delivery.service;


import com.minilia.qianyi.delivery.requestBody.TrackQueryRequestBody;
import com.minilia.qianyi.delivery.responseBody.TrackQueryResponseBody;

/**
 * Created by qianyi on 2017/9/6.
 * @author qianyi
 */
public interface KdnTrackQueryService {

    /**
     *  快递鸟,快递订单实时查询
     * @param trackQueryRequestBody 实时查询请求体,包括快递公司编码和快递单号
     * @return
     */
    public TrackQueryResponseBody trackQuery(TrackQueryRequestBody trackQueryRequestBody);
}
