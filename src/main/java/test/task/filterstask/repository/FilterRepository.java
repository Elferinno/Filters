package test.task.filterstask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.filterstask.model.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {
}
