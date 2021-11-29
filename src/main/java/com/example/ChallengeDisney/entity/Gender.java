package com.example.ChallengeDisney.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Enzo sosa
 */
@Entity
@Data
public class Gender implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String gender_Id;

    @Column(nullable = false)
    private String name;

    @Lob
    @Basic
    @Column(nullable = false)
    @OneToOne
    private Picture picture;

}
