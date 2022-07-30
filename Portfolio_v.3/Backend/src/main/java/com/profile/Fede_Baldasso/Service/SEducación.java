/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profile.Fede_Baldasso.Service;

import com.profile.Fede_Baldasso.Entity.Educación;
import com.profile.Fede_Baldasso.Repository.REducación;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fede
 */
@Service
@Transactional
public class SEducación {
    @Autowired
    REducación rEducación;

    public List<Educación> list(){
        return rEducación.findAll();
    }

    public Optional<Educación> getOne(int id){
        return rEducación.findById(id);
    }

    public Optional<Educación> getByNmbreE(String nombreE){
        return rEducación.findByNombreE(nombreE);
    }

    public void save(Educación educación){
        rEducación.save(educación);
    }

    public void delete(int id){
        rEducación.deleteById(id);
    }

    public boolean existsById(int id){
        return rEducación.existsById(id);
    }

    public boolean existsByNombreE(String nombreE){
        return rEducación.existsByNombreE(nombreE);
    }
    
}
