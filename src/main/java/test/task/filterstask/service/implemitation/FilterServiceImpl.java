package test.task.filterstask.service.implemitation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.filterstask.model.Filter;
import test.task.filterstask.repository.FilterRepository;
import test.task.filterstask.service.FilterService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final FilterRepository filterRepository;

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
        return filterRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteFilter(Long id) {
        filterRepository.deleteById(id);
    }
}
