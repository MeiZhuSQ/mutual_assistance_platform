package com.ruoyi.project.system.area.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 地区对象 t_area
 *
 * @author  
 * @date 2023-02-11
 */
public class Area extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地区编号（北京：110） */
    private Long id;

    /** 地区名称（城市） */
    @Excel(name = "地区名称", readConverterExp = "城=市")
    private String areaName;

    /** 父编号 */
    @Excel(name = "父编号")
    private Long areaParentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String areaShort;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String areaIndex;

    /** 地区拼音 */
    @Excel(name = "地区拼音")
    private String areaPinyin;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public String getAreaName()
    {
        return areaName;
    }
    public void setAreaParentId(Long areaParentId)
    {
        this.areaParentId = areaParentId;
    }

    public Long getAreaParentId()
    {
        return areaParentId;
    }
    public void setAreaShort(String areaShort)
    {
        this.areaShort = areaShort;
    }

    public String getAreaShort()
    {
        return areaShort;
    }
    public void setAreaIndex(String areaIndex)
    {
        this.areaIndex = areaIndex;
    }

    public String getAreaIndex()
    {
        return areaIndex;
    }
    public void setAreaPinyin(String areaPinyin)
    {
        this.areaPinyin = areaPinyin;
    }

    public String getAreaPinyin()
    {
        return areaPinyin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaName", getAreaName())
            .append("areaParentId", getAreaParentId())
            .append("areaShort", getAreaShort())
            .append("areaIndex", getAreaIndex())
            .append("areaPinyin", getAreaPinyin())
            .toString();
    }
}
