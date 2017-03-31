package com.service;

import com.entity.PlayerLog;
import com.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6 0006.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceTest {
    @Autowired
    private NoteService noteService;

    @Test
    public void test1() throws Exception {
        noteService.work(Utils.getDateBefore(new Date(), 1));
    }

    @Test
    public void test2() throws Exception {
        List<PlayerLog> logs = noteService.findBetween(0, Long.MAX_VALUE);
        for (PlayerLog log : logs) {
            System.out.println(log);
        }
    }

    @Test
    public void test3() throws Exception {
        int count = 0;
        int had = 43517  ;
        int million = 1000000;
        int limit = million - had;
        while (count < limit) {
        PlayerLog playerLog = new PlayerLog(had+count, (short) 1, (short) 5, 30, new Date().getTime());
            noteService.save(playerLog);
            count++;
            System.out.println(count);
        }
    }


}