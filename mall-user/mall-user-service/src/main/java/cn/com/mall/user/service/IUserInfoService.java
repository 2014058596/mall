package cn.com.mall.user.service;

import cn.com.mall.user.api.dto.UserInfoDto;
import cn.com.mall.user.api.model.UserInfoModel;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 55555
 * @version Sat Jul 25 15:59:32 CST 2020
 */
public interface IUserInfoService extends IService<UserInfoModel> {

    /**
     * 根据用户名称获取用户
     * 包含角色权限
     * @param userName
     * @return
     */
    UserInfoDto findUserInfoByUserName(String userName);
}
