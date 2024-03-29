package com.ruoyi.project.emmanuel.mto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.emmanuel.mto.domain.MtoLink;

import java.util.List;

/**
 * 友情链接
 *
 * @author  
 * @date 2021-12-13
 */
public interface IMtoLinkService extends IService<MtoLink> {
    /**
     * 查询mto
     *
     * @param id mto主键
     * @return mto
     */
    public MtoLink selectMtoLinkById(Long id);

    /**
     * 查询mto列表
     *
     * @param mtoLink mto
     * @return mto集合
     */
    List<MtoLink> selectMtoLinkList(MtoLink mtoLink);

    /**
     * 新增mto
     *
     * @param mtoLink mto
     * @return 结果
     */
    public int insertMtoLink(MtoLink mtoLink);

    /**
     * 修改mto
     *
     * @param mtoLink mto
     * @return 结果
     */
    public int updateMtoLink(MtoLink mtoLink);

    /**
     * 批量删除mto
     *
     * @param ids 需要删除的mto主键集合
     * @return 结果
     */
    public int deleteMtoLinkByIds(String ids);

}
