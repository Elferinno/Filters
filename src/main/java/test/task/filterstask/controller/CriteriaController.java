package test.task.filterstask.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import test.task.filterstask.model.Criteria;
import test.task.filterstask.model.CriteriaType;
import test.task.filterstask.service.CriteriaService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/criteria")
public class CriteriaController {

    @Autowired
    private CriteriaService criteriaService;

    @PostMapping
    public ResponseEntity<Criteria> createCriteria(@Valid @RequestBody Criteria criteria) {
        Criteria savedCriteria = criteriaService.saveCriteria(criteria);
        return new ResponseEntity<>(savedCriteria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Criteria>> getAllCriteria() {
        List<Criteria> criteriaList = criteriaService.getAllCriteria();
        return new ResponseEntity<>(criteriaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Criteria> getCriteriaById(@PathVariable Long id) {
        Criteria criteria = criteriaService.getCriteriaById(id);
        if (criteria != null) {
            return new ResponseEntity<>(criteria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("/types")
    public ResponseEntity<List<CriteriaType>> getCriteriaTypes() {
        return ResponseEntity.ok(Arrays.asList(CriteriaType.values()));
    }

    @GetMapping("/amountConditions")
    public ResponseEntity<List<String>> getAmountConditions() {
        return ResponseEntity.ok(Arrays.asList("MORE", "LESS", "EQUAL"));
    }

    @GetMapping("/titleConditions")
    public ResponseEntity<List<String>> getTitleConditions() {
        return ResponseEntity.ok(Arrays.asList("CONTAINS", "STARTS_WITH", "ENDS_WITH"));
    }

    @GetMapping("/dateConditions")
    public ResponseEntity<List<String>> getDateConditions() {
        return ResponseEntity.ok(Arrays.asList("BEFORE", "AFTER", "ON"));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
