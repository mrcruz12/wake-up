package br.com.darstec.wakeup.scheduling;

import br.com.darstec.wakeup.WakeUpApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class SchedulingTask {

    private final long MINUT = 1000 * 60 * 10;
    private static final Logger log = LoggerFactory.getLogger(WakeUpApplication.class);

    @Autowired
    RestTemplate restTemplate;

    @Scheduled(fixedDelay = MINUT)
    public void scheduleFutureTask() {
        System.out.println("schedule ok!");

        if (restTemplate != null){
            String resposta = restTemplate.getForObject(
                    "https://dars-scheduled.herokuapp.com/hello", String.class);
            log.info("Resultado da Chamada REST: " + resposta);
        }

    }
}
