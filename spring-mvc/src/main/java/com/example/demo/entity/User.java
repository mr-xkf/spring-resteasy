/**
 * FileName: User
 * Author:   13235
 * Date:     2019/1/27 15:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.entity;

import com.example.demo.utils.GroupA;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/27
 * @since 1.0.0
 */
@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    @NotNull(message = "uid不能为空！",groups = {GroupA.class})
    public Integer uid;

    @Column(name = "username")
    @NotBlank(message="userName不能为空！")
    public String userName;

    @Column(name = "password")
    @NotBlank(message="password不能为空！")
    public String password;


}
