
package tp1ds.pkg2022;

import java.util.Scanner;

public class TP1DS2022 {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        Socio socio = new Socio();
        Categoria categoria = new Categoria();
        Cuota cuota = new Cuota(socio);
        Peticion peticion = new Peticion();
        Donacion donacion = new Donacion();
        int opcionMenu;

        do {
            System.out.print("\n\n\t\t¿Que desea realizar?");
            System.out.print("\n1:Registrar Socio  2:Generar Cuota 3:Generar Peticion 4:Donacion 5: Mostrar Lista 6:Salir\n");
            System.out.print("\nOpcion: ");
            opcionMenu = entrada.nextInt();
            switch (opcionMenu) {

                case 1:
                    socio.RegistrarSocio();
                    socio.socios.add(socio);
                   
                    break;

                case 2:
                    cuota.GenerarCuota(socio);
                    break;

                case 3: 
                    peticion.RegistrarPeticion();
                    peticion.mostrarPeticion();
                    
                    break;
                    
                case 4: 
                    socio.donadores(categoria);
                    donacion.AsignarDonadores(peticion,socio);
                    break;
                
                case 5:
                    socio.MostrarSocios(categoria);
                    break;
            }

        } while (opcionMenu != 6);
        
    }
    }
 