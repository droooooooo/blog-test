package com.my.blog.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto {
    private Integer id;

    private String name;

    private String routePath;

    private Integer parentId;

    private String cssSelector;

    private Integer status;

    private Integer type;
}
