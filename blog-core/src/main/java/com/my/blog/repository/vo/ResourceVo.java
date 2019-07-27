package com.my.blog.repository.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceVo {
    private Integer id;

    private String name;

    private String routePath;

    private Integer parentId;

    private String cssSelector;

    private Integer status;

    private Integer type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
