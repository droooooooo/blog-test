package com.my.blog.repository.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class ArticleVo {
    private Integer id;

    /**
     * 文章标题
     */
    @JsonProperty(value = "title")
    private String articleName;

    /**
     * 文章作者
     */
    @JsonProperty(value = "author")
    private String articleAuthor;

    /**
     * 文章描述
     */
    @JsonProperty(value = "description")
    private String articleDescription;

    /**
     * 浏览量
     */
    @JsonProperty(value = "pv")
    private Integer articlePv;

    /**
     * 文章类型0作者，1其他人,默认作者
     */
    @JsonProperty(value = "type")
    private Integer articleType;

    /**
     * 文章状态0停用，1启用，默认启用
     */
    private Integer status;

    /**
     * 文章内容
     */
    @JsonProperty(value = "content")
    private String articleContent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer flag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取文章标题
     *
     * @return article_name - 文章标题
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * 设置文章标题
     *
     * @param articleName 文章标题
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    /**
     * 获取文章作者
     *
     * @return article_author - 文章作者
     */
    public String getArticleAuthor() {
        return articleAuthor;
    }

    /**
     * 设置文章作者
     *
     * @param articleAuthor 文章作者
     */
    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor == null ? null : articleAuthor.trim();
    }

    /**
     * 获取文章描述
     *
     * @return article_description - 文章描述
     */
    public String getArticleDescription() {
        return articleDescription;
    }

    /**
     * 设置文章描述
     *
     * @param articleDescription 文章描述
     */
    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription == null ? null : articleDescription.trim();
    }

    /**
     * 获取浏览量
     *
     * @return article_pv - 浏览量
     */
    public Integer getArticlePv() {
        return articlePv;
    }

    /**
     * 设置浏览量
     *
     * @param articlePv 浏览量
     */
    public void setArticlePv(Integer articlePv) {
        this.articlePv = articlePv;
    }

    /**
     * 获取文章类型0作者，1其他人,默认作者
     *
     * @return article_type - 文章类型0作者，1其他人,默认作者
     */
    public Integer getArticleType() {
        return articleType;
    }

    /**
     * 设置文章类型0作者，1其他人,默认作者
     *
     * @param articleType 文章类型0作者，1其他人,默认作者
     */
    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    /**
     * 获取文章状态0停用，1启用，默认启用
     *
     * @return status - 文章状态0停用，1启用，默认启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置文章状态0停用，1启用，默认启用
     *
     * @param status 文章状态0停用，1启用，默认启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取文章内容
     *
     * @return article_content - 文章内容
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * 设置文章内容
     *
     * @param articleContent 文章内容
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}