package test.task.filterstask.util;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;
import test.task.filterstask.model.Filter;
import test.task.filterstask.repository.FilterRepository;
import org.springframework.context.event.EventListener;

@Component
public class DataInitializer {
    @Autowired
    private FilterRepository filterRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Filter filter1 = new Filter();
        filter1.setName("Filter 1");
        filterRepository.save(filter1);

        Filter filter2 = new Filter();
        filter2.setName("Filter 2");
        filterRepository.save(filter2);
    }
}
