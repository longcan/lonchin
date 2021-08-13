package lonchin.core.entity;


import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 结果集
 *
 * @author chenlc
 * @version 1.0
 * @date 2021/8/4
 */
@Data
public class Result<T> implements Serializable{
    private static final long serialVersionUID = 3765319185657974031L;

    /**
     * 成功标志
     */
	@ApiModelProperty(value = "请求是否成功")
    private boolean success;

    /**
     * 失败消息
     */
	@ApiModelProperty(value = "请求失败消息")
    private String errMsg;

    /**
     * 返回代码
     */
	@ApiModelProperty(value = "请求返回代码")
    private Integer code;

    /**
     * 时间戳
     */
	@ApiModelProperty(value = "请求时间戳")
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
	@ApiModelProperty(value = "请求结果对象")
    private T result;

}
