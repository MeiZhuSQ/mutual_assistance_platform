package com.ruoyi.project.system.donate.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 捐赠对象 t_donate
 *
 * @author 一粒麦子
 * @date 2023-02-10
 */
public class Donate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long postId;

    /** 捐赠人ID */
    @Excel(name = "捐赠人ID")
    private Long userId;

    /** 物资名称 */
    @Excel(name = "物资名称")
    private String materialName;

    /** 物资来源 */
    @Excel(name = "物资来源")
    private Integer materialSource;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 位置 */
    @Excel(name = "位置")
    private Integer position;

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    public Long getPostId()
    {
        return postId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setMaterialSource(Integer materialSource)
    {
        this.materialSource = materialSource;
    }

    public Integer getMaterialSource()
    {
        return materialSource;
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
            .append("postId", getPostId())
            .append("userId", getUserId())
            .append("materialName", getMaterialName())
            .append("materialSource", getMaterialSource())
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
