/**
 * FileName: OpreateLog
 * Author:   13235
 * Date:     2019/1/20 3:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/20
 * @since 1.0.0
 */
@Entity
@Table(name = "opreate_log", schema = "jwt", catalog = "")
@Data
public class OpreateLog {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "modify_date", nullable = false)
    private Date modifyDate;
    @Column(name = "modify_type", nullable = false)
    private String modifyType;
    @Column(name = "modify_object", nullable = false)
    private String modifyObject;
    @Column(name = "modify_content", nullable = false)
    private String modifyContent;
    @Column(name = "modify_ip", nullable = false)
    private String modifyIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
    }

    public String getModifyObject() {
        return modifyObject;
    }

    public void setModifyObject(String modifyObject) {
        this.modifyObject = modifyObject;
    }

    public String getModifyContent() {
        return modifyContent;
    }

    public void setModifyContent(String modifyContent) {
        this.modifyContent = modifyContent;
    }

    public String getModifyIp() {
        return modifyIp;
    }

    public void setModifyIp(String modifyIp) {
        this.modifyIp = modifyIp;
    }
}
