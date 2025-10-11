package at.spengergasse.diplo3entities.modelBean;

import at.spengergasse.diplo3entities.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "event_bean")
@Getter
@ToString
@NoArgsConstructor
public class EventBean extends BaseEntity {

    @Column(name = "title", nullable = false, length = 100)
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;

    @Column(name = "capacity", nullable = false)
    @Min(value = 1, message = "Capacity must be at least 1")
    @Max(value = 50, message = "Capacity must be at most 50")
    private int capacity;

    @Column(name = "description", nullable = false, length = 500)
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 1, max = 500, message = "Description must be between 1 and 500 characters")
    private String description;

    public EventBean(String title, int capacity, String description) {
        super();
        this.title = title;
        this.capacity = capacity;
        this.description = description;
    }
}