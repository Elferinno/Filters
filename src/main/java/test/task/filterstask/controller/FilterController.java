package test.task.filterstask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.filterstask.model.Filter;
import test.task.filterstask.service.FilterService;

import java.util.List;

@RestController
@RequestMapping("/api/filters")
public class FilterController {

    @Autowired
    private FilterService filterService;

    @GetMapping
    public ResponseEntity<List<Filter>> getAllFilters() {
        List<Filter> filters = filterService.getAllFilters();
        return ResponseEntity.ok(filters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filter> getFilterById(@PathVariable Long id) {
        Filter filter = filterService.getFilterById(id);
        if (filter != null) {
            return ResponseEntity.ok(filter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filter> updateFilter(@PathVariable Long id, @RequestBody Filter filterDetails) {
        Filter filter = filterService.getFilterById(id);
        if (filter != null) {
            filter.setName(filterDetails.getName());
            filter.setCriteriaList(filterDetails.getCriteriaList());
            Filter updatedFilter = filterService.saveFilter(filter);
            return ResponseEntity.ok(updatedFilter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Filter> createFilter(@RequestBody Filter filter) {
        Filter createdFilter = filterService.saveFilter(filter);
        return ResponseEntity.ok(createdFilter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilter(@PathVariable Long id) {
        Filter filter = filterService.getFilterById(id);
        if (filter != null) {
            filterService.deleteFilter(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
