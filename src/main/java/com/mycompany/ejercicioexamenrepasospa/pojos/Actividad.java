package com.mycompany.ejercicioexamenrepasospa.pojos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a20armandocb
 */
public class Actividad {
    private String tipo;
    private float cuota;

    public Actividad(String tipo, float cuota) {
        this.tipo = tipo;
        this.cuota = cuota;
    }
    
    

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cuota
     */
    public float getCuota() {
        return cuota;
    }

    /**
     * @param cuota the cuota to set
     */
    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        return "Actividad{" + "tipo=" + tipo + ", cuota=" + cuota + '}';
    }
    
    
}
