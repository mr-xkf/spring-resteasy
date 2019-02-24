/**
 * FileName: LogOperate
 * Author:   13235
 * Date:     2019/1/24 13:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/24
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "t_log_operate", schema = "jwt", catalog = "")
public class LogOperate extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String operateUser;
    private String operateCode;
    private String relyCode;
    private String culumnName;
    private String currentVal;
    private String previousVal;


}
