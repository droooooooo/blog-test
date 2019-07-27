package com.my.blog.common;


import com.my.blog.constant.SysRetCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.UUID;

/**
 * 描述 : rest响应对象
 *
 * @author wangkang
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestResponse implements Serializable {
    /**
     * 描述 : 状态码(业务定义)
     */
    private String code = SysRetCodeEnum.COM_SUCCESS.getCode();

    /**
     * 描述 : 状态码描述(业务定义)
     */
    private String returnMsg = SysRetCodeEnum.COM_SUCCESS.getMessage();

    /**
     * 描述 : 结果集(泛型)
     */
    private Object data;

    private boolean success;

    public void setResult(Object result) {
        if (result == null) {
            this.data = "";
        } else {
            this.data = result;
        }
    }
}
