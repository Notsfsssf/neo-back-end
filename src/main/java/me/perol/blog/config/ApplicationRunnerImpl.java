package me.perol.blog.config;

import me.perol.blog.entity.Visit;
import me.perol.blog.mapper.VisitMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import static me.perol.blog.InO.visitArray;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Resource
    VisitMapper visitMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Visit visit = visitMapper.selectById(1);
        visitArray[0] = visit.getWebsite();
        visitArray[1] = visit.getPixez();
    }
}
