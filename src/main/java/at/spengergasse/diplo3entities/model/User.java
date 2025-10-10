package at.spengergasse.diplo3entities.model;

import at.spengergasse.diplo3entities.myValueObjects.HasRights;
import at.spengergasse.diplo3entities.myValueObjects.Name;
import at.spengergasse.diplo3entities.myValueObjects.Password;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@ToString
public class User extends BaseEntity {
    @Column(name = "name", unique = true, nullable = false, length = 100)
    @NotBlank @Size(max = 100)
    private Name name;

    @Column(name = "passwort", unique = false, nullable = false, length = 20)
    @NotBlank @Size(max = 20, min = 12)
    private Password passwort;

    @Column(name = "hasRights", unique = false, nullable = false)
    private HasRights hasRights;

    protected User() {
        super();
    }

    public User(Name name, Password passwort, HasRights hasRights) {
        super();
        this.name = name;
        this.passwort = passwort;
        this.hasRights = hasRights;
    }
}
