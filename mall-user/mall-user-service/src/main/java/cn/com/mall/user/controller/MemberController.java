package cn.com.mall.user.controller;



import cn.com.mall.base.bean.StandardResult;
import cn.com.mall.user.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @ClassName: MemberController
* @Description: TODO
* @author: 55555
* @date: 2020年07月25日 2:24 下午
*/
@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MyUserDetailService userDetailService;


   /* @GetMapping("/member")
    public Principal user(Principal member) {
        //获取当前用户信息
        return member;
    }*/

   /* @DeleteMapping(value = "/exit")
    public StandardResult<String> revokeToken(String access_token) {
        //注销当前用户
        if (consumerTokenServices.revokeToken(access_token)) {
            return StandardResult.ok("注销成功");
        } else {
            return StandardResult.fail("注销失败");
        }
    }*/
}

