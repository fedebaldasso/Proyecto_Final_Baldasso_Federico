/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profile.Fede_Baldasso.Service;

import com.profile.Fede_Baldasso.Entity.Persona;
import com.profile.Fede_Baldasso.Interface.IPersonaService;
import com.profile.Fede_Baldasso.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

/**
 *
 * @author Fede
 */
public class ImpPersonaService implements IPersonaService {
    
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {       
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    /**
     *
     * @param id
     * @return 
     */
    @Override
    public Persona deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
        Persona persona = null;
        return persona;
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
}
