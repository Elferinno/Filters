package test.task.filterstask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import test.task.filterstask.util.CriteriaTypeDeserializer;


@Data
@Entity
@Table(name = "criteria")
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "criteria_type")
    @Enumerated(EnumType.STRING)
    @JsonDeserialize(using = CriteriaTypeDeserializer.class)
    @NotNull(message = "Type is required")
    private CriteriaType type; // e.g., "Amount", "Title", "Date"

    // stores condition relevant to the criteria type
    @NotBlank(message = "Condition is required")
    private String condition;

    // stores user input
    @Column(name = "criteria_value")
    @NotBlank(message = "Value is required")
    private String value;

    @ManyToOne
    @JoinColumn(name = "filter_id")
    @JsonBackReference
    private Filter filter;
}
