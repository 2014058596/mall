package cn.com.mall.user.controller;
import cn.com.mall.base.bean.result.PaginationResult;
import cn.com.mall.base.bean.result.StandardResult;
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
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;


import cn.com.mall.user.service.IPermissionInfoService;
import cn.com.mall.user.api.model.PermissionInfoModel;
import cn.com.mall.user.api.form.PermissionInfoQueryForm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 *　　
 *   PermissionInfo 控制器    
 *
 *   @author 55555
 *   @since 2020-08-12
 */

@RestController
@Api(tags="PermissionInfoController 控制器")
public class PermissionInfoController {
    private final Logger logger = LoggerFactory.getLogger(PermissionInfoController.class);

    @Autowired
    public IPermissionInfoService permissionInfoService;

    /**
     * 获取分页列表
     *
     * @author : 55555
     * @since : Create in 2020-08-12
     */
    @ApiOperation(value="获取分页列表  55555", notes="获取分页列表  55555", response = PermissionInfoModel.class)
    @ApiImplicitParam(paramType = "header", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @GetMapping("/permissionInfo")
    public StandardResult selectPage(@ModelAttribute PermissionInfoQueryForm permissionInfoQueryForm) {

        final Page<PermissionInfoModel> page = permissionInfoQueryForm.getPage();
        Wrapper<PermissionInfoModel> wrapper = new EntityWrapper<>();
        permissionInfoService.selectPage(page, wrapper);
        return PaginationResult.ok(null, page.getRecords(), page.getTotal(), page.getPages());
    }

	/**
     * 获取列表
     *
     * @author : 55555
     * @since : Create in 2020-08-12
     */
    @ApiOperation(value="获取列表  55555", notes="获取列表  55555", response = PermissionInfoModel.class)
    @ApiImplicitParam(paramType = "header", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @GetMapping("/permissionInfoList")
    public StandardResult selectList(@ModelAttribute PermissionInfoModel permissionInfoModel) {
        Wrapper<PermissionInfoModel> wrapper = new EntityWrapper<>(permissionInfoModel);
        return StandardResult.ok(null, permissionInfoService.selectList(wrapper));
    }

     /**
     * 添加
     * @author : 55555
     * @since : Create in 2020-08-12
     */
    @ApiOperation(value = "添加  55555", notes = "添加PermissionInfo 55555", response = PermissionInfoModel.class)
    @PostMapping("/permissionInfo")
    @ApiImplicitParam(paramType = "header", name = "accessToken", value = "令牌", required = true, dataType = "String")
    public StandardResult insert(@ModelAttribute PermissionInfoModel permissionInfoModel) {
        permissionInfoService.insert(permissionInfoModel);
        return StandardResult.ok();
    }

    /**
     * 修改
     * @author : 55555
     * @since : Create in 2020-08-12
     */
    @ApiOperation(value="修改  55555", notes="更新PermissionInfo 55555", response = PermissionInfoModel.class)
    @ApiImplicitParam(paramType = "header", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @PutMapping("/permissionInfo")
    public StandardResult updateById(@RequestBody PermissionInfoModel permissionInfoModel) {
        permissionInfoService.updateById(permissionInfoModel);
        return StandardResult.ok();
    }

    /**
     * 通过id获取详情
     *
     * @author : 55555
     * @since : Create in 2020-08-12
     */
    @ApiOperation(value="通过id获取详情  55555", notes="通过id获取详情  55555", response = PermissionInfoModel.class)
    @ApiImplicitParam(paramType = "header", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @GetMapping("/permissionInfo/{id}")
    public StandardResult selectById(@PathVariable String id) {
        return StandardResult.ok(permissionInfoService.selectById(id));
    }

    /**
     * 通过id删除数据
     *
     * @author : 55555
     * @since : Create in 2020-08-12
     */
    @ApiOperation(value="通过id删除数据  55555", notes="通过id删除数据  55555", response = PermissionInfoModel.class)
    @ApiImplicitParam(paramType = "header", name = "accessToken", value = "令牌", required = true, dataType = "String")
    @DeleteMapping("/permissionInfo/{id}")
    public StandardResult deleteById(@PathVariable String id) {
        permissionInfoService.deleteById(id);
        return StandardResult.ok();
    }
}
