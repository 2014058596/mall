package cn.com.mall.user.service.impl;


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
	
}