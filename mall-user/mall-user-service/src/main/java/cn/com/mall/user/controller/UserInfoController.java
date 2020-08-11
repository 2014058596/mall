package cn.com.mall.user.controller;
import cn.com.mall.base.bean.exception.CommonException;
import cn.com.mall.base.bean.result.PaginationResult;
import cn.com.mall.base.bean.result.StandardResult;
import cn.com.mall.user.api.dto.UserInfoDto;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.plugins.Page;

import cn.com.mall.user.service.IUserInfoService;
import cn.com.mall.user.api.model.UserInfoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 *　　
 *   UserInfo 控制器    
 *
 *   @author 55555
 *   @since 2020-07-25
 */

@RestController
@RequestMapping("/")
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
     * 添加
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value = "添加  55555", notes = "添加UserInfo 55555", response = UserInfoModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PostMapping("/userInfoList")
    @Transactional(rollbackFor = Exception.class)
    public StandardResult insert(@RequestBody List<Integer> list) {
        logger.info(Thread.currentThread().getName());
        final int poolSize = ForkJoinPool.commonPool().getPoolSize();
        logger.debug(String.valueOf(poolSize));
        list.stream().parallel().forEach(i-> {
            UserInfoModel userInfoModel = new UserInfoModel();
            userInfoModel.setUserId(i);
            userInfoModel.setUserName("TEST");
            logger.info(Thread.currentThread().getName());
            userInfoService.insert(userInfoModel);
            if(i==5){
                throw new CommonException("test");
            }

        });
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
    public StandardResult selectById(@PathVariable String id) throws Exception {
        final UserInfoDto userInfoByUserName = userInfoService.findUserInfoByUserName(id);
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
