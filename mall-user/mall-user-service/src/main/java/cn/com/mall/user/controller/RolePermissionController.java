package cn.com.mall.user.controller;
import cn.com.mall.base.bean.result.PaginationResult;
import cn.com.mall.base.bean.result.StandardResult;
import cn.com.mall.user.api.model.RolePermissionModel;
import cn.com.mall.user.service.IRolePermissionService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 *　　
 *   RolePermission 控制器    
 *
 *   @author 55555
 *   @since 2020-07-25
 */

@RestController
@Api(tags="RolePermissionController 控制器")
public class RolePermissionController  {
    private final Logger logger = LoggerFactory.getLogger(RolePermissionController.class);

    @Autowired
    public IRolePermissionService rolePermissionService;

    /**
     * 获取分页列表
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="获取分页列表  55555", notes="获取分页列表  55555", response = RolePermissionModel.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = true, dataType = "int", defaultValue = "10"),
        @ApiImplicitParam(paramType="query", name = "pageNumber", value = "页数", required = true, dataType = "int", defaultValue = "1")
    })
    @GetMapping("/rolePermission")
    public StandardResult selectPage(@ModelAttribute RolePermissionModel rolePermissionModel, Integer pageSize, Integer pageNumber) {
        if (pageSize == null || pageNumber == null) {
            return StandardResult.fail("缺少必要的分页参数！");
        }
        Page<RolePermissionModel> page = new Page<RolePermissionModel>(pageNumber, pageSize);
        Wrapper<RolePermissionModel> wrapper = new EntityWrapper<>(rolePermissionModel);
        rolePermissionService.selectPage(page, wrapper);
        return PaginationResult.ok(null, page.getRecords(), page.getTotal(), page.getPages());
    }

	/**
     * 获取列表
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="获取列表  55555", notes="获取列表  55555", response = RolePermissionModel.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    })
    @GetMapping("/rolePermissionList")
    public StandardResult selectList(@ModelAttribute RolePermissionModel rolePermissionModel) {
        Wrapper<RolePermissionModel> wrapper = new EntityWrapper<>(rolePermissionModel);
        return StandardResult.ok(null, rolePermissionService.selectList(wrapper));
    }

     /**
     * 添加
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value = "添加  55555", notes = "添加RolePermission 55555", response = RolePermissionModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PostMapping("/rolePermission")
    public StandardResult insert(@ModelAttribute RolePermissionModel rolePermissionModel) {
        rolePermissionService.insert(rolePermissionModel);
        return StandardResult.ok();
    }

    /**
     * 修改
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="修改  55555", notes="更新RolePermission 55555", response = RolePermissionModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PutMapping("/rolePermission")
    public StandardResult updateById(@RequestBody RolePermissionModel rolePermissionModel) {
        rolePermissionService.updateById(rolePermissionModel);
        return StandardResult.ok();
    }

    /**
     * 通过id获取详情
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="通过id获取详情  55555", notes="通过id获取详情  55555", response = RolePermissionModel.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
    	@ApiImplicitParam(paramType="path", name = "id", value = "主键id", dataType = "String", required = true)
    })
    @GetMapping("/rolePermission/{id}")
    public StandardResult selectById(@PathVariable String id) {
        return StandardResult.ok(rolePermissionService.selectById(id));
    }

    /**
     * 通过id删除数据
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="通过id删除数据  55555", notes="通过id删除数据  55555", response = RolePermissionModel.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
     	@ApiImplicitParam(paramType="path", name = "id", value = "主键id", dataType = "String", required = true)
    })
    @DeleteMapping("/rolePermission/{id}")
    public StandardResult deleteById(@PathVariable String id) {
        rolePermissionService.deleteById(id);
        return StandardResult.ok();
    }
}
