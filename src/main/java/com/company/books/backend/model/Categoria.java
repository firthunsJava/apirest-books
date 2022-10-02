package com.company.books.backend.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="categorias")
public class Categoria implements Serializable {
    /**id generado automaticamente tras apretar previamente a la bombilla aparecia en el margen
     *
     */

    private static final long serialVersionUID = -2164553723990982332L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripion() {
        return descripcion;
    }

    public void setDescripion(String descripion) {
        this.descripcion = descripion;

    }

}