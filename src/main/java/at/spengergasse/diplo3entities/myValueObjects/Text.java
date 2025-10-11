package at.spengergasse.diplo3entities.myValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;

import static at.spengergasse.diplo3entities.validation.Guard.textLength;

@Embeddable
public class Text {
    public static final int MAX_LEN = 1000;
    public static final String MAX_LEN_MSG = "Text should be between 1..1000 chars";

    @Column(name = "text", nullable = false, length = MAX_LEN)
    private String text;

    protected Text() {}

    public Text(String text) {this.text = textLength(text, MAX_LEN, MAX_LEN_MSG);}
}
