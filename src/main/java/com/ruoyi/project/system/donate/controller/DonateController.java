package com.ruoyi.project.system.donate.controller;

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
import com.ruoyi.project.system.donate.domain.Donate;
import com.ruoyi.project.system.donate.service.IDonateService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 捐赠Controller
 * 
 * @author 一粒麦子
 * @date 2023-02-10
 */
@Controller
@RequestMapping("/system/donate")
public class DonateController extends BaseController
{
    private String prefix = "system/donate";

    @Autowired
    private IDonateService donateService;

    @RequiresPermissions("system:donate:view")
    @GetMapping()
    public String donate()
    {
        return prefix + "/donate";
    }

    /**
     * 查询捐赠列表
     */
    @RequiresPermissions("system:donate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Donate donate)
    {
        startPage();
        List<Donate> list = donateService.selectDonateList(donate);
        return getDataTable(list);
    }

    /**
     * 导出捐赠列表
     */
    @RequiresPermissions("system:donate:export")
    @Log(title = "捐赠", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Donate donate)
    {
        List<Donate> list = donateService.selectDonateList(donate);
        ExcelUtil<Donate> util = new ExcelUtil<Donate>(Donate.class);
        return util.exportExcel(list, "捐赠数据");
    }

    /**
     * 新增捐赠
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存捐赠
     */
    @RequiresPermissions("system:donate:add")
    @Log(title = "捐赠", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Donate donate)
    {
        return toAjax(donateService.insertDonate(donate));
    }

    /**
     * 修改捐赠
     */
    @RequiresPermissions("system:donate:edit")
    @GetMapping("/edit/{postId}")
    public String edit(@PathVariable("postId") Long postId, ModelMap mmap)
    {
        Donate donate = donateService.selectDonateByPostId(postId);
        mmap.put("donate", donate);
        return prefix + "/edit";
    }

    /**
     * 修改保存捐赠
     */
    @RequiresPermissions("system:donate:edit")
    @Log(title = "捐赠", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Donate donate)
    {
        return toAjax(donateService.updateDonate(donate));
    }

    /**
     * 删除捐赠
     */
    @RequiresPermissions("system:donate:remove")
    @Log(title = "捐赠", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(donateService.deleteDonateByPostIds(ids));
    }
}
