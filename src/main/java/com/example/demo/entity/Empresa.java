package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "empresas", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nit")
})
@Data
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100)
    private String nombre;

    @NotBlank(message = "El NIT es obligatorio")
    @Size(min = 5, max = 20)
    private String nit;

    @PastOrPresent(message = "La fecha debe ser pasada o hoy")
    private LocalDate fechaFundacion;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
}