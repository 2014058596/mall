package cn.com.mall.user.security;



import cn.com.mall.common.conf.security.MyUserDetail;
import cn.com.mall.user.api.dto.UserInfoDto;
import cn.com.mall.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: MyUserDetailService
 * @Description: TODO
 * @author: 55555
 * @date: 2020年07月25日 2:22 下午
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final UserInfoDto userInfoByUserName = userInfoService.findUserInfoByUserName(userName);
        return new MyUserDetail(userInfoByUserName);
    }

}

