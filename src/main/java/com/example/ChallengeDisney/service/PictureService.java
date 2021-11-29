package com.example.ChallengeDisney.service;

import com.example.ChallengeDisney.entity.Picture;
import com.example.ChallengeDisney.repository.PictureRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

/**
 *
 * @author Enzo sosa
 */
@Service
public class PictureService {
    
    @Autowired
    private PictureRepository pr;
    
    @Transactional
    public Picture save(MultipartFile file) {
        
        if (file.isEmpty() || file != null) {
            try {
                Picture p = new Picture();
                p.setMime(file.getContentType());
                p.setName(file.getName());
                p.setContenido(file.getBytes());
            } catch (Exception e) {
                System.err.println(e.getMessage());
                
            }
            
        }
        return null;
    }
    
    @Transactional
    public Picture upgrade(@RequestParam String picture_Id, MultipartFile file) {
        
        if (file != null) {
            
            try {
                Picture p = new Picture();
                if (picture_Id != null) {
                    Optional<Picture> answer = pr.findById(picture_Id);
                    if (answer.isPresent()) {
                        p = answer.get();
                    }
                }
                p.setMime(file.getContentType());
                p.setName(file.getName());
                p.setContenido(file.getBytes());
                
                return pr.save(p);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    
    @Transactional
    public void delete(Picture p) {
        pr.delete(p); 
    }
    
}
