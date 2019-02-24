package com.example.demo.service;

import com.example.demo.domain.LogOperate;

import java.util.List;

public interface LogService {


    /**
     * 新增或修改日志服务
     *
     * @param opreateLog
     */
    void editLog(LogOperate opreateLog);


    /**
     * 根据日志ID的
     *
     * @param userName
     * @param id
     */
    void updateUserName(String userName, Long id);


    /**
     * 查询日志列表
     *
     * @return
     */
    List<LogOperate> findLogList();


    /**
     * 根据id删除日志
     *
     * @param id
     */
    void deleteLog(Long id);


    /**
     * 根据日志ID查询日志信息
     *
     * @param id
     * @return
     */
    LogOperate findLogById(Long id);

}
