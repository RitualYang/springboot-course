package com.wty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wty.entity.Class;

/**
 * <p>
 * 班级 Mapper 接口
 * </p>
 *
 * @author wty
 * @since 2020-09-13
 */
public interface ClassMapper extends BaseMapper<Class> {

    IPage<Class> selectPage(Page<?> page, String version);

}
