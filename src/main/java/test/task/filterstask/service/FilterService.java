package test.task.filterstask.service;

import test.task.filterstask.model.Filter;

import java.util.List;

public interface FilterService {
    Filter saveFilter(Filter filter);

    List<Filter> getAllFilters();

    Filter getFilterById(Long id);

    void deleteFilter(Long id);
}
