/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ChallengeDisney.repository;

import com.example.ChallengeDisney.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ensos
 */
public interface PictureRepository extends JpaRepository<Picture, String> {
    
}
