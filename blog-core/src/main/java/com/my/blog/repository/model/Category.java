package com.my.blog.repository.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(name="",sequenceName="SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 分类名
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类类型
     */
    @Column(name = "category_type")
    private Integer categoryType;

    /**
     * 用户状态0停用，1启用，默认启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
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
     * 获取分类名
     *
     * @return category_name - 分类名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名
     *
     * @param categoryName 分类名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取分类类型
     *
     * @return category_type - 分类类型
     */
    public Integer getCategoryType() {
        return categoryType;
    }

    /**
     * 设置分类类型
     *
     * @param categoryType 分类类型
     */
    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    /**
     * 获取用户状态0停用，1启用，默认启用
     *
     * @return status - 用户状态0停用，1启用，默认启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户状态0停用，1启用，默认启用
     *
     * @param status 用户状态0停用，1启用，默认启用
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
}