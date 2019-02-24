/**
 * FileName: FileInfoServiceImpl
 * Author:   13235
 * Date:     2019/1/13 17:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.service.serviceImpl;

import com.example.demo.domain.FileInfo;
import com.example.demo.repo.FileInfoRepo;
import com.example.demo.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/13
 * @since 1.0.0
 */
@Service
@Slf4j
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoRepo fileInfoRepo;


    @Override
    @Async("asyncThreadPool")
    public List<FileInfo> getAll() {
        return fileInfoRepo.findAll();
    }


    @Override
    public FileInfo findFileInfoById(Integer id) {
        return fileInfoRepo.getOne(id);
    }


    @Override
    public List<FileInfo> findFileInfoByCondition(FileInfo fileInfo) {
        Example<FileInfo> of = Example.of(fileInfo);
        return fileInfoRepo.findAll(of);
    }


    @Override
    public Page<FileInfo> findFileInfoByCondition(Pageable pageable, FileInfo fileInfo) {
        Example<FileInfo> of = Example.of(fileInfo);
        return fileInfoRepo.findAll(of, pageable);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editFileInfo(FileInfo fileInfo) {
        fileInfoRepo.save(fileInfo);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleFileInfo(Integer id) {
        fileInfoRepo.delete(id);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void batchDelFileInfo(List<Integer> ids) {
        for (Integer id : ids) {
            fileInfoRepo.delete(id);
        }
    }

}
