/**
 * FileName: User
 * Author:   13235
 * Date:     2019/1/9 20:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/9
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
public class User  implements Serializable{

    @HeaderParam("id")
    private Long id;

    @MatrixParam("userName")
    private String userName;

    private Integer age;

    @CookieParam("password")
    private String password;


    private Date birthDate;

    private String address;




}
