package com.utils;

public class ResponseData {

    private int response_code;
    private Object response_data;
    private String remark;

    public ResponseData(int response_code, Object response_data, String remark) {
        this.response_code = response_code;
        this.response_data = response_data;
        this.remark = remark;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public Object getResponse_data() {
        return response_data;
    }

    public void setResponse_data(Object response_data) {
        this.response_data = response_data;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
