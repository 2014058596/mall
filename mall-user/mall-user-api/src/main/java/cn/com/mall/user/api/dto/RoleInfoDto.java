package cn.com.mall.user.api.dto;

import cn.com.mall.user.api.model.RoleInfoModel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.security.Permission;
import java.util.List;

/**
 * @ClassName: RoleInfoDto
 * @Description: TODO
 * @author: 55555
 * @date: 2020年07月25日 4:28 下午
 */
@Data
@ToString
@Builder
public class RoleInfoDto extends RoleInfoModel {

    private List<Permission> permissions;
}
