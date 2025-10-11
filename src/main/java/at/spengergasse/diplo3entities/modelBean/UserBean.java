package at.spengergasse.diplo3entities.modelBean;

import at.spengergasse.diplo3entities.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_bean")
@Getter
@ToString
@NoArgsConstructor
public class UserBean extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false, length = 100)
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1, max = 100, message = "Name should be between 1 and 100 characters")
    private String name;

    @Column(name = "password", nullable = false, length = 20)
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 12, max = 20, message = "Password should be between 12 and 20 characters")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit"
    )
    private String password;

    @Column(name = "has_rights", nullable = false)
    private boolean hasRights;

    public UserBean(String name, String password, boolean hasRights) {
        super();
        this.name = name;
        this.password = password;
        this.hasRights = hasRights;
    }
}