package cn.com.mall.user.api.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName: UserForm
 * @Description: TODO
 * @author: 55555
 * @date: 2020年08月11日 11:54 下午
 */
@Data
public class UserForm {

    @NotEmpty(message = "userId不能为Empty")
    @ApiModelProperty("用户id")
    private Integer userId;

}
