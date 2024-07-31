package test.task.filterstask.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.filterstask.model.Criteria;
import test.task.filterstask.service.CriteriaService;

import java.util.List;

@RestController
@RequestMapping("/api/criteria")
@RequiredArgsConstructor

public class CriteriaController {

    private final CriteriaService criteriaService;

    @PostMapping
    public ResponseEntity<?> createCriteria(@Valid @RequestBody Criteria criteria) {
        Criteria savedCriteria = criteriaService.saveCriteria(criteria);
        return new ResponseEntity<>(savedCriteria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Criteria>> getAllCriteria() {
        List<Criteria> criteriaList = criteriaService.getAllCriteria();
        return ResponseEntity.ok(criteriaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Criteria> getCriteriaById(@PathVariable Long id) {
        Criteria criteria = criteriaService.getCriteriaById(id);
        return new ResponseEntity<>(criteria, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCriteria(@PathVariable Long id) {
        Criteria criteria = criteriaService.getCriteriaById(id);
        if (criteria != null) {
            criteriaService.deleteCriteria(id);
            return new ResponseEntity<>("Criteria deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Criteria not found", HttpStatus.NOT_FOUND);
        }
    }

}
