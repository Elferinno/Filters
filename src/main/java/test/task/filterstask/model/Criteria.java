package test.task.filterstask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.task.filterstask.util.CriteriaTypeDeserializer;


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
    @JsonDeserialize(using = CriteriaTypeDeserializer.class)
    @NotNull(message = "Type is required")
    private CriteriaType type; // e.g., "Amount", "Title", "Date"

    // stores condition relevant to the criteria type
    @NotEmpty(message = "Condition is required")
    private String condition;

    // user input
    //mby it should be different type, check what fe is sending here on different occasions
    @Column(name = "criteria_value")
    @NotEmpty(message = "Value is required")
    private String value;

    @ManyToOne
    @JoinColumn(name = "filter_id")
    @JsonBackReference
    private Filter filter;
}
