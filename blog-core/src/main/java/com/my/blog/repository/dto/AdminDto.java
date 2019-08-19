package com.my.blog.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
  /**
   * 用户名
   */
  private String account;

  /**
   * 密码
   */
  private String password;
  /**
   * 昵称
   */
  private String nikename;

  /**
   * 手机号码
   */
  private String telephone;

  /**
   * 用户类型 0管理员,1用户
   */
  private Integer type;

  private Date createTime;
}
