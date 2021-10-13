/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicioexamenrepasospa.app;

import ar.csdam.pr.libreriaar.Menu;
import controladores.GestorSpa;
import java.util.Scanner;

/**
 *
 * @author a20armandocb
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean continuar = true;
        Scanner lector = new Scanner(System.in);
        GestorSpa gestor = new GestorSpa(lector);
        Menu menu = construirMenuPrincipal(lector);
        do {
            try {
                continuar = menuAcciones(menu, gestor);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (continuar);

        lector.close();
    }

    private static Menu construirMenuPrincipal(Scanner lector) {
        Menu menu = new Menu(lector);

        menu.setTituloMenu("Menú Spa");
        menu.addOpcion("Alta Socio");
        menu.addOpcion("** Editar Actividad Socio");
        menu.addOpcion("Alta Usos Socio");
        menu.addOpcion("Facturar Socio");
        menu.addOpcion("Eliminar Socio");
        menu.addOpcion("Listar Socios");
        menu.addOpcion("Listar Usos");

        return menu;
    }

    private static boolean menuAcciones(Menu menu, GestorSpa gestor) throws Exception {
        boolean continuar = true;
        menu.mostrarGUI();
        switch (menu.getSeleccion()) {
            case 0:
                //salir
                continuar = false;
                System.out.println("Bye Bye!");
                break;
            case 1:
                System.out.println("Alta Socio");
                gestor.appAddSocio();
                break;
            case 2:
                System.out.println("Editar Actividad Socio");
                gestor.appEditSocio();
                break;
            case 3:
                System.out.println("Alta Usos Socio");
                gestor.appAddUso();
                break;
            case 4:
                System.out.println("Facturar Socio");
                gestor.appBildSocio();
                break;
            case 5:
                System.out.println("Eliminar Socio");
                gestor.appDelSocio();

                break;
            case 6:
                System.out.println("Listar Socios");
                gestor.appListarSocios();                
                break;
            case 7:
                System.out.println("Listar Usos");
                gestor.appListarUsos();                
                break;
            default:
                System.out.println("**Opcion incorrecta**");
                break;

        }
        return continuar;
    }
}
