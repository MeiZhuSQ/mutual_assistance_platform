package com.ruoyi.project.emmanuel.mto.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.emmanuel.mto.domain.MtoChannel;
import com.ruoyi.project.emmanuel.mto.domain.MtoGolden;
import com.ruoyi.project.emmanuel.mto.domain.MtoPost;
import com.ruoyi.project.emmanuel.mto.domain.WebMtoPost;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IWebPostService extends IService<WebMtoPost> {

    /**
     * 获取首页栏目
     *
     * @return
     */
    List<MtoChannel> selectIndexChannelList();

    /**
     * 获取最新文章
     *
     * @return
     */
    List<WebMtoPost> selectIndexNewPostList();

    /**
     * 随机查询一条名言
     *
     * @return
     */
    MtoGolden selectIndexGolden();

    /**
     * 根据id获取互助详情
     *
     * @param id 互助id
     * @return
     */
    WebMtoPost selectMtoPostById(Long id);

    /**
     * 前台互助文章列表
     *
     * @param modelMap
     * @param request
     * @param response
     * @param currentPage 当前页
     * @param currentSize 页大小
     * @return
     */
    String selectIndexInfo(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Long currentPage, Long currentSize);

    /**
     * 根据导航栏id查询
     *
     * @param modelMap
     * @param categoryId  categoryId
     * @param currentPage 当前页
     * @param currentSize 页大小
     * @return
     */
    void categoryById(ModelMap modelMap, Long categoryId, Long currentPage, Long currentSize);

    /**
     * 根据分类查询
     *
     * @param modelMap
     * @param channelId   分类id
     * @param currentPage 当前页
     * @param currentSize 页大小
     * @return
     */
    void channelById(ModelMap modelMap, Long channelId, Long currentPage, Long currentSize);

    /**
     * * 文章详情
     *
     * @param modelMap
     * @param request
     * @param response
     * @param articleId  文章id
     * @param articlePwd 文章密码
     * @return
     */
    String articleById(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, Long articleId, String articlePwd);

    /**
     * 点赞
     *
     * @param request
     * @param postId     文章id
     * @param favorsType 点赞类型  1文章点赞
     * @return
     */
    AjaxResult loveFavors(HttpServletRequest request, String ip, Long postId, Integer favorsType);

    /**
     * 留言
     *
     * @param modelMap
     */
    void leaveMessage(ModelMap modelMap);

    /**
     * 获取导航懒
     *
     * @param modelMap
     */
    void selectCategory(ModelMap modelMap);

    /**
     * 获取侧边栏
     *
     * @param modelMap
     */
    void publicWeb(ModelMap modelMap);

    /**
     * 时间归档
     *
     * @param modelMap
     * @param currentPage
     * @param currentSize
     */
    List<MtoPost> timeArchives(ModelMap modelMap, Long currentPage, Long currentSize);

    /**
     * 根据分类查询
     *
     * @param tagId       标签id
     * @param modelMap
     * @param currentPage
     * @param currentSize
     * @return
     */
    void selectBlogByTagId(ModelMap modelMap, Long tagId, Long currentPage, Long currentSize);

    /**
     * 获取首页文章
     *
     * @param currentPage
     * @param currentSize
     * @return
     */
    public TableDataInfo selectIndexPostList(WebMtoPost webMtoPost, Long currentPage, Long currentSize);

    /**
     * 标签页获取标签
     *
     * @param modelMap
     */
    void selectTagList(ModelMap modelMap);

    /**
     * 获取动态
     *  @param pageNum  当前页
     * @param pageSize 页大小
     * @param modelMap
     * @param request
     * @param response
     */
    String dynamicList(Long pageNum, Long pageSize, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据关键字搜索
     *
     * @param keyword  关键字
     * @param pageNum  页码
     * @param pageSize 多少条数据
     */
    void searchByKeyword(ModelMap modelMap, String keyword, Long pageNum, Long pageSize);

    AjaxResult wantApplyOrDonate(HttpServletRequest request, Long postId, Long authorId, Integer channelId);

    AjaxResult cancelApply(HttpServletRequest request, Long postId);
}
