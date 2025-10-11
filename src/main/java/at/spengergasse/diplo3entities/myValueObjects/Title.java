package at.spengergasse.diplo3entities.myValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import static at.spengergasse.diplo3entities.validation.Guard.textLength;

@Embeddable
public class Title {
    public static final int MAX_LEN = 100;
    public static final String MAX_LEN_MSG = "Text should be between 1..100 chars";

    @Column(name = "title", nullable = false, length = MAX_LEN)
    private String title;

    protected Title() {}

    public Title(String title) {this.title = textLength(title, MAX_LEN, MAX_LEN_MSG);}
}