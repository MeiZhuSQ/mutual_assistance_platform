package com.ruoyi.project.emmanuel.mto.controller;

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
import com.ruoyi.project.emmanuel.mto.domain.MtoChannel;
import com.ruoyi.project.emmanuel.mto.service.IMtoChannelService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 互助栏目Controller
 *
 * @author  
 * @date 2021-11-13
 */
@Controller
@RequestMapping("/mto/channel")
public class MtoChannelController extends BaseController {

    private String prefix = "emmanuel/mto/channel";

    @Autowired
    private IMtoChannelService mtoChannelService;

    @RequiresPermissions("mto:channel:view")
    @GetMapping()
    public String channel() {
        return prefix + "/channel";
    }

    /**
     * 查询互助栏目列表
     */
    @RequiresPermissions("mto:channel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MtoChannel mtoChannel) {
        startPage();
        List<MtoChannel> list = mtoChannelService.selectMtoChannelList(mtoChannel);
        return getDataTable(list);
    }

    /**
     * 导出互助栏目列表
     */
    @RequiresPermissions("mto:channel:export")
    @Log(title = "互助栏目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MtoChannel mtoChannel) {
        List<MtoChannel> list = mtoChannelService.selectMtoChannelList(mtoChannel);
        ExcelUtil<MtoChannel> util = new ExcelUtil<MtoChannel>(MtoChannel.class);
        return util.exportExcel(list, "互助栏目数据");
    }

    /**
     * 新增互助栏目
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存互助栏目
     */
    @RequiresPermissions("mto:channel:add")
    @Log(title = "互助栏目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MtoChannel mtoChannel) {
        return toAjax(mtoChannelService.insertMtoChannel(mtoChannel));
    }

    /**
     * 修改互助栏目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        MtoChannel mtoChannel = mtoChannelService.selectMtoChannelById(id);
        mmap.put("mtoChannel", mtoChannel);
        return prefix + "/edit";
    }

    /**
     * 修改保存互助栏目
     */
    @RequiresPermissions("mto:channel:edit")
    @Log(title = "互助栏目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MtoChannel mtoChannel) {
        return toAjax(mtoChannelService.updateMtoChannel(mtoChannel));
    }

    /**
     * 删除互助栏目
     */
    @RequiresPermissions("mto:channel:remove")
    @Log(title = "互助栏目", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(mtoChannelService.deleteMtoChannelByIds(ids));
    }


}
