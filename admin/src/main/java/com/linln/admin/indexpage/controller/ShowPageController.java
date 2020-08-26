package com.linln.admin.indexpage.controller;

import com.linln.admin.indexpage.validator.ShowPageValid;
import com.linln.common.enums.StatusEnum;
import com.linln.common.utils.EntityBeanUtil;
import com.linln.common.utils.ResultVoUtil;
import com.linln.common.utils.StatusUtil;
import com.linln.common.vo.ResultVo;
import com.linln.modules.indexpage.domain.ShowPage;
import com.linln.modules.indexpage.service.ShowPageService;
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
 * @author 路人
 * @date 2020/08/20
 */
@Controller
@RequestMapping("/indexpage/showPage")
public class ShowPageController {

    @Autowired
    private ShowPageService showPageService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("indexpage:showPage:index")
    public String index(Model model) {

        ShowPage beShowPage = showPageService.getById(1L);

        model.addAttribute("showPage", beShowPage);
        return "/indexpage/showPage/add";
    }

    /**
     * 列表页面
     */
    @GetMapping("/showIndex")
    @RequiresPermissions("indexpage:showPage:showIndex")
    public String showIndex(Model model, ShowPage showPage) {

        // 创建匹配器，进行动态查询匹配
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("title", match -> match.contains());

        // 获取数据列表
        Example<ShowPage> example = Example.of(showPage, matcher);
        Page<ShowPage> list = showPageService.getPageList(example);

        if (list.isEmpty()) {
            String errorMsg = "好像出错了呢！";
            model.addAttribute("statusCode", "404");
            model.addAttribute("msg", errorMsg);
            return "/system/main/error";
        }
        ShowPage showPageAttr = list.getContent().get(0);
        model.addAttribute("web_desc", showPageAttr.getWeb_desc());
        model.addAttribute("web_keywords", showPageAttr.getWeb_keywords());
        model.addAttribute("web_name", showPageAttr.getWeb_name());
        model.addAttribute("web_email", showPageAttr.getWeb_email());
        model.addAttribute("web_author", showPageAttr.getWeb_author());
        model.addAttribute("web_logo", showPageAttr.getWeb_logo());
        model.addAttribute("web_title", showPageAttr.getWeb_title());
        return "/indexpage/showPage/showIndex";
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("indexpage:showPage:add")
    public String toAdd() {
        return "/indexpage/showPage/add";
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("indexpage:showPage:edit")
    public String toEdit(@PathVariable("id") ShowPage showPage, Model model) {
        model.addAttribute("showPage", showPage);
        return "/indexpage/showPage/add";
    }

    /**
     * 保存添加/修改的数据
     *
     * @param valid 验证对象
     */
    @PostMapping("/save")
    @RequiresPermissions({"indexpage:showPage:add", "indexpage:showPage:edit"})
    @ResponseBody
    public ResultVo save(@Validated ShowPageValid valid, ShowPage showPage) {
        // 复制保留无需修改的数据
        if (showPage.getId() != null) {
            ShowPage beShowPage = showPageService.getById(showPage.getId());
            EntityBeanUtil.copyProperties(beShowPage, showPage);
        }

        // 保存数据
        showPageService.save(showPage);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("indexpage:showPage:detail")
    public String toDetail(@PathVariable("id") ShowPage showPage, Model model) {
        model.addAttribute("showPage", showPage);
        return "/indexpage/showPage/detail";
    }

    /**
     * 设置一条或者多条数据的状态
     */
    @RequestMapping("/status/{param}")
    @RequiresPermissions("indexpage:showPage:status")
    @ResponseBody
    public ResultVo status(
            @PathVariable("param") String param,
            @RequestParam(value = "ids", required = false) List<Long> ids) {
        // 更新状态
        StatusEnum statusEnum = StatusUtil.getStatusEnum(param);
        if (showPageService.updateStatus(statusEnum, ids)) {
            return ResultVoUtil.success(statusEnum.getMessage() + "成功");
        } else {
            return ResultVoUtil.error(statusEnum.getMessage() + "失败，请重新操作");
        }
    }
}