package test.task.filterstask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.filterstask.model.Filter;
import test.task.filterstask.repository.FilterRepository;
import java.util.List;
import java.util.Optional;


public interface FilterService {
    Filter saveFilter(Filter filter);
    List<Filter> getAllFilters();
    Filter getFilterById(Long id);
    void deleteFilter(Long id);
}
