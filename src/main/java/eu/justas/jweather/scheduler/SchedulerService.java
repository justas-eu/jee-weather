package eu.justas.jweather.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class SchedulerService {

	private static final Logger log = LoggerFactory.getLogger(SchedulerService.class);

    @Autowired
    @Qualifier("weatherGetterWorker")
    private Worker weatherGetterWorker;

    @Scheduled(fixedRate=1800000)
    public void doSchedule() {

    	long startTime = System.currentTimeMillis();
    	log.debug("Started scheduled task.");
    	
    	weatherGetterWorker.work();
    	
		long processingTime = System.currentTimeMillis() - startTime;
		log.debug("End of scheduled task. \"weatherGetterWorker\" has completed work. In: " + processingTime + " ms.");
    }

}
