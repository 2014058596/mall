package cn.com.mall.user.mapper;

import cn.com.mall.user.api.dto.UserInfoDto;
import cn.com.mall.user.api.model.UserInfoModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 55555
 * @version Sat Jul 25 15:59:32 CST 2020
 */
public interface UserInfoMapper extends BaseMapper<UserInfoModel> {

    /**
     * 获取用户信息
     * @return
     */
    List<UserInfoDto> findUserInfoByCondition(@Param("ew") Wrapper<UserInfoModel> wrapper);



}