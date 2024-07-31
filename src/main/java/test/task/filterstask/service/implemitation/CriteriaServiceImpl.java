package test.task.filterstask.service.implemitation;

        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Service;
        import test.task.filterstask.model.Criteria;
        import test.task.filterstask.repository.CriteriaRepository;
        import test.task.filterstask.service.CriteriaService;
        import java.util.List;
        import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CriteriaServiceImpl implements CriteriaService {

    private final CriteriaRepository criteriaRepository;

    @Override
    public Criteria saveCriteria(Criteria criteria) {
        return criteriaRepository.save(criteria);
    }

    @Override
    public List<Criteria> getAllCriteria() {
        return criteriaRepository.findAll();
    }

    @Override
    public Criteria getCriteriaById(Long id) {
        return criteriaRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteCriteria(Long id) {
        criteriaRepository.deleteById(id);
    }
}
