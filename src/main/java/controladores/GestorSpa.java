/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ar.csdam.pr.libreriaar.Entradas;
import com.mycompany.ejercicioexamenrepasospa.pojos.Actividad;
import com.mycompany.ejercicioexamenrepasospa.pojos.Socio;
import com.mycompany.ejercicioexamenrepasospa.pojos.Spa;
import com.mycompany.ejercicioexamenrepasospa.pojos.Uso;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author a20armandocb
 */
public class GestorSpa {

    private Spa spa;
    private Socio socioSeleccionado;
    private Actividad actividadSeleccionada;
    private Scanner lector;

    public GestorSpa(Scanner lector) {
        this.lector = lector;
        this.spa = new Spa("B36123456", "Relax S.L.");
        this.spa.addActividad(new Actividad("horario libre", 0));
        this.spa.addActividad(new Actividad("grupo", 2));
        this.spa.addActividad(new Actividad("alquiler espacio", 4));
        this.addSocio("Paco", 15);
        this.addSocio("Pilar", 15);
        this.addSocio("Pablo", 15);
        this.addSocio("Pablo Junior", 5);
        this.spa.addUso(new Uso("Piscina", spa.getActividades().get(0), LocalDate.parse("2021-12-03"), LocalTime.parse("10:00"), LocalTime.parse("15:00"), spa.getSocios().get(0)));
        this.spa.addUso(new Uso("Jacuzzi", spa.getActividades().get(0), LocalDate.parse("2021-12-04"), LocalTime.parse("11:00"), LocalTime.parse("14:00")));
        this.spa.addUso(new Uso("Yoga", spa.getActividades().get(1), LocalDate.parse("2021-12-05"), LocalTime.parse("12:00"), LocalTime.parse("13:00"), spa.getSocios().get(1)));
        this.spa.addUso(new Uso("Pilates", spa.getActividades().get(1), LocalDate.parse("2021-12-06"), LocalTime.parse("13:00"), LocalTime.parse("16:00"), spa.getSocios().get(2)));
        this.spa.addUso(new Uso("Padel", spa.getActividades().get(2), LocalDate.parse("2021-12-07"), LocalTime.parse("14:00"), LocalTime.parse("15:00")));
        this.spa.addUso(new Uso("Padel", spa.getActividades().get(2), LocalDate.parse("2021-10-07"), LocalTime.parse("14:00"), LocalTime.parse("15:00"), spa.getSocios().get(3)));
        this.spa.addUso(new Uso("Tenis", spa.getActividades().get(2), LocalDate.parse("2021-12-08"), LocalTime.parse("15:00"), LocalTime.parse("17:00"), spa.getSocios().get(3)));
        this.spa.addUso(new Uso("Tenis", spa.getActividades().get(2), LocalDate.parse("2021-12-09"), LocalTime.parse("15:00"), LocalTime.parse("17:00"), spa.getSocios().get(3)));
    }

    public void addSocio(String nombre, float cuotaFija) {
        spa.addSocio(new Socio(generarCodigoUsuario(), nombre, cuotaFija));
    }

    public void delSocio(Socio socio) {
        spa.delSocio(socio);
    }

    public void addActividad(Actividad actividad) {
        spa.addActividad(actividad);
    }

    public void delActividad(Actividad actividad) {
        spa.delActividad(actividad);
    }

    public void addUso(String nombreActividad, Actividad actividad, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        spa.addUso(new Uso(nombreActividad, actividad, fecha, horaInicio, horaFin));
    }

    public void addUso(String nombreActividad, Actividad actividad, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Socio socio) {
        spa.addUso(new Uso(nombreActividad, actividad, fecha, horaInicio, horaFin, socio));
    }

    public void delUso(Uso uso) {
        spa.delUso(uso);
    }

    public void appAddSocio() {
        System.out.println("Indique el nombre");
        String nombre = Entradas.pedirString(lector);
        System.out.println("Cuota anual");
        float cuotaFija = (float) Entradas.pedirDouble(lector);
        addSocio(nombre, cuotaFija);
        System.out.println("Socio creado");

    }

    public void appEditSocio() {
        System.out.println("En desarrollo.appEditSocio.. no tengo muy claro que hacer aqui.");
    }

    public void appAddUso() {
        if (appSelectSocio()) {
            if (appSelectActividad()) {
                System.out.println("Nombre especifico de la actividad");
                String nombreActividad = Entradas.pedirString(lector);
                System.out.println("Indica la fecha. Por ejemplo 2021-12-03");
                String fecha = Entradas.pedirString(lector);
                System.out.println("Indica la hora de inicio. Por ejemplo 13:00");
                String horaInicio = Entradas.pedirString(lector);
                System.out.println("Indica la hora de fin. Por ejemplo 15:00");
                String horaFin = Entradas.pedirString(lector);
                addUso(nombreActividad, actividadSeleccionada, LocalDate.parse(fecha), LocalTime.parse(horaInicio), LocalTime.parse(horaFin), socioSeleccionado);
                System.out.println("Uso añadido.");
            } else {
                System.out.println("Error al seleccionar actividad.");
            }
        }
    }

    public void appBildSocio() {
         if (appSelectSocio()) {
             System.out.println("Indica la fecha de inicio para facturar");
             LocalDate fechaInicio = LocalDate.parse(Entradas.pedirString(lector));
             System.out.println("Indica la fecha de fin");
             LocalDate fechaFin = LocalDate.parse(Entradas.pedirString(lector));
             facturarSocio(fechaInicio, fechaFin);
         }
    }
    
    public void facturarSocio(LocalDate fechaInicio, LocalDate fechaFin){
        System.out.println(spa.facturarSocio(socioSeleccionado, fechaInicio, fechaFin));
    }
    

    public void appDelSocio() {
        System.out.println("ELIMINAR SOCIO:");
        if (appSelectSocio()) {
             delSocio(socioSeleccionado);
         }
    }

    public String generarCodigoUsuario() {
        Spa.contadorCodigos++;
        return Integer.toString(Spa.contadorCodigos);
    }

    public void appListarSocios() {
        System.out.println(spa.listarSocios());
    }

    public void appListarActividades() {
        System.out.println(spa.listarActividades());
    }
    
    public void appListarUsos() {
        System.out.println(spa.listarUsos());
    }

    /**
     *
     * @param lector
     * @return devuelve True si selecciona el socio. False si el socio no
     * existe.
     */
    public boolean appSelectSocio() {
        boolean exito = false;
        System.out.println("Indica el codigo del socio");
        System.out.println(spa.listarSocios());
        String codigo = Entradas.pedirString(lector);

        socioSeleccionado = spa.obtenerSocio(codigo);
        
        if (socioSeleccionado != null) {
            exito = true;
        } else {
            System.out.println("Error, el socio no existe.");
        }

        return exito;
    }

    public boolean appSelectActividad() {
        boolean exito = false;
        System.out.println("Indica la Actividad");
        System.out.println(spa.listarActividades());
        int index = Entradas.pedirInt(lector);
        try {
            actividadSeleccionada = spa.getActividades().get(index);
            exito = true;
        } catch (IndexOutOfBoundsException e) {
            actividadSeleccionada = null;
            System.out.println("Error, la Actividad no existe.");
        }
        return exito;
    }

}
