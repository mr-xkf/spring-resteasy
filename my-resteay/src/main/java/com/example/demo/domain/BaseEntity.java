/**
 * FileName: BaseEntity
 * Author:   13235
 * Date:     2019/1/24 13:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/24
 * @since 1.0.0
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Version
    @Column(name="reversion")
    private int reversion;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;




}
