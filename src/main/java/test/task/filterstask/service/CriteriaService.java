package test.task.filterstask.service;

import test.task.filterstask.model.Criteria;

import java.util.List;

public interface CriteriaService {
    Criteria saveCriteria(Criteria criteria);
    List<Criteria> getAllCriteria();
    Criteria getCriteriaById(Long id);
    void deleteCriteria(Long id);
}
