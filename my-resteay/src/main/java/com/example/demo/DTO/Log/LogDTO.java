/**
 * FileName: LogDTO
 * Author:   13235
 * Date:     2019/1/20 17:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.DTO.Log;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/20
 * @since 1.0.0
 */
@ApiModel(value = "修改日志操作人")
@Data
public class LogDTO {

    @ApiModelProperty(value="日志ID",required = true)
    private Long id;

    @ApiModelProperty(value="操作人名称",required = true)
    private String userName;

}
