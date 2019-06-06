package com.example.demo.entity;

public class ResultObject {
    private String message;

    private Object data;

    private Integer state;

    public ResultObject() {
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Integer getState() {
        return state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", state=" + state +
                '}';
    }
}
