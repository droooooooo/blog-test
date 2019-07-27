package com.my.blog.common;

import com.github.pagehelper.PageInfo;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author gusuchen
 * Created in 2018-05-22 14:55
 * Description: 分页的封装对象，已统一的格式返回给前端
 */
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageResultDTO<T> {
    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 结果集
     */
    private List<T> result;

    /**
     * 转换称 {@link PageResultDTO}
     * @param list 数据集
     * @param <T> 数据类型
     * @return {@link PageResultDTO}
     */
    public static <T> PageResultDTO<T> assemblePageResultDTO(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return new PageResultDTO<T>()
                .setPageNum(pageInfo.getPageNum())
                .setPages(pageInfo.getPages())
                .setTotal(pageInfo.getTotal())
                .setResult(pageInfo.getList());
    }

}
