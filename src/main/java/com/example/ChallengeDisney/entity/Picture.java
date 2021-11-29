package com.example.ChallengeDisney.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Enzo sosa
 */
@Entity
@Data
public class Picture implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String picture_id;

    private String mime;
    private String name;

    @Lob //la anotacion @Lob permite indicarle a JPA que este campo/atributo va a ser un objeto pesado para tratarlo como tal y manejarlo con Byte, ya que permite almacenar cualquier cosa.
    @Basic(fetch = LAZY) // @Basic permite controlar el momento en que una propiedad es cargada desde la base de datos, evitando no traer valores que no son necesarios mientras se carga el objeto.
    private byte[] contenido;            //@Basic solo se usa cuando un objeto va a ser pesado,en este caso se cargaran imagenes.

}
