package com.ruoyi.project.system.area.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.area.mapper.AreaMapper;
import com.ruoyi.project.system.area.domain.Area;
import com.ruoyi.project.system.area.service.IAreaService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 地区Service业务层处理
 * 
 * @author 一粒麦子
 * @date 2023-02-11
 */
@Service
public class AreaServiceImpl implements IAreaService 
{
    @Autowired
    private AreaMapper areaMapper;

    /**
     * 查询地区
     * 
     * @param id 地区主键
     * @return 地区
     */
    @Override
    public Area selectAreaById(Long id)
    {
        return areaMapper.selectAreaById(id);
    }

    /**
     * 查询地区列表
     * 
     * @param area 地区
     * @return 地区
     */
    @Override
    public List<Area> selectAreaList(Area area)
    {
        return areaMapper.selectAreaList(area);
    }

    /**
     * 新增地区
     * 
     * @param area 地区
     * @return 结果
     */
    @Override
    public int insertArea(Area area)
    {
        return areaMapper.insertArea(area);
    }

    /**
     * 修改地区
     * 
     * @param area 地区
     * @return 结果
     */
    @Override
    public int updateArea(Area area)
    {
        return areaMapper.updateArea(area);
    }

    /**
     * 批量删除地区
     * 
     * @param ids 需要删除的地区主键
     * @return 结果
     */
    @Override
    public int deleteAreaByIds(String ids)
    {
        return areaMapper.deleteAreaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除地区信息
     * 
     * @param id 地区主键
     * @return 结果
     */
    @Override
    public int deleteAreaById(Long id)
    {
        return areaMapper.deleteAreaById(id);
    }
}
