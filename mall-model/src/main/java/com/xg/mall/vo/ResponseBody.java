package com.xg.mall.vo;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 19:33 2017/11/15
 * @Modified By:
 */
public class ResponseBody {

    /**
     * 业务码
     */
    private String code;

    /**
     * 业务消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object obj;

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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
