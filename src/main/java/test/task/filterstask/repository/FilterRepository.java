package test.task.filterstask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.task.filterstask.model.Filter;

public interface FilterRepository extends JpaRepository<Filter, Long> {
}

