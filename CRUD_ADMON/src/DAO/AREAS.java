/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Guillermo Mata
 */
public class AREAS {

    private int id;
    private String Nombre;
    private String Ubicacion;

    public AREAS() {
    }

    public AREAS(String Nombre, String Ubicacion) {
        this.Nombre = Nombre;
        this.Ubicacion = Ubicacion;
    }

    public AREAS(int id, String Nombre, String Ubicacion) {
        this.id = id;
        this.Nombre = Nombre;
        this.Ubicacion = Ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    
}

