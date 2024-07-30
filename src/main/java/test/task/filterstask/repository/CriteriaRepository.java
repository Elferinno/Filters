package test.task.filterstask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.task.filterstask.model.Criteria;

public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
}
