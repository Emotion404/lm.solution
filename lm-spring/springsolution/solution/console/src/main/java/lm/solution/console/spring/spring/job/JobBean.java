package lm.solution.console.spring.spring.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class JobBean {

    private static final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

    /**
     * 通过 @Scheduled 声明该方法是计划任务
     * fixedRate 属性 指定每隔固定时间执行任务
     * */
    @Scheduled(fixedRate = 5000)
    public void jobOne(){

        System.out.println("每隔5s执行一次 : "+dateFormat.format(new Date()));

    }

    /**
     * 使用 cron 指定执行时间，本例是每天的 11:28 分执行
     * */
    @Scheduled(cron="0 28 11 ? * *")
    public void jobTwo(){

        System.out.println("在指定时间 ："+dateFormat.format(new Date()) +"执行");

    }

}
