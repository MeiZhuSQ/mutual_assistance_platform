package com.ruoyi.project.system.record.controller;

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
import com.ruoyi.project.system.record.domain.AssistanceRecord;
import com.ruoyi.project.system.record.service.IAssistanceRecordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 互助记录Controller
 * 
 * @author 一粒麦子
 * @date 2023-02-10
 */
@Controller
@RequestMapping("/system/record")
public class AssistanceRecordController extends BaseController
{
    private String prefix = "system/record";

    @Autowired
    private IAssistanceRecordService assistanceRecordService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询互助记录列表
     */
    @RequiresPermissions("system:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssistanceRecord assistanceRecord)
    {
        startPage();
        List<AssistanceRecord> list = assistanceRecordService.selectAssistanceRecordList(assistanceRecord);
        return getDataTable(list);
    }

    /**
     * 导出互助记录列表
     */
    @RequiresPermissions("system:record:export")
    @Log(title = "互助记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssistanceRecord assistanceRecord)
    {
        List<AssistanceRecord> list = assistanceRecordService.selectAssistanceRecordList(assistanceRecord);
        ExcelUtil<AssistanceRecord> util = new ExcelUtil<AssistanceRecord>(AssistanceRecord.class);
        return util.exportExcel(list, "互助记录数据");
    }

    /**
     * 新增互助记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存互助记录
     */
    @RequiresPermissions("system:record:add")
    @Log(title = "互助记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssistanceRecord assistanceRecord)
    {
        return toAjax(assistanceRecordService.insertAssistanceRecord(assistanceRecord));
    }

    /**
     * 修改互助记录
     */
    @RequiresPermissions("system:record:edit")
    @GetMapping("/edit/{postId}")
    public String edit(@PathVariable("postId") Long postId, ModelMap mmap)
    {
        AssistanceRecord assistanceRecord = assistanceRecordService.selectAssistanceRecordByPostId(postId);
        mmap.put("assistanceRecord", assistanceRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存互助记录
     */
    @RequiresPermissions("system:record:edit")
    @Log(title = "互助记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssistanceRecord assistanceRecord)
    {
        return toAjax(assistanceRecordService.updateAssistanceRecord(assistanceRecord));
    }

    /**
     * 删除互助记录
     */
    @RequiresPermissions("system:record:remove")
    @Log(title = "互助记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assistanceRecordService.deleteAssistanceRecordByPostIds(ids));
    }
}
