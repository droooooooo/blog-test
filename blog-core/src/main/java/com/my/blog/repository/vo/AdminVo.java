package com.my.blog.repository.vo;

import com.my.blog.repository.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminVo {
  private String token;
  private User user;
  private Long refreshDate;
}
