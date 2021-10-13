package com.mycompany.ejercicioexamenrepasospa.pojos;

import java.util.ArrayList;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author a20armandocb
 */
public class Socio {

    private String codigo;
    private String nombre;
    private float cuotaFijaMensual;
//    private ArrayList<Uso> usos;

    public Socio(String codigo, String nombre, float cuotaFija) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuotaFijaMensual = cuotaFija;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cuotaFija
     */
    public float getCuotaFija() {
        return cuotaFijaMensual;
    }

    /**
     * @param cuotaFija the cuotaFija to set
     */
    public void setCuotaFija(float cuotaFija) {
        this.cuotaFijaMensual = cuotaFija;
    }

//    /**
//     * @return the usos
//     */
//    public ArrayList<Uso> getUsos() {
//        return usos;
//    }
//    /**
//     * @param usos the usos to set
//     */
//    public void setUsos(ArrayList<Uso> usos) {
//        this.usos = usos;
//    }
    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
       
        if (obj instanceof String && this.codigo.equals((String) obj)) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Socio other = (Socio) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "Socio{" + "codigo=" + codigo + ", nombre=" + nombre + ", cuotaFija=" + cuotaFija + ", usos=" + usos + '}';
        return "Socio{" + "codigo=" + codigo + ", nombre=" + nombre + ", cuotaFija=" + cuotaFijaMensual + '}';
    }

}
