package cn.com.mall.common.conf.security;

import cn.com.mall.user.api.dto.UserInfoDto;
import cn.com.mall.user.api.model.UserInfoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: MyUserDetail
 * @Description: TODO
 * @author: 55555
 * @date: 2020年07月26日 4:18 下午
 */
@Data
@AllArgsConstructor
public class MyUserDetail extends UserInfoModel implements UserDetails {

    private List<String> userRole;

    public MyUserDetail(String userName, List<String> userRole){
        this.userRole = userRole;
        setUserName(userName);
    }
    public MyUserDetail(UserInfoDto userInfoDto){
        this.userRole =userInfoDto.getRoleList().stream().map(roleInfoModel -> roleInfoModel.getRoleName()).collect(Collectors.toList());
        setUserName(userInfoDto.getUserName());
        setBirthday(userInfoDto.getBirthday());
        setCreateTime(userInfoDto.getCreateTime());
        setEmail(userInfoDto.getEmail());
        setPassword(userInfoDto.getPassword());
        setUserId(userInfoDto.getUserId());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole.stream() .map(roleModel -> new SimpleGrantedAuthority(roleModel))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
