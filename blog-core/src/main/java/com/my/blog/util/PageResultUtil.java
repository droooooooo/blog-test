package com.my.blog.util;

import com.github.pagehelper.PageInfo;
import com.my.blog.common.PageResultDTO;


import java.util.List;


public class PageResultUtil {
    public static <T> PageResultDTO<T> build(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        PageResultDTO<T> resultPage = new PageResultDTO<T>()
                .setPageNum(pageInfo.getPageNum())
                .setPages(pageInfo.getPages())
                .setTotal(pageInfo.getTotal())
                .setResult(list);
        return resultPage;
    }

    public static <T> PageResultDTO<T> build(List<T> list,Integer pageNum,Integer pages,Long total) {

        PageResultDTO<T> resultPage = new PageResultDTO<T>()
                .setPageNum(pageNum)
                .setPages(pages)
                .setTotal(total)
                .setResult(list);
        return resultPage;
    }
}
