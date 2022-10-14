package ru.kataproject.p_sm_airlines_1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "Aircraft")
public class Aircraft implements Serializable {
    //Характеристики: id, бортовой номер, марка, модель, год выпуска, конфигурация салона (места), дальность полёта.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String PNR;  // бортовой номер

    private String stamp; // марка

    @Column(name = "model", unique = true, nullable = false)
    private String model;

    private int yearOfRelease; // год выпуска

    private long seat; // место (Подумать как связать к классом - эконом/бизнес)

    public Aircraft() {

    }
    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", PNR='" + PNR + '\'' +
                ", stamp='" + stamp + '\'' +
                ", model='" + model + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", seat='" + seat + '\'' +
                '}';
    }
}
