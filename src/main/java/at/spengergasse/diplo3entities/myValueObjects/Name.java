package at.spengergasse.diplo3entities.myValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import static at.spengergasse.diplo3entities.validation.Guard.textLength;

@Embeddable
public class Name {
    public static final int MAX_LEN = 100;
    public static final String MAX_LEN_MSG = "Name should be between 1..100 chars";

    @Column(name = "name", nullable = false, length = MAX_LEN)
    private String name;

    protected Name() {}

    public Name(String name) {
        this.name = textLength(name, MAX_LEN, MAX_LEN_MSG);
    }
}
