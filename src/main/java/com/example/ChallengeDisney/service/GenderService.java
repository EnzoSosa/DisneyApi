package com.example.ChallengeDisney.service;

import com.example.ChallengeDisney.entity.Gender;
import com.example.ChallengeDisney.entity.Picture;
import com.example.ChallengeDisney.repository.GenderRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

/**
 *
 * @author Enzo sosa
 */
@Service
public class GenderService {

    @Autowired
    private GenderRepository gr;

    @Autowired
    private PictureService ps;

    @Transactional
    public Gender createGender(Gender g, MultipartFile image) {

        Picture p = ps.save(image);//pido una imagen 
        g.setPicture(p);//seteo la imagen en el objeto
        return gr.save(g);//guardo la imagen en la BD + el formulario de genero

    }

    @Transactional
    public void upgradeGender(Gender g, MultipartFile image) {

        Gender ge = gr.findById(g.getGender_Id()).get();//busco si el genero existe

        if (ge != null) { //si es null,quiere decir que el genero no esta creado
            //si es distinto a null quiere decir que se encontro el id de genero para modificarlo

            g = ge; //digo que g=ge para que el genero encontrado por "ge" se guarde o se seleccione en "g"
            //para despues traer el metodo createGender y ya este seleccionado por asi decirlo
            createGender(g, image);

        }

    }

    @Transactional
    public List<Gender> listAllGender() {
        return gr.findAll();
    }

    @Transactional
    public List<Gender> listAll(String q) {
        return gr.findAll("%" + q + "%");
    }

    @Transactional
    public void deleteGender(String id) {
        Optional<Gender> g = gr.findById(id);
        if (g.isPresent()) {
            gr.delete(g.get());
        }
    }

}
