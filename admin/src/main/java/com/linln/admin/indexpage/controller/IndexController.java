package com.linln.admin.indexpage.controller;

import com.linln.admin.indexpage.validator.IndexValid;
import com.linln.common.enums.StatusEnum;
import com.linln.common.utils.EntityBeanUtil;
import com.linln.common.utils.ResultVoUtil;
import com.linln.common.utils.StatusUtil;
import com.linln.common.vo.ResultVo;
import com.linln.modules.indexpage.domain.Index;
import com.linln.modules.indexpage.service.IndexService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 小懒虫
 * @date 2020/08/19
 */
@Controller
@RequestMapping("/indexpage/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
//    @RequiresPermissions("indexpage:index:index")
    public String index(Model model, Index index) {

        // 创建匹配器，进行动态查询匹配
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("title", match -> match.contains());

        // 获取数据列表
        Example<Index> example = Example.of(index, matcher);
        Page<Index> list = indexService.getPageList(example);

        // 封装数据
        model.addAttribute("message","This is your message");
        model.addAttribute("keywords","keywords,干点啥，这是关键词");
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/indexpage/index/index";
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("indexpage:index:add")
    public String toAdd() {
        return "/indexpage/index/add";
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("indexpage:index:edit")
    public String toEdit(@PathVariable("id") Index index, Model model) {
        model.addAttribute("index", index);
        return "/indexpage/index/add";
    }

    /**
     * 保存添加/修改的数据
     * @param valid 验证对象
     */
    @PostMapping("/save")
    @RequiresPermissions({"indexpage:index:add", "indexpage:index:edit"})
    @ResponseBody
    public ResultVo save(@Validated IndexValid valid, Index index) {
        // 复制保留无需修改的数据
        if (index.getId() != null) {
            Index beIndex = indexService.getById(index.getId());
            EntityBeanUtil.copyProperties(beIndex, index);
        }

        // 保存数据
        indexService.save(index);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("indexpage:index:detail")
    public String toDetail(@PathVariable("id") Index index, Model model) {
        model.addAttribute("index",index);
        return "/indexpage/index/detail";
    }

    /**
     * 设置一条或者多条数据的状态
     */
    @RequestMapping("/status/{param}")
    @RequiresPermissions("indexpage:index:status")
    @ResponseBody
    public ResultVo status(
            @PathVariable("param") String param,
            @RequestParam(value = "ids", required = false) List<Long> ids) {
        // 更新状态
        StatusEnum statusEnum = StatusUtil.getStatusEnum(param);
        if (indexService.updateStatus(statusEnum, ids)) {
            return ResultVoUtil.success(statusEnum.getMessage() + "成功");
        } else {
            return ResultVoUtil.error(statusEnum.getMessage() + "失败，请重新操作");
        }
    }
}