package com.ruoyi.project.system.record.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.record.mapper.AssistanceRecordMapper;
import com.ruoyi.project.system.record.domain.AssistanceRecord;
import com.ruoyi.project.system.record.service.IAssistanceRecordService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 互助记录Service业务层处理
 * 
 * @author 一粒麦子
 * @date 2023-02-10
 */
@Service
public class AssistanceRecordServiceImpl implements IAssistanceRecordService 
{
    @Autowired
    private AssistanceRecordMapper assistanceRecordMapper;

    /**
     * 查询互助记录
     * 
     * @param id 互助记录主键
     * @return 互助记录
     */
    @Override
    public AssistanceRecord selectAssistanceRecordByPostId(Long id)
    {
        return assistanceRecordMapper.selectAssistanceRecordByPostId(id);
    }

    /**
     * 查询互助记录列表
     * 
     * @param assistanceRecord 互助记录
     * @return 互助记录
     */
    @Override
    public List<AssistanceRecord> selectAssistanceRecordList(AssistanceRecord assistanceRecord)
    {
        return assistanceRecordMapper.selectAssistanceRecordList(assistanceRecord);
    }

    /**
     * 新增互助记录
     * 
     * @param assistanceRecord 互助记录
     * @return 结果
     */
    @Override
    public int insertAssistanceRecord(AssistanceRecord assistanceRecord)
    {
        assistanceRecord.setCreateTime(DateUtils.getNowDate());
        return assistanceRecordMapper.insertAssistanceRecord(assistanceRecord);
    }

    /**
     * 修改互助记录
     * 
     * @param assistanceRecord 互助记录
     * @return 结果
     */
    @Override
    public int updateAssistanceRecord(AssistanceRecord assistanceRecord)
    {
        assistanceRecord.setUpdateTime(DateUtils.getNowDate());
        return assistanceRecordMapper.updateAssistanceRecord(assistanceRecord);
    }

    /**
     * 批量删除互助记录
     * 
     * @param ids 需要删除的互助记录主键
     * @return 结果
     */
    @Override
    public int deleteAssistanceRecordByPostIds(String ids)
    {
        return assistanceRecordMapper.deleteAssistanceRecordByPostIds(Convert.toStrArray(ids));
    }

    /**
     * 删除互助记录信息
     * 
     * @param id 互助记录主键
     * @return 结果
     */
    @Override
    public int deleteAssistanceRecordByPostId(Long id)
    {
        return assistanceRecordMapper.deleteAssistanceRecordByPostId(id);
    }
}
