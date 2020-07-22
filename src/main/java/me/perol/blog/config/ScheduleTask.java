package me.perol.blog.config;

import me.perol.blog.InO;
import me.perol.blog.entity.Visit;
import me.perol.blog.mapper.VisitMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import javax.annotation.Resource;

@Configuration
@EnableScheduling
public class ScheduleTask {
    @Resource
    VisitMapper visitMapper;

    @Scheduled(fixedRate = 1000 * 60*2)
    public void configureTasks() {
        Visit visit = new Visit();
        visit.setId(1L);
        visit.setWebsite(InO.visitArray[0]);
        visit.setPixez(InO.visitArray[1]);
        visitMapper.updateById(visit);
    }
}
