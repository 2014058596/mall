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
 * @version Sat Jul 25 16:35:04 CST 2020
 * @description
 */
@Data
@ApiModel(value = "permission_info", description = "")
@TableName("permission_info")
public class PermissionInfoModel extends Model<PermissionInfoModel> {

private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String METHOD = "method";

    public static final String ZUUL_PREFIX = "zuul_prefix";

    public static final String SERVICE_PREFIX = "service_prefix";

    public static final String URI = "uri";

    public static final String CREATETIME = "createTime";

    public static final String UPDATETIME = "updateTime";


    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id")
    private Integer id;

    /**
     * 方法类型
     */
    @ApiModelProperty(value = "方法类型")
    private String method;

    /**
     * 网关前缀
     */
    @ApiModelProperty(value = "网关前缀")
    @TableField("zuul_prefix")
    private String zuulPrefix;

    /**
     * 服务前缀
     */
    @ApiModelProperty(value = "服务前缀")
    @TableField("service_prefix")
    private String servicePrefix;

    /**
     * 请求路径
     */
    @ApiModelProperty(value = "请求路径")
    private String uri;

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
