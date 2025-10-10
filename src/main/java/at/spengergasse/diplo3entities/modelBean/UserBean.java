package at.spengergasse.diplo3entities.modelBean;

import at.spengergasse.diplo3entities.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "userBean")
@Getter
@ToString
public class UserBean extends BaseEntity {
    @Column(name = "name", unique = true, nullable = false, length = 100)
    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(name = "passwort", unique = false, nullable = false, length = 20)
    @NotBlank @Size(max = 20, min = 12)
    private String passwort;

    @Column(name = "hasRights", unique = false, nullable = false)
    private boolean hasRights;

    protected UserBean() {}

    public UserBean(String name, String passwort, boolean hasRights) {
        this.name = name;
        this.passwort = passwort;
        this.hasRights = hasRights;
    }

    @Override
    public void setHasRights(boolean hasRights) {
        this.hasRights = hasRights;
    }
}
