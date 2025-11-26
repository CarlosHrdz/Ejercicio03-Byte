package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Empresa;
import com.example.demo.service.EmpresaService;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Empresa> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Empresa getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Empresa create(@Valid @RequestBody Empresa empresa) {
        return service.create(empresa);
    }

    @PutMapping("/{id}")
    public Empresa update(@PathVariable Long id, @Valid @RequestBody Empresa empresa) {
        return service.update(id, empresa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<Empresa> search(@RequestParam String nombre) {
        return service.searchByNombre(nombre);
    }
}