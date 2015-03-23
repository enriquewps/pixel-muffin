/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.service.impl;

import java.util.List;
import mx.unam.ciencias.repository.LocalRepository;
import mx.unam.ciencias.model.Local;
import mx.unam.ciencias.model.Menu;
import mx.unam.ciencias.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author guillermorojas
 */
public class LocalServiceImpl implements LocalService{
    
    @Autowired
    private  LocalRepository localRepository;
    
        
    @Override
    public void guardaLocal(Local local) {
        for(Menu menu:local.getMenu()){
            menu.setLocal(local);
        }
        localRepository.save(local);
    }

    @Override
    public void eliminarLocal(Local local) {
        localRepository.delete(local);
    }

    @Override
    public List<Local> findAll() {
        return localRepository.findAll();
    }

    @Override
    public List<Local> findByNombre(String nombre) {
        return localRepository.findByNombre(nombre);
    }

    @Override
    public List<Local> findByCategoria(String categoria) {
       return localRepository.findByCategoria(categoria);
    }
    
     @Override
    public List<Local> findByMenu(String nombreMenu) {
       return localRepository.findByNombreMenu(nombreMenu);
    }

}
