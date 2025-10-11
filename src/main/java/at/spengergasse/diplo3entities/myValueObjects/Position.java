package at.spengergasse.diplo3entities.myValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import static at.spengergasse.diplo3entities.validation.Guard.checkMinMax;

@Embeddable
public class Position {
    public static final int MAX_LEN = 10;
    public static final int Min_LEN = 1;
    public static final String MAX_LEN_MSG = "Position can only be 1..10.";

    @Column(name = "position", nullable = false)
    private int position;

    protected Position() {}

    public Position(int position) {this.position = checkMinMax(position, Min_LEN, MAX_LEN, MAX_LEN_MSG);}
}