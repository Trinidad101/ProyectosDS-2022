
package tp1ds.pkg2022;

import java.util.Scanner;

public class TP1DS2022 {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        Socio socio = new Socio();
        Categoria categoria = new Categoria();
        Cuota cuota = new Cuota(socio);
        

        int opcionMenu;

        do {
            System.out.print("\n¿Que desea realizar?");
            System.out.print("\n1:Registrar Socio  2:Generar Cuota 3:Salir\n");
            System.out.print("\nOpcion: ");
            opcionMenu = entrada.nextInt();
            switch (opcionMenu) {

                case 1:
                    socio.RegistrarSocio();
                    socio.socios.add(socio);
                    socio.MostrarSocios(categoria);
                    break;

                case 2:
                    cuota.GenerarCuota(socio);
                    break;

              
            }

        } while (opcionMenu != 3);

    }
    }
 