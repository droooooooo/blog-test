package com.my.repository.es;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "topic", type = "topic")
public class TopicES {
    @Id
    private Integer id;

    /**
     * 主题类型，0游客发表，1用户发表
     */
    private Integer type;

    /**
     * 评论账号
     */
    private String user_account;

    /**
     * 评论用户id
     */
    private Integer user_id;

    /**
     * 文章id
     */
    private Integer article_id;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新时间
     */
    private Date update_time;

    private Integer flag;

    /**
     * 评论内容
     */
    private String content;

}