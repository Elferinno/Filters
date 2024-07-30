package test.task.filterstask.service.Implemitation;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import test.task.filterstask.model.Criteria;
        import test.task.filterstask.repository.CriteriaRepository;
        import test.task.filterstask.service.CriteriaService;

        import java.util.List;
        import java.util.Optional;

@Service
public class CriteriaServiceImpl implements CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;

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
        Optional<Criteria> criteria = criteriaRepository.findById(id);
        return criteria.orElse(null);
    }

    @Override
    public void deleteCriteria(Long id) {
        criteriaRepository.deleteById(id);
    }
}
