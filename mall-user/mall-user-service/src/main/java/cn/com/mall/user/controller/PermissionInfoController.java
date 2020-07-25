package cn.com.mall.user.controller;
import cn.com.mall.base.bean.PaginationResult;
import cn.com.mall.base.bean.StandardResult;
import cn.com.mall.user.api.model.PermissionInfoModel;
import cn.com.mall.user.service.IPermissionInfoService;
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
 *   PermissionInfo 控制器    
 *
 *   @author 55555
 *   @since 2020-07-25
 */

@RestController
@Api(tags="PermissionInfoController 控制器")
public class PermissionInfoController  {
    private final Logger logger = LoggerFactory.getLogger(PermissionInfoController.class);

    @Autowired
    public IPermissionInfoService permissionInfoService;

    /**
     * 获取分页列表
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="获取分页列表  55555", notes="获取分页列表  55555", response = PermissionInfoModel.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = true, dataType = "int", defaultValue = "10"),
        @ApiImplicitParam(paramType="query", name = "pageNumber", value = "页数", required = true, dataType = "int", defaultValue = "1")
    })
    @GetMapping("/permissionInfo")
    public StandardResult selectPage(@ModelAttribute PermissionInfoModel permissionInfoModel, Integer pageSize, Integer pageNumber) {
        if (pageSize == null || pageNumber == null) {
            return StandardResult.fail("缺少必要的分页参数！");
        }
        Page<PermissionInfoModel> page = new Page<PermissionInfoModel>(pageNumber, pageSize);
        Wrapper<PermissionInfoModel> wrapper = new EntityWrapper<>(permissionInfoModel);
        permissionInfoService.selectPage(page, wrapper);
        return PaginationResult.ok(null, page.getRecords(), page.getTotal(), page.getPages());
    }

	/**
     * 获取列表
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="获取列表  55555", notes="获取列表  55555", response = PermissionInfoModel.class)
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    })
    @GetMapping("/permissionInfoList")
    public StandardResult selectList(@ModelAttribute PermissionInfoModel permissionInfoModel) {
        Wrapper<PermissionInfoModel> wrapper = new EntityWrapper<>(permissionInfoModel);
        return StandardResult.ok(null, permissionInfoService.selectList(wrapper));
    }

     /**
     * 添加
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value = "添加  55555", notes = "添加PermissionInfo 55555", response = PermissionInfoModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PostMapping("/permissionInfo")
    public StandardResult insert(@ModelAttribute PermissionInfoModel permissionInfoModel) {
        permissionInfoService.insert(permissionInfoModel);
        return StandardResult.ok();
    }

    /**
     * 修改
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="修改  55555", notes="更新PermissionInfo 55555", response = PermissionInfoModel.class)
    @ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PutMapping("/permissionInfo")
    public StandardResult updateById(@RequestBody PermissionInfoModel permissionInfoModel) {
        permissionInfoService.updateById(permissionInfoModel);
        return StandardResult.ok();
    }

    /**
     * 通过id获取详情
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="通过id获取详情  55555", notes="通过id获取详情  55555", response = PermissionInfoModel.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
    	@ApiImplicitParam(paramType="path", name = "id", value = "主键id", dataType = "String", required = true)
    })
    @GetMapping("/permissionInfo/{id}")
    public StandardResult selectById(@PathVariable String id) {
        return StandardResult.ok(permissionInfoService.selectById(id));
    }

    /**
     * 通过id删除数据
     *
     * @author : 55555
     * @since : Create in 2020-07-25
     */
    @ApiOperation(value="通过id删除数据  55555", notes="通过id删除数据  55555", response = PermissionInfoModel.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "accessToken", value = "令牌", required = true, dataType = "String"),
     	@ApiImplicitParam(paramType="path", name = "id", value = "主键id", dataType = "String", required = true)
    })
    @DeleteMapping("/permissionInfo/{id}")
    public StandardResult deleteById(@PathVariable String id) {
        permissionInfoService.deleteById(id);
        return StandardResult.ok();
    }
}
