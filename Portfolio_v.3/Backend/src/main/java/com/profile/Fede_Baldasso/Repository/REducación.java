/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.profile.Fede_Baldasso.Repository;

import com.profile.Fede_Baldasso.Entity.Educación;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fede
 */
@Repository
public interface REducación extends JpaRepository<Educación, Integer>{
    
    public Optional<Educación> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}
