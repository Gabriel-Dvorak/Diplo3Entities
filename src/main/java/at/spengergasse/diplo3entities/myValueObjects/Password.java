package at.spengergasse.diplo3entities.myValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import static at.spengergasse.diplo3entities.validation.Guard.validatePassword;

@Embeddable
public class Password {
    public static final int MAX_LEN = 20;
    public static final String MAXMIN_LEN_MSG = "Password should be between 12 and 20 characters";
    public static final int MIN_LEN = 12;

    @Column(name = "password", nullable = false, length = MAX_LEN)
    private String password;

    protected Password() {}

    public Password(String password) {
        this.password = validatePassword(password, MIN_LEN, MAX_LEN, MAXMIN_LEN_MSG);
    }
}
