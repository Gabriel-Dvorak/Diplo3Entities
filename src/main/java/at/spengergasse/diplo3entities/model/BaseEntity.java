package at.spengergasse.diplo3entities.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

@MappedSuperclass
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Noch falsch
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (isTransistent()) {
            return false;
        }
        return Objects.equals(id, other.id);
    }

    public boolean isTransistent() {
        return id == null;
    }
}