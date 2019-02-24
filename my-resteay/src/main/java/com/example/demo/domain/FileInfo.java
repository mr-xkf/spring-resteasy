/**
 * FileName: FileInfo
 * Author:   13235
 * Date:     2019/1/13 17:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.Converter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/13
 * @since 1.0.0
 */
@Entity
@Table(name = "file_info", schema = "jwt", catalog = "")
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    //@NotBlank(message = "名称不能为空！")
    private String originName;
    private String name;
   // @NotNull(message = "操作人不能为空！")
    private String operator;
    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //@Pattern(regexp = "yyyy-MM-dd HH:mm:ss",message = "日期格式不正确！")
    private Date operateTime;
    private String md5;
    private long size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "origin_name", nullable = false, length = 255)
    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "operator", nullable = true, length = 100)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "operate_time", nullable = false)
    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Basic
    @Column(name = "md5", nullable = false, length = 40)
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Basic
    @Column(name = "size", nullable = false)
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileInfo fileInfo = (FileInfo) o;
        return id == fileInfo.id &&
                size == fileInfo.size &&
                Objects.equals(originName, fileInfo.originName) &&
                Objects.equals(name, fileInfo.name) &&
                Objects.equals(operator, fileInfo.operator) &&
                Objects.equals(operateTime, fileInfo.operateTime) &&
                Objects.equals(md5, fileInfo.md5);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, originName, name, operator, operateTime, md5, size);
    }
}
