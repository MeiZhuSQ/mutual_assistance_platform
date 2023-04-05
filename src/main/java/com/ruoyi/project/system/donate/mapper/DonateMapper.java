package com.ruoyi.project.system.donate.mapper;

import java.util.List;
import com.ruoyi.project.system.donate.domain.Donate;

/**
 * 捐赠Mapper接口
 * 
 * @author  
 * @date 2023-02-10
 */
public interface DonateMapper 
{
    /**
     * 查询捐赠
     * 
     * @param postId 捐赠主键
     * @return 捐赠
     */
    public Donate selectDonateByPostId(Long postId);

    /**
     * 查询捐赠列表
     * 
     * @param donate 捐赠
     * @return 捐赠集合
     */
    public List<Donate> selectDonateList(Donate donate);

    /**
     * 新增捐赠
     * 
     * @param donate 捐赠
     * @return 结果
     */
    public int insertDonate(Donate donate);

    /**
     * 修改捐赠
     * 
     * @param donate 捐赠
     * @return 结果
     */
    public int updateDonate(Donate donate);

    /**
     * 删除捐赠
     * 
     * @param postId 捐赠主键
     * @return 结果
     */
    public int deleteDonateByPostId(Long postId);

    /**
     * 批量删除捐赠
     * 
     * @param postIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDonateByPostIds(String[] postIds);
}
