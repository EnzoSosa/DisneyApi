package com.example.ChallengeDisney.service;

import com.example.ChallengeDisney.entity.MovieAndSerie;
import com.example.ChallengeDisney.entity.Picture;
import com.example.ChallengeDisney.repository.MovieAndSerieRepository;
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
public class MovieAndSerieService {

    @Autowired
    private MovieAndSerieRepository mr;

    @Autowired
    private PictureService ps;

    @Transactional
    public MovieAndSerie createMovie(MovieAndSerie m, MultipartFile image) {

        Picture p = ps.save(image);
        m.setPicture(p);

        return mr.save(m);
    }

    @Transactional
    public void upgradeMovie(MovieAndSerie m, MultipartFile image) {

        MovieAndSerie mv = mr.findById(m.getMovie_id()).get();

        if (mv != null) {
            m = mv;
            createMovie(m, image);

        }

    }

    @Transactional
    public List<MovieAndSerie> listAllMovie() {

        return mr.findAll();

    }

    @Transactional
    public void deleteMovie(String id) {

        Optional<MovieAndSerie> mop = mr.findById(id);

        if (mop.isPresent()) {

            mr.delete(mop.get());
        }

    }

}
