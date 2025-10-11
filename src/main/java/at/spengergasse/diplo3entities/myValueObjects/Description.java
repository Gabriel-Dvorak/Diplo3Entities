package at.spengergasse.diplo3entities.myValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import static at.spengergasse.diplo3entities.validation.Guard.textLength;

@Embeddable
public class Description {

    public static final int MAX_LEN = 500;
    public static final String MAX_LEN_MSG = "Description must be 1..500 chars";

    @Column(name = "description", nullable = false, length = MAX_LEN)
    private String description;

    protected Description() {}

    public Description(String description) {
        this.description = textLength(description, 1, MAX_LEN, MAX_LEN_MSG);
    }

    public String getDescription() {
        return description;
    }
}