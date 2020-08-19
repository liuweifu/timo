package com.linln.modules.indexpage.service.impl;

import com.linln.common.data.PageSort;
import com.linln.common.enums.StatusEnum;
import com.linln.modules.indexpage.domain.Index;
import com.linln.modules.indexpage.repository.IndexRepository;
import com.linln.modules.indexpage.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 小懒虫
 * @date 2020/08/19
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexRepository indexRepository;

    /**
     * 根据ID查询数据
     * @param id 主键ID
     */
    @Override
    @Transactional
    public Index getById(Long id) {
        return indexRepository.findById(id).orElse(null);
    }

    /**
     * 获取分页列表数据
     * @param example 查询实例
     * @return 返回分页数据
     */
    @Override
    public Page<Index> getPageList(Example<Index> example) {
        // 创建分页对象
        PageRequest page = PageSort.pageRequest();
        return indexRepository.findAll(example, page);
    }

    /**
     * 保存数据
     * @param index 实体对象
     */
    @Override
    public Index save(Index index) {
        return indexRepository.save(index);
    }

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     */
    @Override
    @Transactional
    public Boolean updateStatus(StatusEnum statusEnum, List<Long> idList) {
        return indexRepository.updateStatus(statusEnum.getCode(), idList) > 0;
    }
}