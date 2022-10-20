package ru.kataproject.p_sm_airlines_1.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "aircraft")
public class Aircraft {
    //Характеристики: id, бортовой номер, марка, модель, год выпуска, конфигурация салона (места), дальность полёта.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "on_board_number")
    private String onBoardNumber;  // бортовой номер

    private String stamp; // марка

    @Column(name = "model", unique = true, nullable = false)
    private String model;

    @Column(name = "year_of_release")
    private int yearOfRelease; // год выпуска

    private long seat;

}
