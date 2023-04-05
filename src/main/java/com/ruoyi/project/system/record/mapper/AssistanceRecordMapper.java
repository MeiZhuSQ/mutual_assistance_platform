package com.ruoyi.project.system.record.mapper;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.project.system.record.domain.AssistanceRecord;

/**
 * 互助记录Mapper接口
 * 
 * @author  
 * @date 2023-02-10
 */
public interface AssistanceRecordMapper 
{
    /**
     * 查询互助记录
     * 
     * @param Id 互助记录主键
     * @return 互助记录
     */
    public AssistanceRecord selectAssistanceRecordByPostId(Long Id);

    /**
     * 查询互助记录列表
     * 
     * @param assistanceRecord 互助记录
     * @return 互助记录集合
     */
    public List<AssistanceRecord> selectAssistanceRecordList(AssistanceRecord assistanceRecord);

    public List<AssistanceRecord> selectMyAssistanceRecords(AssistanceRecord assistanceRecord);

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
     * 删除互助记录
     * 
     * @param Id 互助记录主键
     * @return 结果
     */
    public int deleteAssistanceRecordByPostId(Long Id);

    /**
     * 批量删除互助记录
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssistanceRecordByPostIds(String[] Ids);
}
