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
public class INVENTARIO {

    private int id;
    private String NombreCorto;
    private String Descripcion;
    private String Serie;
    private String Color;
    private String Fecha_Adquision;
    private String Tipo_Adquision;
    private String Observaciones;

    public INVENTARIO() {
    }

    public INVENTARIO(String NombreCorto, String Descripcion, String Serie, String Color, String Fecha_Adquision, String Tipo_Adquision, String Observaciones) {
        this.NombreCorto = NombreCorto;
        this.Descripcion = Descripcion;
        this.Serie = Serie;
        this.Color = Color;
        this.Fecha_Adquision = Fecha_Adquision;
        this.Tipo_Adquision = Tipo_Adquision;
        this.Observaciones = Observaciones;
    }

    public INVENTARIO(int id, String NombreCorto, String Descripcion, String Serie, String Color, String Fecha_Adquision, String Tipo_Adquision, String Observaciones) {
        this.id = id;
        this.NombreCorto = NombreCorto;
        this.Descripcion = Descripcion;
        this.Serie = Serie;
        this.Color = Color;
        this.Fecha_Adquision = Fecha_Adquision;
        this.Tipo_Adquision = Tipo_Adquision;
        this.Observaciones = Observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCorto() {
        return NombreCorto;
    }

    public void setNombreCorto(String NombreCorto) {
        this.NombreCorto = NombreCorto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getFecha_Adquision() {
        return Fecha_Adquision;
    }

    public void setFecha_Adquision(String Fecha_Adquision) {
        this.Fecha_Adquision = Fecha_Adquision;
    }

    public String getTipo_Adquision() {
        return Tipo_Adquision;
    }

    public void setTipo_Adquision(String Tipo_Adquision) {
        this.Tipo_Adquision = Tipo_Adquision;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    
}

