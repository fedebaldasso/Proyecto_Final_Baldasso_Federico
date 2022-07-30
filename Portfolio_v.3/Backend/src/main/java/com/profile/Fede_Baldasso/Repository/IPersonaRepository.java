/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.profile.Fede_Baldasso.Repository;

import com.profile.Fede_Baldasso.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

/**
 *
 * @author Fede
 */
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
}
