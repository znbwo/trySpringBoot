package com.dao;

import com.entity.PlayerLog;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5 0005.
 */

public interface PlayerLogRepository extends JpaRepository<PlayerLog, Integer> {

    List<PlayerLog> findByTimeBetween(Long start, Long end);

}
