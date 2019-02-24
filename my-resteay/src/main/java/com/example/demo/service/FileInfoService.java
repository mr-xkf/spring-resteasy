/**
 * FileName: FileInfoService
 * Author:   13235
 * Date:     2019/1/13 17:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.service;

import com.example.demo.domain.FileInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/13
 * @since 1.0.0
 */

public interface FileInfoService {

    /**
     *
     * 查询所有文件信息
     * @return
     *
     */
    List<FileInfo> getAll();

    /**
     *
     * 根据文件主键查询
     * @param id
     * @return
     *
     */
    FileInfo findFileInfoById(Integer id);

    /**
     *
     * 根据条件查询
     * @param
     * @return
     *
     */
    List<FileInfo> findFileInfoByCondition(FileInfo fileInfo);

    /**
     *
     * 根据条件分页查询
     * @param pageable
     * @param
     * @return
     *
     */
    Page<FileInfo> findFileInfoByCondition(Pageable pageable, FileInfo fileInfo);

    /**
     *
     * 编辑文件信息
     *
     * @param fileInfo
     */
    void editFileInfo(FileInfo fileInfo);

    /**
     *
     * 删除文件
     * @param id
     *
     */
    void deleFileInfo(Integer id);

    /**
     * 批量删除文件
     * @param ids
     *
     */
    void batchDelFileInfo(List<Integer> ids);





}
