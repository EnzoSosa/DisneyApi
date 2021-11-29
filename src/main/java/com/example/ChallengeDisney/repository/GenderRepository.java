/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ChallengeDisney.repository;

import com.example.ChallengeDisney.entity.Gender;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ensos
 */
public interface GenderRepository extends JpaRepository< Gender, String> {

    @Query("SELECT j FROM Genero j WHERE j.genero LIKE :q")
    List<Gender> findAll(@Param("q") String q);
}
