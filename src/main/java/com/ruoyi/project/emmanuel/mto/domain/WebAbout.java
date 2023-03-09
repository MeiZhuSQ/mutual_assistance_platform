package com.ruoyi.project.emmanuel.mto.domain;

import lombok.Data;

@Data
public class WebAbout {


    private String id;
    /**
     * 侧边栏用户 头像
     */
    private String abAvatar;
    /**
     * 侧边栏用户 name
     */
    private String abName;
    /**
     * 侧边栏用户 描述
     */
    private String abText;

}
