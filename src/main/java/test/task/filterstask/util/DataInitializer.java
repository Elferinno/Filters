package test.task.filterstask.util;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.task.filterstask.model.Criteria;
import test.task.filterstask.model.CriteriaType;
import test.task.filterstask.model.Filter;
import test.task.filterstask.repository.CriteriaRepository;
import test.task.filterstask.repository.FilterRepository;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    @Transactional
    public CommandLineRunner initData(FilterRepository filterRepository, CriteriaRepository criteriaRepository) {
        return args -> {
            Filter filter1 = new Filter();
            filter1.setName("Filter 1");

            Criteria criteria1 = new Criteria();
            criteria1.setType(CriteriaType.AMOUNT);
            criteria1.setValue("100");
            criteria1.setCondition("MORE");
            criteria1.setFilter(filter1);
            filter1.setCriteriaList(List.of(criteria1));

            Criteria criteria2 = new Criteria();
            criteria2.setType(CriteriaType.TITLE);
            criteria2.setValue("Sample Title");
            criteria2.setCondition("CONTAINS");
            criteria2.setFilter(filter1);

            filter1.setCriteriaList(List.of(criteria1, criteria2));
            filterRepository.save(filter1);
            criteriaRepository.save(criteria1);
            criteriaRepository.save(criteria2);

            Filter filter2 = new Filter();
            filter2.setName("Filter 2");

            Criteria criteria3 = new Criteria();
            criteria3.setType(CriteriaType.DATE);
            criteria3.setValue("2024-07-29");
            criteria3.setCondition("BEFORE");
            criteria3.setFilter(filter2);

            filter2.setCriteriaList(List.of(criteria3));
            filterRepository.save(filter2);
            criteriaRepository.save(criteria3);
        };
    }
}