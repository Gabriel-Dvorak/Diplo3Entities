package at.spengergasse.diplo3entities.myValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import static at.spengergasse.diplo3entities.validation.Guard.checkMinMax;

@Embeddable
public class Capacity {
    public static final int MAX_LEN = 50;
    public static final int Min_LEN = 1;
    public static final String MAX_LEN_MSG = "Capacity can only be 1..50.";

    @Column(name = "capacity", nullable = false)
    private int capacity;

    protected Capacity() {}

    public Capacity(int capacity) {this.capacity = checkMinMax(capacity, Min_LEN, MAX_LEN, MAX_LEN_MSG);}
}