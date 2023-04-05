package com.ruoyi.project.system.help.service;

import java.util.List;
import com.ruoyi.project.system.help.domain.Help;

/**
 * 求助Service接口
 * 
 * @author  
 * @date 2023-02-10
 */
public interface IHelpService 
{
    /**
     * 查询求助
     * 
     * @param id 求助主键
     * @return 求助
     */
    public Help selectHelpById(Long id);

    /**
     * 查询求助列表
     * 
     * @param help 求助
     * @return 求助集合
     */
    public List<Help> selectHelpList(Help help);

    /**
     * 新增求助
     * 
     * @param help 求助
     * @return 结果
     */
    public int insertHelp(Help help);

    /**
     * 修改求助
     * 
     * @param help 求助
     * @return 结果
     */
    public int updateHelp(Help help);

    /**
     * 批量删除求助
     * 
     * @param ids 需要删除的求助主键集合
     * @return 结果
     */
    public int deleteHelpByIds(String ids);

    /**
     * 删除求助信息
     * 
     * @param id 求助主键
     * @return 结果
     */
    public int deleteHelpById(Long id);
}
