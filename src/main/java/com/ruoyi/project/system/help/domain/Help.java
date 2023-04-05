package com.ruoyi.project.system.help.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 求助对象 t_help
 *
 * @author  
 * @date 2023-02-10
 */
public class Help extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 求助人ID */
    @Excel(name = "求助人ID")
    private Long userId;

    /** 求助人类型 */
    @Excel(name = "求助人类型")
    private Integer userType;

    /** 药物名称 */
    @Excel(name = "药物名称")
    private String materialName;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 位置 */
    @Excel(name = "位置")
    private Integer position;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserType(Integer userType)
    {
        this.userType = userType;
    }

    public Integer getUserType()
    {
        return userType;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setPosition(Integer position)
    {
        this.position = position;
    }

    public Integer getPosition()
    {
        return position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("userType", getUserType())
            .append("materialName", getMaterialName())
            .append("description", getDescription())
            .append("position", getPosition())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
