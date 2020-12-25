package com.yitao.notice.constant;

public enum ResponseRetCode {
    SUCCESS("0000", "成功！"),

    FAIL("1000", "失败！");


    private String retCode;
    private String retMsg;

    private ResponseRetCode(String retCode, String retMsg){
        this.retCode=retCode;
        this.retMsg=retMsg;
    }

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
}