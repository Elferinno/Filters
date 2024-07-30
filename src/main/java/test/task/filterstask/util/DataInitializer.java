package test.task.filterstask.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.task.filterstask.model.Criteria;
import test.task.filterstask.model.Filter;
import test.task.filterstask.repository.CriteriaRepository;
import test.task.filterstask.repository.FilterRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(FilterRepository filterRepository, CriteriaRepository criteriaRepository) {
        return args -> {
            Filter filter1 = new Filter();
            filter1.setName("Filter 1");
            filter1 = filterRepository.save(filter1);

            Filter filter2 = new Filter();
            filter2.setName("Filter 2");
            filter2 = filterRepository.save(filter2);

            Criteria criteria1 = new Criteria();
            criteria1.setType("Amount");
            criteria1.setValue("100");
            criteria1.setFilter(filter1);
            criteriaRepository.save(criteria1);

            Criteria criteria2 = new Criteria();
            criteria2.setType("Title");
            criteria2.setValue("Sample Title");
            criteria2.setFilter(filter1);
            criteriaRepository.save(criteria2);

            Criteria criteria3 = new Criteria();
            criteria3.setType("Date");
            criteria3.setValue("2024-07-29");
            criteria3.setFilter(filter2);
            criteriaRepository.save(criteria3);
        };
    }
}
