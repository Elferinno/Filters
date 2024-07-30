package test.task.filterstask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.filterstask.model.Criteria;
import test.task.filterstask.service.CriteriaService;

import java.util.List;

@RestController
@RequestMapping("/api/criteria")
public class CriteriaController {

    @Autowired
    private CriteriaService criteriaService;

    @PostMapping
    public ResponseEntity<Criteria> createCriteria(@RequestBody Criteria criteria) {
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

    //output 200 on success
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCriteria(@PathVariable Long id) {
        Criteria criteria = criteriaService.getCriteriaById(id);
        if (criteria != null) {
            criteriaService.deleteCriteria(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}