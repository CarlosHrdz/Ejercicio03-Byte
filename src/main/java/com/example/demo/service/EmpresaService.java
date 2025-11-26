package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Empresa;
import com.example.demo.repository.EmpresaRepository;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;
    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> findAll() {
        return repository.findAll();
    }

    public Empresa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
    }

    public Empresa create(Empresa empresa) {
        return repository.save(empresa);
    }

    public Empresa update(Long id, Empresa nueva) {
        Empresa e = findById(id);
        if (e == null) {
            throw new RuntimeException("Empresa no existe");
        }

        e.setNombre(nueva.getNombre());
        e.setNit(nueva.getNit());
        e.setFechaFundacion(nueva.getFechaFundacion());
        e.setDireccion(nueva.getDireccion());

        return repository.save(e);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Empresa no existe");
        }
        
        repository.deleteById(id);
    }

    public List<Empresa> searchByNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}