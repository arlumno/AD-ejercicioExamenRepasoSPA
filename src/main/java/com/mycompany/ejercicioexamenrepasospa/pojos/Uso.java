package com.mycompany.ejercicioexamenrepasospa.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a20armandocb
 */
public class Uso {
    private Actividad actividad;
    private String nombreActividad;
    private Socio socio;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int horasUso;
    private float importe = 3;


    public Uso(String nombreActividad, Actividad actividad, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.nombreActividad = nombreActividad;
        this.actividad = actividad;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.socio = null;
        calcularHorasUso();
        calcularImporte();
    }
    public Uso(String nombreActividad, Actividad actividad, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Socio socio) {
        this.nombreActividad = nombreActividad;
        this.actividad = actividad;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.socio = socio;
        calcularHorasUso();
        calcularImporte();
    }
    /**
     * @return the actividad
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * @param actividad the actividad to set
     */
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    /**
     * @return the nombreActividad
     */
    public String getNombreActividad() {
        return nombreActividad;
    }

    /**
     * @param nombreActividad the nombreActividad to set
     */
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    /**
     * @return the socio
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horaInicio
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * @return the importe
     */
    public float getImporte() {
        calcularImporte();
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }
    

    /**
     * @return the importe
     */
    public int getHorasUso() {
        calcularHorasUso();
        return horasUso;
    }
    
    /**
     * @param importe the importe to set
     */
    
    public void calcularHorasUso() {
        horasUso = (horaFin.toSecondOfDay() -horaInicio.toSecondOfDay())/3600;
    }
    
    /**
     * @param importe the importe to set
     */
    public void calcularImporte() {      
        importe = actividad.getCuota()*horasUso;
    }

    @Override
    public String toString() {
        return "Uso{" + "actividad=" + actividad + ", nombreActividad=" + getNombreActividad() + ", socio=" + getSocio() + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", horasUso=" + horasUso + ", importe=" + importe + '}';
    }
    public String toStringFacturar() {
        return getNombreActividad() + " (" + fecha + ") de " + horaInicio + " a " + horaFin + "  importe=" + importe + " €";
    }
    
}
