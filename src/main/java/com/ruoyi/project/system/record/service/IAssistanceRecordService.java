package com.ruoyi.project.system.record.service;

import java.util.List;
import com.ruoyi.project.system.record.domain.AssistanceRecord;

/**
 * 互助记录Service接口
 * 
 * @author  
 * @date 2023-02-10
 */
public interface IAssistanceRecordService 
{
    /**
     * 查询互助记录
     * 
     * @param id 互助记录主键
     * @return 互助记录
     */
    public AssistanceRecord selectAssistanceRecordByPostId(Long id);

    /**
     * 查询互助记录列表
     * 
     * @param assistanceRecord 互助记录
     * @return 互助记录集合
     */
    public List<AssistanceRecord> selectAssistanceRecordList(AssistanceRecord assistanceRecord);

    /**
     * 新增互助记录
     * 
     * @param assistanceRecord 互助记录
     * @return 结果
     */
    public int insertAssistanceRecord(AssistanceRecord assistanceRecord);

    /**
     * 修改互助记录
     * 
     * @param assistanceRecord 互助记录
     * @return 结果
     */
    public int updateAssistanceRecord(AssistanceRecord assistanceRecord);

    /**
     * 批量删除互助记录
     * 
     * @param ids 需要删除的互助记录主键集合
     * @return 结果
     */
    public int deleteAssistanceRecordByPostIds(String ids);

    /**
     * 删除互助记录信息
     * 
     * @param id 互助记录主键
     * @return 结果
     */
    public int deleteAssistanceRecordByPostId(Long id);
}
