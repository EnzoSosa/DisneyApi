package com.example.ChallengeDisney.service;

import com.example.ChallengeDisney.entity.Picture;
import com.example.ChallengeDisney.entity.UserName;
import com.example.ChallengeDisney.repository.UsernameRepository;
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
public class UserNameService {
    
    @Autowired
    private UsernameRepository ur;
    
    @Autowired
    private PictureService ps;
    
    @Transactional
    public UserName createUser(UserName u, MultipartFile image) {
        
        Picture p = ps.save(image);
        u.setPicture(p);
        
        return ur.save(u);
        
    }
    
    @Transactional
    public void upgradeUser(UserName u, MultipartFile image) {
        
        UserName us = ur.findById(u.getUser_Id()).get();
        
        if (us != null) {
            
            u = us;
            
            createUser(u, image);
            
        }
        
    }
    
    @Transactional
    public List<UserName> listAllUser() {
        
        return ur.findAll();
        
    }
    
    @Transactional
    public void deleteUser(String id) {
        
        Optional<UserName> uop = ur.findById(id);
        
        if (uop.isPresent()) {
            
            ur.delete(uop.get());
            
        }
    }
    
}
