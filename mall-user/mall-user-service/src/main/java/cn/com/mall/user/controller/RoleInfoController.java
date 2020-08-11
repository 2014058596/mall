package cn.com.mall.user.controller;
import cn.com.mall.base.bean.result.PaginationResult;
import cn.com.mall.base.bean.result.StandardResult;
import cn.com.mall.user.api.model.RoleInfoModel;
import cn.com.mall.user.service.IRoleInfoService;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 *　　
 *   RoleInfo 控制器    
 *
 *   @author 55555
 *   @since 2020-07-25
 */

@RestController
@Api(tags="RoleInfoController 控制器")
public class RoleInfoController  {
    private final Logger logger = LoggerFactory.getLogger(RoleInfoController.class);

    @Autowired
    public IRoleInfoService roleInfoService;

    /**
     * 获取分页列表
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="获取分页列表  55555", notes="获取分页列表  55555", response = RoleInfoModel.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = true, dataType = "int", defaultValue = "10"),
        @ApiImplicitParam(paramType="query", name = "pageNumber", value = "页数", required = true, dataType = "int", defaultValue = "1")
    })
    @GetMapping("/roleInfo")
    public StandardResult selectPage(@ModelAttribute RoleInfoModel roleInfoModel, Integer pageSize, Integer pageNumber) {
        if (pageSize == null || pageNumber == null) {
            return StandardResult.fail("缺少必要的分页参数！");
        }
        Page<RoleInfoModel> page = new Page<RoleInfoModel>(pageNumber, pageSize);
        Wrapper<RoleInfoModel> wrapper = new EntityWrapper<>(roleInfoModel);
        roleInfoService.selectPage(page, wrapper);
        return PaginationResult.ok(null, page.getRecords(), page.getTotal(), page.getPages());
    }

	/**
     * 获取列表
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="获取列表  55555", notes="获取列表  55555", response = RoleInfoModel.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    })
    @GetMapping("/roleInfoList")
    public StandardResult selectList(@ModelAttribute RoleInfoModel roleInfoModel) {
        Wrapper<RoleInfoModel> wrapper = new EntityWrapper<>(roleInfoModel);
        return StandardResult.ok(null, roleInfoService.selectList(wrapper));
    }

     /**
     * 添加
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value = "添加  55555", notes = "添加RoleInfo 55555", response = RoleInfoModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PostMapping("/roleInfo")
    public StandardResult insert(@ModelAttribute RoleInfoModel roleInfoModel) {
        roleInfoService.insert(roleInfoModel);
        return StandardResult.ok();
    }

    /**
     * 修改
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="修改  55555", notes="更新RoleInfo 55555", response = RoleInfoModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PutMapping("/roleInfo")
    public StandardResult updateById(@RequestBody RoleInfoModel roleInfoModel) {
        roleInfoService.updateById(roleInfoModel);
        return StandardResult.ok();
    }

    /**
     * 通过id获取详情
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="通过id获取详情  55555", notes="通过id获取详情  55555", response = RoleInfoModel.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
    	@ApiImplicitParam(paramType="path", name = "id", value = "主键id", dataType = "String", required = true)
    })
    @GetMapping("/roleInfo/{id}")
    public StandardResult selectById(@PathVariable String id) {
        return StandardResult.ok(roleInfoService.selectById(id));
    }

    /**
     * 通过id删除数据
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="通过id删除数据  55555", notes="通过id删除数据  55555", response = RoleInfoModel.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
     	@ApiImplicitParam(paramType="path", name = "id", value = "主键id", dataType = "String", required = true)
    })
    @DeleteMapping("/roleInfo/{id}")
    public StandardResult deleteById(@PathVariable String id) {
        roleInfoService.deleteById(id);
        return StandardResult.ok();
    }
}
