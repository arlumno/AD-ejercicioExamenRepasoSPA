package com.mycompany.ejercicioexamenrepasospa.pojos;


import java.time.LocalDate;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a20armandocb
 */
public class Spa {
    private String cif;
    private String nombre;
    private ArrayList<Actividad> actividades = new ArrayList<Actividad>();
    private ArrayList<Socio> socios = new ArrayList<Socio>();
    private ArrayList<Uso> usos = new ArrayList<Uso>();
    public static int contadorCodigos = 1;

    public Spa(String CIF, String nombre) {
        this.cif = CIF;
        this.nombre = nombre;
    }
    
    

    /**
     * @return the CIF
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the CIF to set
     */
    public void setCif(String cif) {
        this.cif = cif;
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
     * @return the actividades
     */
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    /**
     * @return the socios
     */
    public ArrayList<Socio> getSocios() {
        return socios;
    }

    /**
     * @param socios the socios to set
     */
    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }
    
    /**
     * @return the usos
     */
    public ArrayList<Uso> getUsos() {
        return usos;
    }

    /**
     * @param usos the usos to set
     */
    public void setUsos(ArrayList<Uso> usos) {
        this.usos = usos;
    }

    /**
     * Añade un socio, comprueba si ya existe.
     * @param socio 
     */
    public void addSocio(Socio socio){
        if(!socios.contains(socio)){
            socios.add(socio);
        }        
    } 

//pendiente eliminar usos en cascada.    
    /**
     * Elimina un socio. 
     * @param socio 
     */
    public void delSocio(Socio socio){
        socios.remove(socio);
        System.out.println("Socio eliminado..");
        ArrayList<Uso> eliminarUsos = new ArrayList<>();
        for(Uso uso: usos){
            if(uso.getSocio() != null && uso.getSocio().equals(socio)){
                eliminarUsos.add(uso);
            }
        }
        usos.removeAll(eliminarUsos);
        System.out.println(eliminarUsos.size() + " Usos elimiandos");
        System.out.println(" Operación realizada con éxito");
    }
    
        
    /**
     * Añade un actividad, comprueba si ya existe.
     * @param actividad 
     */
    public void addActividad(Actividad actividad){
        if(!actividades.contains(actividad)){
            actividades.add(actividad);
        }        
    } 

    
//pendiente eliminar usos en cascada.    
    /**
     * Elimina un actividad. 
     * @param actividad 
     */
    public void delActividad(Actividad actividad){
        actividades.remove(actividad);
    }
    
      /**
     * Añade un uso, comprueba si ya existe.
     * @param uso 
     */
    public void addUso(Uso uso){
        if(!usos.contains(uso)){
            usos.add(uso);
        }        
    } 

    
//pendiente eliminar usos en cascada.    
    /**
     * Elimina un uso. 
     * @param uso 
     */
    public void delUso(Uso uso){
        usos.remove(uso);
    }
    
    public String listarSocios(){
        StringBuilder listado = new StringBuilder();
        for(int i = 0; i <socios.size(); i++){
            listado.append(socios.get(i).toString() + "\n");            
        }
        return listado.toString();
    }
    
    public String listarActividades(){
        StringBuilder listado = new StringBuilder();
        for(int i = 0; i <actividades.size(); i++){
            listado.append("[" + i + "]" + actividades.get(i).toString() + "\n");            
        }
        return listado.toString();
    }
    
     public String listarUsos(){
        StringBuilder listado = new StringBuilder();
        for(int i = 0; i <usos.size(); i++){
            listado.append(usos.get(i).toString() + "\n");            
        }
        return listado.toString();
    }

    public Socio obtenerSocio(String codigo){
        Socio socio = null;
        for(int i = 0; i < socios.size() && socio == null; i++){
            if(socios.get(i).equals(codigo)){
                socio = socios.get(i);
            }        
        }
        return socio;
    }
    
    public String facturarSocio(Socio socio, LocalDate fechaInicio, LocalDate fechaFin){        
        StringBuilder resultado = new StringBuilder();        
        float cargos = socio.getCuotaFija();
        resultado.append(" Factura: " + socio.getNombre() + "\n");
        resultado.append("  - Cuota Mensual: " + socio.getCuotaFija() + "\n");
        
        for(Uso uso: usos){          
            if(uso.getSocio() != null && uso.getSocio().equals(socio) && uso.getFecha().isAfter(fechaInicio.minusDays(1)) && uso.getFecha().isBefore(fechaFin.plusDays(1))){
                cargos += uso.getImporte();
                resultado.append("  - " + uso.toStringFacturar() + "\n");
            }
        }
        resultado.append("TOTAL: " + cargos + "€");
        
        return resultado.toString();
    }
    
    
}
