package test.task.filterstask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "criteria_type")
    @Enumerated(EnumType.STRING)
    private CriteriaType type; // e.g., "Amount", "Title", "Date"

    // stores condition relevant to the criteria type
    private String condition;

    // user input
    @Column(name = "criteria_value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "filter_id")
    @JsonBackReference
    private Filter filter;
}
