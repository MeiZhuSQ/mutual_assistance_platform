package com.ruoyi.project.emmanuel.index.controller;

import com.ruoyi.project.emmanuel.index.service.FocusBlogService;
import com.ruoyi.project.emmanuel.mto.domain.MtoCategory;
import com.ruoyi.project.emmanuel.mto.domain.MtoChannel;
import com.ruoyi.project.emmanuel.mto.domain.MtoTag;
import com.ruoyi.project.emmanuel.mto.service.IMtoCategoryService;
import com.ruoyi.project.emmanuel.mto.service.IMtoChannelService;
import com.ruoyi.project.emmanuel.mto.service.IMtoPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/blog/blog")
public class FocusBlogController {

    private String prefix = "emmanuel/web";

    @Autowired
    private FocusBlogService focusBlogService;

    @Autowired
    private IMtoChannelService mtoChannelService;

    @Autowired
    private IMtoPostService mtoPostService;

    @Autowired
    private IMtoCategoryService mtoCategoryService;

    @GetMapping("/focus")
    public String focus(ModelMap modelMap,
                              @RequestParam(value = "currentPage", defaultValue = "1") Long currentPage,
                              @RequestParam(value = "currentSize", defaultValue = "20") Long currentSize) {
        focusBlogService.selectIndexInfo(modelMap, currentPage, currentSize);

        // 获取分类
        MtoChannel mtoChannel = new MtoChannel();
        List<MtoChannel> channelList = mtoChannelService.selectMtoChannelList(mtoChannel);
        modelMap.put("channelList", channelList);

        // 获取标签
        List<MtoTag> tagList = mtoPostService.selectMtoTagList();
        modelMap.put("tagList", tagList);

        // 获取导航栏
        MtoCategory category = new MtoCategory();
        category.setStatus(1);
        List<MtoCategory> categoryList = mtoCategoryService.selectCategories(category);
        modelMap.put("categoryList", categoryList);
        return prefix + "/focus";
    }

    @GetMapping("/donate")
    public String donate(ModelMap modelMap,
                              @RequestParam(value = "currentPage", defaultValue = "1") Long currentPage,
                              @RequestParam(value = "currentSize", defaultValue = "20") Long currentSize) {
        focusBlogService.selectIndexInfo(modelMap, currentPage, currentSize);

        // 获取分类
        MtoChannel mtoChannel = new MtoChannel();
        List<MtoChannel> channelList = mtoChannelService.selectMtoChannelList(mtoChannel);
        modelMap.put("channelList", channelList);

        // 获取标签
        List<MtoTag> tagList = mtoPostService.selectMtoTagList();
        modelMap.put("tagList", tagList);

        // 获取导航栏
        MtoCategory category = new MtoCategory();
        category.setStatus(1);
        List<MtoCategory> categoryList = mtoCategoryService.selectCategories(category);
        modelMap.put("categoryList", categoryList);
        return prefix + "/donate";
    }
}
