package com.ruoyi.project.emmanuel.mto.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.interceptor.annotation.RepeatSubmit;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.emmanuel.mto.domain.MtoChannel;
import com.ruoyi.project.emmanuel.mto.domain.MtoLookIpFirst;
import com.ruoyi.project.emmanuel.mto.domain.MtoPost;
import com.ruoyi.project.emmanuel.mto.service.IMtoChannelService;
import com.ruoyi.project.emmanuel.mto.service.IMtoPostService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 文章标题题Controller
 *
 * @author  
 * @date 2021-11-13
 */
@Api("互助文章管理")
@Controller
@RequestMapping("/mto/post")
public class MtoPostController extends BaseController {

    private String prefix = "emmanuel/mto/post";

    @Autowired
    private IMtoPostService mtoPostService;

    @Autowired
    private IMtoChannelService mtoChannelService;

    @RequiresPermissions("mto:post:view")
    @GetMapping()
    public String post(ModelMap modelMap) {
        List<MtoChannel> channelList = mtoChannelService.selectMtoChannelList(null);
        modelMap.put("channelList", channelList);
        return prefix + "/post";
    }

    /**
     * 查询文章标题题列表
     */
    @RequiresPermissions("mto:post:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MtoPost mtoPost) {
        startPage();
        List<MtoPost> list = mtoPostService.selectMtoPostList(mtoPost);
        return getDataTable(list);
    }

    /**
     * 新增文章
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        mtoPostService.getAddInfo(modelMap);
        return prefix + "/add";
    }

    /**
     * 判断是否有相同地区的捐赠信息*
     * @param mtoPost
     * @return
     */
    @PostMapping("/isHaveSameAreaInfo")
    @ResponseBody
    public AjaxResult isHaveSameAreaInfo(MtoPost mtoPost) {
        return mtoPostService.isHaveSameAreaInfo(mtoPost);
    }

    /**
     * 新增保存互助 (web新增)
     */
//    @RequiresPermissions("mto:post:add")
    @Log(title = "新增互助", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @RepeatSubmit(interval = 5000, message = "请勿重复提交")
    public AjaxResult addSave(MtoPost mtoPost) {
        return mtoPostService.insertMtoPost(mtoPost);
    }

    /**
     * 修改根据id查询互助
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap modelMap) {
        mtoPostService.getEditInfo(id, modelMap);
        return prefix + "/edit";
    }

    /**
     * 修改互助
     */
    @RequiresPermissions("mto:post:edit")
    @Log(title = "修改互助", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @RepeatSubmit(interval = 5000, message = "请勿重复提交")
    public AjaxResult editSave(MtoPost mtoPost) {
        return toAjax(mtoPostService.updateMtoPost(mtoPost));
    }

    /**
     * 删除互助
     */
    @RequiresPermissions("mto:post:remove")
    @Log(title = "删除互助", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(mtoPostService.deleteMtoPostByIds(ids));
    }

    /**
     * 根据id查看互助文章
     */
    @RequiresPermissions("mto:post:selectDetail")
    @GetMapping("/selectById/{id}")
    public String selectById(@PathVariable("id") Long id, ModelMap modelMap) {
        MtoPost mtoPost = mtoPostService.selectMtoPostById(id);
        modelMap.put("blog", mtoPost);
        return prefix + "/detail";
    }

    /**
     * 导入markdown
     *
     * @param markDownList  markdown文件
     * @param updateSupport 是否更新  (true更新/false不更新)
     * @return
     */
    @Log(title = "导入markdown", businessType = BusinessType.IMPORT)
    @RequiresPermissions("mto:post:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(List<MultipartFile> markDownList, boolean updateSupport) {
        return AjaxResult.success(mtoPostService.importData(markDownList, updateSupport));
    }

    /**
     * 导出互助之单文件
     *
     * @param postId   文章ID
     * @param request
     * @param response
     * @throws Exception
     */
    @PostMapping("/exportData")
    @RequiresPermissions("mto:post:export")
    @ResponseBody
    public void exportMD(Long postId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        mtoPostService.exportMd(postId, request, response);
    }

    /**
     * 互助导出之多文件
     *
     * @param postIds  互助多个id字符
     * @param request
     * @param response
     */
    @PostMapping("/exportDataBatch")
    @RequiresPermissions("mto:post:exportDataBatch")
    @ResponseBody
    public void exportDataBatch(String postIds, HttpServletRequest request, HttpServletResponse response) {
        mtoPostService.exportDataBatch(postIds, request, response);
    }

    /**
     * 清空静态页面
     *
     * @return
     */
    @RequiresPermissions("mto:post:cleasrStaticPage")
    @ResponseBody
    @Log(title = "清空静态页面", businessType = BusinessType.OTHER)
    @PostMapping("/cleasrStaticPage")
    public AjaxResult cleasrStaticPage() {
        return toAjax(mtoPostService.cleasrStaticPage());
    }

    /**
     * 首次访问互助记录
     */
    @RequiresPermissions("mto:blog:first")
    @GetMapping("/first")
    public String first() {
        return prefix + "/blogFirstLog";
    }

    /**
     * 查询首次访问互助记录列表
     */
    @RequiresPermissions("mto:blog:first")
    @PostMapping("/first/list")
    @ResponseBody
    public TableDataInfo list(MtoLookIpFirst mtoLookIpFirst) {
        startPage();
        List<MtoLookIpFirst> list = mtoPostService.selectLookIpFirstList(mtoLookIpFirst);
        return getDataTable(list);
    }

    /**
     * 首访互助记录
     *
     * @param ids
     * @return
     */
    @RequiresPermissions("mto:blog:first:remove")
    @ResponseBody
    @Log(title = "首访互助记录", businessType = BusinessType.DELETE)
    @PostMapping("/first/remove")
    public AjaxResult firstRemove(String ids) {
        return toAjax(mtoPostService.firstRemove(ids));
    }

}
