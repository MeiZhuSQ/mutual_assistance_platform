package com.ruoyi.project.system.donate.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.donate.mapper.DonateMapper;
import com.ruoyi.project.system.donate.domain.Donate;
import com.ruoyi.project.system.donate.service.IDonateService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 捐赠Service业务层处理
 * 
 * @author 一粒麦子
 * @date 2023-02-10
 */
@Service
public class DonateServiceImpl implements IDonateService 
{
    @Autowired
    private DonateMapper donateMapper;

    /**
     * 查询捐赠
     * 
     * @param postId 捐赠主键
     * @return 捐赠
     */
    @Override
    public Donate selectDonateByPostId(Long postId)
    {
        return donateMapper.selectDonateByPostId(postId);
    }

    /**
     * 查询捐赠列表
     * 
     * @param donate 捐赠
     * @return 捐赠
     */
    @Override
    public List<Donate> selectDonateList(Donate donate)
    {
        return donateMapper.selectDonateList(donate);
    }

    /**
     * 新增捐赠
     * 
     * @param donate 捐赠
     * @return 结果
     */
    @Override
    public int insertDonate(Donate donate)
    {
        donate.setCreateTime(DateUtils.getNowDate());
        return donateMapper.insertDonate(donate);
    }

    /**
     * 修改捐赠
     * 
     * @param donate 捐赠
     * @return 结果
     */
    @Override
    public int updateDonate(Donate donate)
    {
        donate.setUpdateTime(DateUtils.getNowDate());
        return donateMapper.updateDonate(donate);
    }

    /**
     * 批量删除捐赠
     * 
     * @param postIds 需要删除的捐赠主键
     * @return 结果
     */
    @Override
    public int deleteDonateByPostIds(String postIds)
    {
        return donateMapper.deleteDonateByPostIds(Convert.toStrArray(postIds));
    }

    /**
     * 删除捐赠信息
     * 
     * @param postId 捐赠主键
     * @return 结果
     */
    @Override
    public int deleteDonateByPostId(Long postId)
    {
        return donateMapper.deleteDonateByPostId(postId);
    }
}
