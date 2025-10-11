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

    // Fallback-ID -> Einmalig beim Hasch, Vorteil Transiente Objekte behalten ihren Hasch, Stabil für Callections
    private transient int systemHashCode = super.hashCode();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : systemHashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (isTransistent() /*|| other.isTransistent()*/) { // Other check in dem Fall hinfällig, da der Check einseitig problemlos funktioniert. Weil man kann ja einen Check durchführen, wenn man selbst zumindest nicht null ist.
            return false;
        }
        return Objects.equals(id, other.id);
    }

    public boolean isTransistent() {
        return id == null;
    }
}