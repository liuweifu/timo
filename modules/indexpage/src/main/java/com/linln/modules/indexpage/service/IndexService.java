package com.linln.modules.indexpage.service;

import com.linln.common.enums.StatusEnum;
import com.linln.modules.indexpage.domain.Index;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 小懒虫
 * @date 2020/08/19
 */
public interface IndexService {

    /**
     * 获取分页列表数据
     * @param example 查询实例
     * @return 返回分页数据
     */
    Page<Index> getPageList(Example<Index> example);

    /**
     * 根据ID查询数据
     * @param id 主键ID
     */
    Index getById(Long id);

    /**
     * 保存数据
     * @param index 实体对象
     */
    Index save(Index index);

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     */
    @Transactional
    Boolean updateStatus(StatusEnum statusEnum, List<Long> idList);
}