/**
 * FileName: CommonResult
 * Author:   13235
 * Date:     2019/1/13 15:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.exception;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 〈一句话功能简述〉<br>
 * 统一的响应类
 *
 * @author 13235
 * @create 2019/1/13
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
public class CommonResult {
    /**
     *
     * 响应码
     *
     */
    private Integer code;

    /**
     *
     * 响应消息
     *
     */
    private String message;
    /**
     *
     * 反馈数据
     *
     */
    private Object data;

    public static CommonResult create(Object data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(200);
        commonResult.setMessage("success");
        commonResult.setData(data);
        return commonResult;
    }


    public static CommonResult create(Integer code, String message, Object data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setData(data);
        return commonResult;
    }

}
