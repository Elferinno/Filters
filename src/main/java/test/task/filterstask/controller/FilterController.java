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

//    @Autowired
//    public FilterController(FilterService filterService) {
//        this.filterService = filterService;
//    }

//    @GetMapping
//    public String a() {
//        return "a";
//    }

    @GetMapping
    public List<Filter> getAllFilters() {
        return filterService.getAllFilters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filter> getFilterById(@PathVariable Long id) {
        return filterService.getFilterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Filter createFilter(@RequestBody Filter filter) {
        return filterService.saveFilter(filter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilter(@PathVariable Long id) {
        filterService.deleteFilter(id);
        return ResponseEntity.noContent().build();
    }

}
