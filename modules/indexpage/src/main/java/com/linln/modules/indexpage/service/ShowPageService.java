package com.linln.modules.indexpage.service;

import com.linln.common.enums.StatusEnum;
import com.linln.modules.indexpage.domain.ShowPage;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 路人
 * @date 2020/08/20
 */
public interface ShowPageService {

    /**
     * 获取分页列表数据
     * @param example 查询实例
     * @return 返回分页数据
     */
    Page<ShowPage> getPageList(Example<ShowPage> example);

    /**
     * 根据ID查询数据
     * @param id 主键ID
     */
    ShowPage getById(Long id);

    /**
     * 保存数据
     * @param showPage 实体对象
     */
    ShowPage save(ShowPage showPage);

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     */
    @Transactional
    Boolean updateStatus(StatusEnum statusEnum, List<Long> idList);
}