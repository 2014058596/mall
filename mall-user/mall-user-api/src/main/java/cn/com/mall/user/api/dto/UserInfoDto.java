package cn.com.mall.user.api.dto;

import cn.com.mall.user.api.model.RoleInfoModel;
import cn.com.mall.user.api.model.UserInfoModel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName: UserInfoDto
 * @Description: TODO
 * @author: 55555
 * @date: 2020年07月25日 4:25 下午
 */
@Data
@ToString
public class UserInfoDto extends UserInfoModel {

    private List<RoleInfoModel> roleList;


}
