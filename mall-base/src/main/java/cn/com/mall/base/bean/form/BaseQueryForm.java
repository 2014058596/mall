package cn.com.mall.base.bean.form;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@ApiModel
@Slf4j
@Data
public class BaseQueryForm<P> extends BaseForm {
    /**
     * 分页查询的参数，当前页数
     */
    @ApiModelProperty("页码")
    private int current = 1;
    /**
     * 分页查询的参数，当前页面每页显示的数量
     */
    @ApiModelProperty("大小")
    private int size = 10;

    /**
     * Form转化为Param
     *
     * @param clazz
     * @return
     */
    public P toParam(Class<P> clazz) {
        P p = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, p);
        return p;
    }

    /**
     * 从form中获取page参数，用于分页查询参数
     *
     * @return
     */
    public Page<P> getPage() {
        return new Page(this.getCurrent(), this.getSize());
    }

}
