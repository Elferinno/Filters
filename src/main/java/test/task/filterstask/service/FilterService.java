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

//@Service
//public class FilterService {
//
//    @Autowired
//    private FilterRepository filterRepository;
//
//    public List<Filter> getAllFilters() {
//        return filterRepository.findAll();
//    }
//
//    public Filter saveFilter(Filter filter) {
//        return filterRepository.save(filter);
//    }
//
//    public Optional<Filter> getFilterById(Long id) {
//        return filterRepository.findById(id);
//    }
//
//    public void deleteFilter(Long id) {
//        filterRepository.deleteById(id);
//    }
//}
