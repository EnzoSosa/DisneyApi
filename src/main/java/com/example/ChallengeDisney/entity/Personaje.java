package com.example.ChallengeDisney.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Enzo sosa
 *
 * @Data esta etiqueta permite no poner los setter and getters,ya lo hace
 * automatico cuando agregamos una variable/atributo.
 *
 */
@Data
@Entity
public class Personaje implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String personaje_Id;

    @Column(nullable = false)
    private String name;//nombre

    @Column(nullable = false)
    private String age;//edad

    @Column(nullable = false)
    private String weight;//peso

    @Column(nullable = false)
    private String history;//historia

    @Lob
    @OneToOne
    @Basic
    @Column(nullable = false)
    private Picture picture;//fotografia/imagen

    @Column(nullable = false)
    @ManyToOne
    private MovieAndSerie movies;//peliculas-series

}
