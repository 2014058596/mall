package cn.com.mall.user.service.impl;


import cn.com.mall.base.bean.exception.CommonException;
import cn.com.mall.user.api.dto.UserInfoDto;
import cn.com.mall.user.api.model.UserInfoModel;
import cn.com.mall.user.mapper.UserInfoMapper;
import cn.com.mall.user.service.IUserInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 根据用户名称获取用户
     * 包含角色权限
     *
     * @param userName
     * @return
     */
    @Override
    public UserInfoDto findUserInfoByUserName(String userName) {
        Wrapper<UserInfoModel> wrapper = new EntityWrapper<>();
        wrapper.eq(UserInfoModel.USER_NAME, userName);
        final List<UserInfoDto> userInfoByCondition = userInfoMapper.findUserInfoByCondition(wrapper);
        if(userInfoByCondition.isEmpty()){
            throw new CommonException("没有找到该用户！");
        }
        return userInfoByCondition.get(0);
    }
}
