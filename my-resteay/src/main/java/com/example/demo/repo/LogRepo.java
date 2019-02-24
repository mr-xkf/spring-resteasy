package com.example.demo.repo;

import com.example.demo.domain.LogOperate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LogRepo extends JpaRepository<LogOperate, Long> {

    @Modifying
    @Query(value = "update t_log_operate set  user_name=?1  where id=?2", nativeQuery = true)
    void nativeUpdate(String userName, Long id);
}
