package cn.com.mall.user.controller;
import cn.com.mall.base.bean.PaginationResult;
import cn.com.mall.base.bean.StandardResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.plugins.Page;

import cn.com.mall.user.service.IUserInfoService;
import cn.com.mall.user.api.model.UserInfoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 *　　
 *   UserInfo 控制器    
 *
 *   @author 55555
 *   @since 2020-07-25
 */

@RestController
@Api(tags="UserInfoController 控制器")
public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    public IUserInfoService userInfoService;

    /**
     * 获取分页列表
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="获取分页列表  55555", notes="获取分页列表  55555", response = UserInfoModel.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = true, dataType = "int", defaultValue = "10"),
        @ApiImplicitParam(paramType="query", name = "pageNumber", value = "页数", required = true, dataType = "int", defaultValue = "1")
    })
    @GetMapping("/userInfo")
    public StandardResult selectPage(@ModelAttribute UserInfoModel userInfoModel, Integer pageSize, Integer pageNumber) {
        if (pageSize == null || pageNumber == null) {
            return StandardResult.fail("缺少必要的分页参数！");
        }
        Page<UserInfoModel> page = new Page<UserInfoModel>(pageNumber, pageSize);
        Wrapper<UserInfoModel> wrapper = new EntityWrapper<>(userInfoModel);
        userInfoService.selectPage(page, wrapper);
        return PaginationResult.ok(null, page.getRecords(), page.getTotal(), page.getPages());
    }

	/**
     * 获取列表
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="获取列表  55555", notes="获取列表  55555", response = UserInfoModel.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    })
    @GetMapping("/userInfoList")
    public StandardResult selectList(@ModelAttribute UserInfoModel userInfoModel) {
        Wrapper<UserInfoModel> wrapper = new EntityWrapper<>(userInfoModel);
        return StandardResult.ok(null, userInfoService.selectList(wrapper));
    }

     /**
     * 添加
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value = "添加  55555", notes = "添加UserInfo 55555", response = UserInfoModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PostMapping("/userInfo")
    public StandardResult insert(@ModelAttribute UserInfoModel userInfoModel) {
        userInfoService.insert(userInfoModel);
        return StandardResult.ok();
    }

    /**
     * 修改
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="修改  55555", notes="更新UserInfo 55555", response = UserInfoModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PutMapping("/userInfo")
    public StandardResult updateById(@RequestBody UserInfoModel userInfoModel) {
        userInfoService.updateById(userInfoModel);
        return StandardResult.ok();
    }

    /**
     * 通过id获取详情
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="通过id获取详情  55555", notes="通过id获取详情  55555", response = UserInfoModel.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
    	@ApiImplicitParam(paramType="path", name = "id", value = "主键id", dataType = "String", required = true)
    })
    @GetMapping("/userInfo/{id}")
    public StandardResult selectById(@PathVariable String id) {
        return StandardResult.ok(userInfoService.selectById(id));
    }

    /**
     * 通过id删除数据
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="通过id删除数据  55555", notes="通过id删除数据  55555", response = UserInfoModel.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
     	@ApiImplicitParam(paramType="path", name = "id", value = "主键id", dataType = "String", required = true)
    })
    @DeleteMapping("/userInfo/{id}")
    public StandardResult deleteById(@PathVariable String id) {
        userInfoService.deleteById(id);
        return StandardResult.ok();
    }
}
