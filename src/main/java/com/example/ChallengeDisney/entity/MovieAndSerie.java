package com.example.ChallengeDisney.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Enzo sosa
 */
@Entity
@Data
public class MovieAndSerie implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String movie_id;

    @Lob
    @Basic(fetch = LAZY)
    @OneToOne
    private Picture picture;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;

    @Column(nullable = false)
    private Integer qualification; //hacer un metodo para calificar del 1 a 5

}
