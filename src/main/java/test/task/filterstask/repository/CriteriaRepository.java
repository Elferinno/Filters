package test.task.filterstask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.filterstask.model.Criteria;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
}
