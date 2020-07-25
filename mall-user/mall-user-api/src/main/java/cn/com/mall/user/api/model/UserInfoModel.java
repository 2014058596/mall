package cn.com.mall.user.api.model;

    import com.baomidou.mybatisplus.enums.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotations.TableId;
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
 * @version Sat Jul 25 16:33:52 CST 2020
 * @description
 */
@Data
@ApiModel(value = "user_info", description = "")
@TableName("user_info")
public class UserInfoModel extends Model<UserInfoModel> {

private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String USER_NAME = "user_name";

    public static final String PASSWORD = "password";

    public static final String EMAIL = "email";

    public static final String SEX = "sex";

    public static final String MOBILE = "mobile";

    public static final String BIRTHDAY = "birthday";

    public static final String CREATETIME = "createTime";


    /**
     * 会员id
     */
    @ApiModelProperty(value = "会员id")
        @TableId(value="id", type= IdType.AUTO)
    private Integer id;

    /**
     * 会员名
     */
    @ApiModelProperty(value = "会员名")
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱")
    private String email;

    /**
     * 性别 1男0女
     */
    @ApiModelProperty(value = "性别 1男0女")
    private Integer sex;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * 出生日
     */
    @ApiModelProperty(value = "出生日")
    private Date birthday;

    /**
     * 注册日期
     */
    @ApiModelProperty(value = "注册日期")
    private Date createTime;



@Override
protected Serializable pkVal() {
            return this.id;
        }


}
