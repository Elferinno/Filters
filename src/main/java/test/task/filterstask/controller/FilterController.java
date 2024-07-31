package test.task.filterstask.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.filterstask.model.Filter;
import test.task.filterstask.service.FilterService;

import java.util.List;


@RestController
@RequestMapping("/api/filters")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @GetMapping
    public ResponseEntity<List<Filter>> getAllFilters() {
        List<Filter> filterList = filterService.getAllFilters();
        return ResponseEntity.ok(filterList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filter> getFilterById(@PathVariable Long id) {
        Filter filter = filterService.getFilterById(id);
        return new ResponseEntity<>(filter, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Filter> updateFilter(@Valid @PathVariable Long id, @RequestBody Filter filterDetails) {
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
    public ResponseEntity<?> createFilter(@Valid @RequestBody Filter filter) {
        Filter createdFilter = filterService.saveFilter(filter);
        return new ResponseEntity<>(createdFilter, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilter(@PathVariable Long id) {
        Filter filter = filterService.getFilterById(id);
        if (filter != null) {
            filterService.deleteFilter(id);
            return new ResponseEntity<>("Filter deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Filter not found", HttpStatus.NOT_FOUND);
        }
    }

}
