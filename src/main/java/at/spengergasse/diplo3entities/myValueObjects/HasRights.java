package at.spengergasse.diplo3entities.myValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class HasRights {
    @Column(name = "has_rights", nullable = false)
    private boolean hasRights;

    protected HasRights() {} // für JPA

    public HasRights(boolean hasRights) {
        this.hasRights = hasRights;
    }
}
