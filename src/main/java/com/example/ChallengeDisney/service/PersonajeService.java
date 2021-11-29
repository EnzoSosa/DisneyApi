package com.example.ChallengeDisney.service;

import com.example.ChallengeDisney.entity.Personaje;
import com.example.ChallengeDisney.entity.Picture;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.ChallengeDisney.repository.PersonajeRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Enzo sosa
 */
@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository pr;

    @Autowired
    private PictureService ps;

    @Transactional                           //c= character→personaje en ingles
    public Personaje createPersonaje(Personaje c, MultipartFile image) {

        Picture p = ps.save(image);
        c.setPicture(p);
        return null;
    }

    @Transactional
    public void upgradePersonaje(Personaje p, MultipartFile image) {
        Personaje pe = pr.findById(p.getPersonaje_Id()).get();

        if (pe != null) {
            p = pe;
            createPersonaje(p, image);
        }

    }

    @Transactional
    public List<Personaje> listAllPersonaje() {

        return pr.findAll();

    }

    @Transactional
    public void deletePersonaje(String id) {

        Optional<Personaje> answer = pr.findById(id);

        if (answer.isPresent()) {
            pr.delete(answer.get());

        }

    }
}
