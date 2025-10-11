package at.spengergasse.diplo3entities.model;

import at.spengergasse.diplo3entities.myValueObjects.Capacity;
import at.spengergasse.diplo3entities.myValueObjects.Description;
import at.spengergasse.diplo3entities.myValueObjects.Title;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "event")
@Getter
@ToString
public class Event extends BaseEntity {
    @Column(name = "title", unique = false, nullable = false, length = 100)
    @NotBlank @Size(max = 100)
    private Title title;

    @Column(name = "capacity", nullable = false)
    private Capacity capacity;

    @Column(name = "description", unique = false, nullable = false, length = 500)
    private Description description;

    public Event() {
        super();
    }

    public Event(Title title, Capacity capacity, Description description) {
        this.title = title;
        this.capacity = capacity;
        this.description = description;
    }
}