package cn.lihao.common;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "ResponseResult", description = "返回结果基础类")
public class ResponseResult<T> implements Serializable {

    //默认成功编码
    public static final int SUCCESS_CODE = 0;
    //默认成功消息
    public static final String SUCCESS_MSG = "操作成功";
    //默认失败编码
    public static final int FAILURE_CODE = -1;
    //默认失败消息
    public static final String FAILURE_MSG = "操作失败";

    @ApiModelProperty(value = "处理编码")
    private int code;
    @ApiModelProperty(value = "处理结果")
    private String msg;
    @ApiModelProperty(value = "token")
    private String accessToken;
    @ApiModelProperty(value = "token状态")
    private String tokenStatus;
    @ApiModelProperty(value = "返回结果")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseResult newSuccess(Object data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(SUCCESS_CODE);
        responseResult.setMsg(SUCCESS_MSG);
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult newSuccess(Object data, String msg){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(SUCCESS_CODE);
        responseResult.setMsg(msg);
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult newFailure(Object data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(FAILURE_CODE);
        responseResult.setMsg(FAILURE_MSG);
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult newFailure(Object data, String failMsg){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(FAILURE_CODE);
        responseResult.setMsg(failMsg);
        responseResult.setData(data);
        return responseResult;
    }
}
