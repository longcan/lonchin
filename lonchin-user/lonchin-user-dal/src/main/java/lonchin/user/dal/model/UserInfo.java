package lonchin.user.dal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lonchin.core.emums.GenderEnum;

import java.io.Serializable;

/**
 * @Description: 用户信息表
 * @author: chenlc
 * @date: 2021/4/10
 * @version: V1.0
 */
@Data
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -7046301761689378803L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别:NOT_CONFIRMED,FEMALE,MALE")
    private GenderEnum gender;

    @ApiModelProperty(value = "头像")
    private String avatar;
}
