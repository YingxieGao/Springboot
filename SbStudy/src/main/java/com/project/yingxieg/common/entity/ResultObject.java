package com.project.yingxieg.common.entity;

public class ResultObject {

    public enum ResultCodeEnum {
        CODE_200(200, "请求成功！"),
        CODE_204(204, "暂无数据！"),
        CODE_401(401, "请求不支持！"),
        CODE_403(403, "缺少关键参数！"),
        CODE_404(404, "操作资源不存在！"),

        CODE_999(999, "未知错误，暂时无法处理请求！");

        /**
         * 结果编码
         */
        private Integer code;

        /**
         * 结果信息
         */
        private String message;

        ResultCodeEnum(Integer code, String msg) {
            this.code = code;
            this.message = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    private String message;

    private Object data;

    private Integer state;

    public ResultObject(){
        this.state = ResultCodeEnum.CODE_200.getCode();
        this.message = ResultCodeEnum.CODE_200.getMessage();
    }

    public ResultObject asNoData(){
        this.setState(ResultCodeEnum.CODE_204.getCode());
        this.setMessage(ResultCodeEnum.CODE_204.getMessage());
        return this;
    }


    public ResultObject asUnSupportedRequest() {
        this.setState(ResultCodeEnum.CODE_401.getCode());
        this.setMessage(ResultCodeEnum.CODE_401.getMessage());
        return this;
    }

    public ResultObject asParamsLess() {
        this.setState(ResultCodeEnum.CODE_403.getCode());
        this.setMessage(ResultCodeEnum.CODE_403.getMessage());
        return this;
    }

    public ResultObject asNotFoundError() {
        this.setState(ResultCodeEnum.CODE_404.getCode());
        this.setMessage(ResultCodeEnum.CODE_404.getMessage());
        return this;
    }

    public ResultObject asSysError() {
        this.setState(ResultCodeEnum.CODE_999.getCode());
        this.setMessage(ResultCodeEnum.CODE_999.getMessage());
        return this;
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
