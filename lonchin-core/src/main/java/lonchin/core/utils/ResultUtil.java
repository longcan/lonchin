package lonchin.core.utils;


import lonchin.core.constants.ErrCode;
import lonchin.core.entity.Result;

/**
 * 结果集工具类
 *
 * @author chenlc
 * @version 1.0
 * @date 2021/8/4
 */
public class ResultUtil<T> {

    private Result<T> result;

    public ResultUtil(){
        result=new Result<>();
        result.setSuccess(true);
        result.setErrMsg("success");
        result.setCode(ErrCode.SUCCESS);
    }

    public Result<T> setData(T t){
        this.result.setResult(t);
        this.result.setCode(ErrCode.SUCCESS);
        return this.result;
    }

    public Result<T> setData(T t, String msg){
        this.result.setResult(t);
        this.result.setCode(ErrCode.SUCCESS);
        this.result.setErrMsg(msg);
        return this.result;
    }

    public Result<T> setErrorMsg(String msg){
        this.result.setSuccess(false);
        this.result.setErrMsg(msg);
        this.result.setCode(ErrCode.SYS_ERR);
        return this.result;
    }

    public Result<T> setErrorMsg(Integer code, String msg){
        this.result.setSuccess(false);
        this.result.setErrMsg(msg);
        this.result.setCode(code);
        return this.result;
    }
   
}
