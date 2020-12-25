package com.yitao.notice.constant;

import java.io.Serializable;

public class ServerRetResponse<T> implements Serializable {
    //当前状态（判断状态）：to be or not to be
    private String retCode;
    //描述信息（主要是给用户看滴）
    private String retMsg;
    //总数量
    private Integer count;
    //后台返回给前端的数据
    private T retData;


    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ServerRetResponse() {
    }

    private ServerRetResponse(String retCode) {

        this.retCode = retCode;
    }

    private ServerRetResponse(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    private ServerRetResponse(String retCode, String retMsg, T retData) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retData = retData;
    }
    private ServerRetResponse(String retCode, String retMsg, Integer count, T retData) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.count = count;
        this.retData = retData;
    }
    //只是告诉前台：成功这种状态
    public static<T> ServerRetResponse<T> createSuccess(){
        return new ServerRetResponse<>(ResponseRetCode.SUCCESS.getRetCode());
    }
    //告诉前台：RetCode,retMsg
    public static <T> ServerRetResponse<T> createSuccess(String retMsg) {
        return new ServerRetResponse<>(ResponseRetCode.SUCCESS.getRetCode(), retMsg);
    }

    //告诉前台：RetCode,retMsg,data
    public static <T> ServerRetResponse<T> createSuccess(String retMsg, T data) {
        return new ServerRetResponse<>(ResponseRetCode.SUCCESS.getRetCode(), retMsg, data);
    }//告诉前台：retCode,retMsg,data
    public static <T> ServerRetResponse<T> createSuccess(String retMsg, Integer count, T data) {
        return new ServerRetResponse<>(ResponseRetCode.SUCCESS.getRetCode(), retMsg, count,data);
    }


    //只是告诉前台：失败这种状态
    public static <T> ServerRetResponse<T> createError() {
        return new ServerRetResponse<>(ResponseRetCode.FAIL.getRetCode());
    }

    //告诉前台：RetCode,retMsg
    public static <T> ServerRetResponse<T> createError(String retMsg) {
        return new ServerRetResponse<>(ResponseRetCode.FAIL.getRetCode(), retMsg);
    }

    //告诉前台：RetCode,retMsg,data
    public static <T> ServerRetResponse<T> createError(String retMsg, T data) {
        return new ServerRetResponse<>(ResponseRetCode.FAIL.getRetCode(), retMsg, data);
    }

    public T getRetData() {
        return retData;
    }

    public void setRetData(T retData) {
        this.retData = retData;
    }
}
