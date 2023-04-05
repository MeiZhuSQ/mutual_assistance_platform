package com.ruoyi.project.system.help.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.help.mapper.HelpMapper;
import com.ruoyi.project.system.help.domain.Help;
import com.ruoyi.project.system.help.service.IHelpService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 求助Service业务层处理
 * 
 * @author  
 * @date 2023-02-10
 */
@Service
public class HelpServiceImpl implements IHelpService 
{
    @Autowired
    private HelpMapper helpMapper;

    /**
     * 查询求助
     * 
     * @param id 求助主键
     * @return 求助
     */
    @Override
    public Help selectHelpById(Long id)
    {
        return helpMapper.selectHelpById(id);
    }

    /**
     * 查询求助列表
     * 
     * @param help 求助
     * @return 求助
     */
    @Override
    public List<Help> selectHelpList(Help help)
    {
        return helpMapper.selectHelpList(help);
    }

    /**
     * 新增求助
     * 
     * @param help 求助
     * @return 结果
     */
    @Override
    public int insertHelp(Help help)
    {
        help.setCreateTime(DateUtils.getNowDate());
        return helpMapper.insertHelp(help);
    }

    /**
     * 修改求助
     * 
     * @param help 求助
     * @return 结果
     */
    @Override
    public int updateHelp(Help help)
    {
        help.setUpdateTime(DateUtils.getNowDate());
        return helpMapper.updateHelp(help);
    }

    /**
     * 批量删除求助
     * 
     * @param ids 需要删除的求助主键
     * @return 结果
     */
    @Override
    public int deleteHelpByIds(String ids)
    {
        return helpMapper.deleteHelpByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除求助信息
     * 
     * @param id 求助主键
     * @return 结果
     */
    @Override
    public int deleteHelpById(Long id)
    {
        return helpMapper.deleteHelpById(id);
    }
}
