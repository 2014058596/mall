package cn.com.mall.user.service.impl;


import cn.com.mall.user.api.dto.UserInfoDto;
import cn.com.mall.user.api.model.UserInfoModel;
import cn.com.mall.user.mapper.UserInfoMapper;
import cn.com.mall.user.service.IUserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 55555
 * @version Sat Jul 25 15:59:32 CST 2020
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoModel> implements IUserInfoService {

    /**
     * 根据用户名称获取用户
     * 包含角色权限
     *
     * @param userName
     * @return
     */
    @Override
    public UserInfoDto findUserInfoByUserName(String userName) {
        return null;
    }
}
