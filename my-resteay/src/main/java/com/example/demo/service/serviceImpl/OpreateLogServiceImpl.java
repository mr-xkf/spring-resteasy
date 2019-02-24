/**
 * FileName: OpreateLogServiceImpl
 * Author:   13235
 * Date:     2019/1/20 3:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.service.serviceImpl;

import com.example.demo.domain.LogOperate;
import com.example.demo.repo.LogRepo;
import com.example.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/20
 * @since 1.0.0
 */
@Service
@Slf4j
public class OpreateLogServiceImpl implements LogService {

    @Override
    //@LogMark(operatType = LogMark.LogType.EDIT)
    @Transactional(rollbackFor = RuntimeException.class)
    public void editLog(LogOperate opreateLog) {
        logRepo.save(opreateLog);
    }

    @Override
    //@LogMark(operatType = LogMark.LogType.EDIT)
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateUserName(String userName, Long id) {
        Assert.notNull(userName, "修改名称不能为空！");
        Assert.notNull(id, "日志ID不能为空！");
        logRepo.nativeUpdate(userName, id);
    }

    @Autowired
    private LogRepo logRepo;


    @Override
    public List<LogOperate> findLogList() {
        return logRepo.findAll();
    }

    @Override
    //@LogMark(operatType = LogMark.LogType.DELETE)
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteLog(Long id) {
        logRepo.delete(id);
    }

    @Override
    public LogOperate findLogById(Long id) {
        Assert.notNull(id, "日志ID不能为空！");
        return logRepo.findOne(id);
    }
}
