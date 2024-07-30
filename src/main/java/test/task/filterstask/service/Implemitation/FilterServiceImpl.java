package test.task.filterstask.service.Implemitation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.filterstask.model.Criteria;
import test.task.filterstask.model.Filter;
import test.task.filterstask.repository.CriteriaRepository;
import test.task.filterstask.repository.FilterRepository;
import test.task.filterstask.service.FilterService;

import java.util.List;
import java.util.Optional;

@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterRepository filterRepository;

    @Override
    public Filter saveFilter(Filter filter) {
        return filterRepository.save(filter);
    }

    @Override
    public List<Filter> getAllFilters() {
        return filterRepository.findAll();
    }

    @Override
    public Filter getFilterById(Long id) {
        Optional<Filter> filter = filterRepository.findById(id);
        return filter.orElse(null);
    }

    @Override
    public void deleteFilter(Long id) {
        filterRepository.deleteById(id);
    }
}
