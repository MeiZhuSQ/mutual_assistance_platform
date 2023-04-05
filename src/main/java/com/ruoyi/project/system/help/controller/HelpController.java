package com.ruoyi.project.system.help.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.help.domain.Help;
import com.ruoyi.project.system.help.service.IHelpService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 求助Controller
 *
 * @author  
 * @date 2023-02-10
 */
@Controller
@RequestMapping("/system/help")
public class HelpController extends BaseController {
    private String prefix = "system/help";

    @Autowired
    private IHelpService helpService;

    @RequiresPermissions("system:help:view")
    @GetMapping()
    public String help() {
        return prefix + "/help";
    }

    /**
     * 查询求助列表
     */
    @RequiresPermissions("system:help:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Help help) {
        startPage();
        List<Help> list = helpService.selectHelpList(help);
        return getDataTable(list);
    }

    /**
     * 导出求助列表
     */
    @RequiresPermissions("system:help:export")
    @Log(title = "求助", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Help help) {
        List<Help> list = helpService.selectHelpList(help);
        ExcelUtil<Help> util = new ExcelUtil<Help>(Help.class);
        return util.exportExcel(list, "求助数据");
    }

    /**
     * 新增求助
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存求助
     */
    @RequiresPermissions("system:help:add")
    @Log(title = "求助", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Help help) {
        return toAjax(helpService.insertHelp(help));
    }

    /**
     * 修改求助
     */
    @RequiresPermissions("system:help:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Help help = helpService.selectHelpById(id);
        mmap.put("help", help);
        return prefix + "/edit";
    }

    /**
     * 修改保存求助
     */
    @RequiresPermissions("system:help:edit")
    @Log(title = "求助", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Help help) {
        return toAjax(helpService.updateHelp(help));
    }

    /**
     * 删除求助
     */
    @RequiresPermissions("system:help:remove")
    @Log(title = "求助", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(helpService.deleteHelpByIds(ids));
    }
}
