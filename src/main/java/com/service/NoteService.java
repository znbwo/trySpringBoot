package com.service;

import com.dao.PlayerLogRepository;
import com.entity.PlayerLog;
import com.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.sql.rowset.Predicate;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6 0006.
 */
@Service
public class NoteService {
    private static final Logger log = LoggerFactory.getLogger(NoteService.class);

    @Value("${logFilePath}")
    private String logFilePath;
    @Autowired
    private PlayerLogRepository playerLogRepository;

    @Scheduled(cron = "30 0 0 * * ? ")//24:00:30 per day
    public void work() throws IOException {
        format2Entity(findFile(Utils.getDateBefore(new Date(), 1)));
    }
    public void work(Date date) throws IOException {
        format2Entity(findFile(date));
    }

    private void format2Entity(File file)throws IOException  {
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String content = null;
            while ((content = reader.readLine()) != null) {
                if (!StringUtils.isEmpty(content)) {
                    String[] s1 = content.split("\\s");//空格分割
                    String[] s2 = s1[2].split(":");
                    for (String ss2 : s2) {
                        String[] s3 = ss2.split(",");
                        PlayerLog entity = new PlayerLog(Integer.valueOf(s1[0]), Short.valueOf(s1[1]), Short.valueOf(s3[0]), Integer.valueOf(s3[1]), Long.valueOf(s1[3]));
                        this.save(entity);
                    }
                }
            }
            reader.close();//close the stream
        } else {
            log.warn("{} not exists.", file.getAbsolutePath());
        }
    }
    private File findFile(Date date) throws FileNotFoundException {
        String file = "note-" + Utils.formatDate(date) + ".log";//note-2017-01-04.log
        if (!logFilePath.endsWith("/") && !logFilePath.endsWith("\\")) {
            file = File.pathSeparatorChar + file;
        }
        return ResourceUtils.getFile(logFilePath + file);
    }


    public void save(PlayerLog entity) {
        playerLogRepository.save(entity);
    }

    public List<PlayerLog> findBetween(long start, long end) {
        return playerLogRepository.findByTimeBetween(start, end);
    }
}


