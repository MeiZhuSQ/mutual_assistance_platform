package com.ruoyi.project.system.record.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 互助记录对象 t_assistance_record
 *
 * @author 一粒麦子
 * @date 2023-02-10
 */
public class AssistanceRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long postId;

    /** 求助人ID */
    @Excel(name = "求助人ID")
    private Long helpUserId;

    /** 捐赠人ID */
    @Excel(name = "捐赠人ID")
    private Long donateUserId;

    /** 互助状态（0未解决 1已解决） */
    @Excel(name = "互助状态", readConverterExp = "0=未解决,1=已解决")
    private String status;

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    public Long getPostId()
    {
        return postId;
    }
    public void setHelpUserId(Long helpUserId)
    {
        this.helpUserId = helpUserId;
    }

    public Long getHelpUserId()
    {
        return helpUserId;
    }
    public void setDonateUserId(Long donateUserId)
    {
        this.donateUserId = donateUserId;
    }

    public Long getDonateUserId()
    {
        return donateUserId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("helpUserId", getHelpUserId())
            .append("donateUserId", getDonateUserId())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
