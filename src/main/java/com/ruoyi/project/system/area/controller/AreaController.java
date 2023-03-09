package com.ruoyi.project.system.area.controller;

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
import com.ruoyi.project.system.area.domain.Area;
import com.ruoyi.project.system.area.service.IAreaService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 地区Controller
 * 
 * @author 一粒麦子
 * @date 2023-02-11
 */
@Controller
@RequestMapping("/system/area")
public class AreaController extends BaseController
{
    private String prefix = "system/area";

    @Autowired
    private IAreaService areaService;

    @RequiresPermissions("system:area:view")
    @GetMapping()
    public String area()
    {
        return prefix + "/area";
    }

    /**
     * 查询地区列表
     */
    @RequiresPermissions("system:area:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Area area)
    {
        startPage();
        List<Area> list = areaService.selectAreaList(area);
        return getDataTable(list);
    }

    /**
     * 导出地区列表
     */
    @RequiresPermissions("system:area:export")
    @Log(title = "地区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Area area)
    {
        List<Area> list = areaService.selectAreaList(area);
        ExcelUtil<Area> util = new ExcelUtil<Area>(Area.class);
        return util.exportExcel(list, "地区数据");
    }

    /**
     * 新增地区
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存地区
     */
    @RequiresPermissions("system:area:add")
    @Log(title = "地区", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Area area)
    {
        return toAjax(areaService.insertArea(area));
    }

    /**
     * 修改地区
     */
    @RequiresPermissions("system:area:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Area area = areaService.selectAreaById(id);
        mmap.put("area", area);
        return prefix + "/edit";
    }

    /**
     * 修改保存地区
     */
    @RequiresPermissions("system:area:edit")
    @Log(title = "地区", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Area area)
    {
        return toAjax(areaService.updateArea(area));
    }

    /**
     * 删除地区
     */
    @RequiresPermissions("system:area:remove")
    @Log(title = "地区", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(areaService.deleteAreaByIds(ids));
    }
}
