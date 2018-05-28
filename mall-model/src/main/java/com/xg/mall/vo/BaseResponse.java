package com.xg.mall.vo;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 19:34 2017/11/15
 * @Modified By:
 */
public class BaseResponse {

    /**
     * 服务码
     */
    private String code;

    /**
     * 服务消息
     */
    private String msg;

    /**
     * 返回体
     */
    private ResponseBody responseBody;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", responseBody=" + responseBody +
                '}';
    }
}
