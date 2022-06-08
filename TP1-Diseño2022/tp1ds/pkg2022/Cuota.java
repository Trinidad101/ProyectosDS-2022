package tp1ds.pkg2022;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cuota {

    private float cuotaPasivo;
    private float cuotaActivo;
    private LocalDate fechaVencimiento;
    private String formaDePago;
    public Socio socio;
    public static ArrayList<Cuota> cuotas = new ArrayList();

    public Cuota(Socio socio) {
        this.socio = socio;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public void GenerarCuota(Socio socio) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("\nIngrese forma de pago: ");
        formaDePago = entrada.nextLine();

        if (socio.getCategoriaSocio().equalsIgnoreCase("activo")) {
            cuotaActivo = 3500;
            fechaVencimiento = FechaVencimiento();
            System.out.println("\nCuota: " + cuotaActivo + "\nForma de pago: " + formaDePago + "\nFechaVencimiento: " + fechaVencimiento);
        } else {
            cuotaPasivo = 2400;
            fechaVencimiento = FechaVencimiento();
            System.out.println("\nCuota: " + cuotaPasivo + "\nFechaVencimiento: " + fechaVencimiento);
        }
    }

    public LocalDate FechaVencimiento() {

        LocalDate fechaAtual = LocalDate.now();

        LocalDate fechaVencimiento = fechaAtual.plusMonths(1);

        return fechaVencimiento;
    }
}
