
package tp1ds.pkg2022;

import java.util.Calendar;

public class Categoria {
    
    public String AsignarCategoria(int dia, int mes, int anio, boolean enfermedadCronica, boolean medicacionPermanente) {
        String categoria = null;
        int edad = EdadSocio(dia, mes, anio);

        if (enfermedadCronica || medicacionPermanente) {
            categoria = "Pasivo";
        } else {
            if (18 <= edad && edad <= 52) {
                categoria = "Activo";
            } else {
                categoria = "Pasivo";
            }
        }
        return categoria;
    }

    public static int EdadSocio(int dia, int mes, int anio) {

        Calendar inicio = Calendar.getInstance();
        inicio.set(anio, mes - 1, dia);

        Calendar fechaActual = Calendar.getInstance();

        int edad = fechaActual.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);

        if (inicio.get(Calendar.DAY_OF_YEAR) < fechaActual.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        return edad;
    }
}
