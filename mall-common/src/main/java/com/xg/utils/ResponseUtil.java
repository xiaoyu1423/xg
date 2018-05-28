package com.xg.utils;

import com.xg.mall.vo.BaseResponse;
import com.xg.mall.vo.ResponseBody;

/**
 * @Author: xuepengbo@iyungu.com
 * @Description:
 * @Date: Created in 15:25 2017/11/23
 * @Modified By:
 */
public class ResponseUtil {

    /**
     * @Author: xuepengbo@iyungu.com
     * @Description:
     * @Params:
     * @param: obj
     * @Return: com.iyungu.mall.vo.BaseResponse
     * @Throws:
     * @Date: Created in 2017/11/23 16:00
     */
    @Deprecated
    public static BaseResponse baseResponse(Object obj) {
        BaseResponse baseResponse = new BaseResponse();
        ResponseBody responseBody = new ResponseBody();
        responseBody.setObj(obj);
        baseResponse.setResponseBody(responseBody);
        return baseResponse;
    }

    /**
     * @Author: xuepengbo@iyungu.com
     * @Description:
     * @Params:
     * @param: obj
     * @param: msg
     * @param: code
     * @Return: com.iyungu.mall.vo.ResponseBody
     * @Throws:
     * @Date: Created in 2017/11/23 16:00
     */
    public static ResponseBody responseBody(Object result, String msg, String code) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setObj(result);
        responseBody.setCode(code);
        responseBody.setMsg(msg);
        return responseBody;
    }

}
