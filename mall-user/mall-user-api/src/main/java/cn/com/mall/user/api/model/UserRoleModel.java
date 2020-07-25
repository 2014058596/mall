package cn.com.mall.user.api.model;

    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.activerecord.Model;
    import com.baomidou.mybatisplus.annotations.TableName;
    import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 实体类  与数据库一一对应,请勿轻易修改
 * </p>
 *
 * @author 55555
 * @version Sat Jul 25 16:35:47 CST 2020
 * @description
 */
@Data
@ApiModel(value = "user_role", description = "")
public class UserRoleModel extends Model<UserRoleModel> {

private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String ROLE_ID = "role_id";


    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 会员id
     */
    @ApiModelProperty(value = "会员id")
    @TableField("user_id")
    private Integer userId;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Integer roleId;



    @Override
    protected Serializable pkVal() {
            return this.id;
    }


}
