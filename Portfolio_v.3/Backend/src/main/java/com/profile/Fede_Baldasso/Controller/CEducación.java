/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profile.Fede_Baldasso.Controller;

import com.profile.Fede_Baldasso.Dto.dtoEducación;
import com.profile.Fede_Baldasso.Entity.Educación;
import com.profile.Fede_Baldasso.Security.Controller.Mensaje;
import com.profile.Fede_Baldasso.Service.SEducación;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fede
 */
@RestController
@RequestMapping("/educación")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducación {
    @Autowired
    SEducación sEducación;

    @GetMapping("/lista")
    public ResponseEntity<List<Educación>> list(){
        List<Educación> list = sEducación.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educación> getById(@PathVariable("id")int id){
        if(!sEducación.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Educación educación = sEducación.getOne(id).get();
        return new ResponseEntity(educación, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducación.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducación.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducación dtoeducación){
        if(StringUtils.isBlank(dtoeducación.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducación.existsByNombreE(dtoeducación.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educación educación = new Educación(
                dtoeducación.getNombreE(), dtoeducación.getDescripcionE()
            );
        sEducación.save(educación);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducación dtoeducación){
        if(!sEducación.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEducación.existsByNombreE(dtoeducación.getNombreE()) && sEducación.getByNmbreE(dtoeducación.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducación.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        Educación educación = sEducación.getOne(id).get();

        educación.setNombreE(dtoeducación.getNombreE());
        educación.setDescripcionE(dtoeducación.getDescripcionE());

        sEducación.save(educación);

        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
    }
    
}
