package test.task.filterstask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.filterstask.model.Filter;
import test.task.filterstask.repository.FilterRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FilterService {

//    private List<Filter> filterList;
//
//    public FilterService() {
//        filterList = new ArrayList<>();
//
//        Filter f1 = new Filter(1L, "first", new ArrayList<>());
//        Filter f2 = new Filter(2L, "second", new ArrayList<>());
//
//        filterList.addAll(Arrays.asList(f1, f2));
//    }
    @Autowired
    private FilterRepository filterRepository;

    public List<Filter> getAllFilters() {
//        new FilterService();
//        return  filterList;
        return filterRepository.findAll();
    }

    public Filter saveFilter(Filter filter) {
        return filterRepository.save(filter);
    }

    public Optional<Filter> getFilterById(Long id) {
        return filterRepository.findById(id);
    }

    public void deleteFilter(Long id) {
        filterRepository.deleteById(id);
    }
}
