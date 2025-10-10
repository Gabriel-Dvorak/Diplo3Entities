package at.spengergasse.diplo3entities.model;

import at.spengergasse.diplo3entities.myValueObjects.Title;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Getter
@ToString
public class Event extends BaseEntity {
    @Column(name = "title", unique = false, nullable = false, length = 100)
    @NotBlank @Size(max = 100)
    private Title title;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    public Event() {
        super();
    }

    public Event(Title title, LocalDateTime startTime, LocalDateTime endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;

        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("EndTime must be after StartTime");
        }
    }
}