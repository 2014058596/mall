package cn.com.mall.user.api.model;

import java.util.Date;
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
 * @version Sat Jul 25 16:35:23 CST 2020
 * @description
 */
@Data
@ApiModel(value = "role_info", description = "")
public class RoleInfoModel extends Model<RoleInfoModel> {

private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String ROLE_NAME = "role_name";

    public static final String VALID = "valid";

    public static final String CREATETIME = "createTime";

    public static final String UPDATETIME = "updateTime";


    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Integer id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    private String roleName;

    /**
     * 是否有效 1是 0否
     */
    @ApiModelProperty(value = "是否有效 1是 0否")
    private Integer valid;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    /**
     * 更新日期
     */
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;



    @Override
    protected Serializable pkVal() {
            return this.id;
    }


}
