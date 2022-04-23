
package tp1ds.pkg2022;

import java.util.ArrayList;
import java.util.Scanner;

public class Socio {
 
    public String nombre;
    public String apellido;
    public int dni;
    public int dia;
    public int mes;
    public int anio;
    private String domicilio;
    private String localidad;
    private int telefono;
    private String email;
    private String grupoSanguineo;
    private String factor;
    public boolean enfermedadCronica;
    public boolean medicacionPermanente;
    private String medicamento;
    private String categoriaSocio;
    public static ArrayList<Socio> socios = new ArrayList();

    public Socio() {
    }

    Scanner entrada = new Scanner(System.in);

    public Socio(String nombre, String apellido, int dni, int dia, int mes, int anio, String domicilio, String localidad, int telefono, String email,
            String grupoSanguineo, String factor, boolean enfermedadCronica, boolean medicacionPermanente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.telefono = telefono;
        this.email = email;
        this.grupoSanguineo = grupoSanguineo;
        this.factor = factor;
        this.enfermedadCronica = enfermedadCronica;
        this.medicacionPermanente = medicacionPermanente;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public boolean isEnfermedadCronica() {
        return enfermedadCronica;
    }

    public void setEnfermedadCronica(boolean enfermedadCronica) {
        this.enfermedadCronica = enfermedadCronica;
    }

    public boolean isMedicacionPermanente() {
        return medicacionPermanente;
    }

    public void setMedicacionPermanente(boolean medicacionPermanente) {
        this.medicacionPermanente = medicacionPermanente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public static ArrayList<Socio> getSocios() {
        return socios;
    }

    public static void setSocios(ArrayList<Socio> socios) {
        Socio.socios = socios;
    }

    public String getCategoriaSocio() {
        return categoriaSocio;
    }

    public void setCategoriaSocio(String categoriaSocio) {
        this.categoriaSocio = categoriaSocio;
    }

    public void RegistrarSocio() {

        System.out.print("\nFactor: ");
        factor = entrada.nextLine();
        Categoria categoria = new Categoria();

        if (EsFactorNegativo(factor)) {

            System.out.print("\nNombre: ");
            nombre = entrada.nextLine();
            System.out.print("\nApellido: ");
            apellido = entrada.nextLine();
            System.out.print("\nDNI: ");
            dni = entrada.nextInt();
            System.out.print("\nFecha de Nacimiento");
            System.out.print("\nDia: ");
            dia = entrada.nextInt();
            System.out.print("\nMes: ");
            mes = entrada.nextInt();
            System.out.print("\nAnio: ");
            anio = entrada.nextInt();
            entrada.nextLine();
            System.out.print("\nDomicilio: ");
            domicilio = entrada.nextLine();
            System.out.print("\nLocalidad: ");
            localidad = entrada.nextLine();
            System.out.print("\nTelefono: ");
            telefono = entrada.nextInt();
            System.out.print("\nEmail: ");
            entrada.nextLine();
            email = entrada.nextLine();
            System.out.print("\nGrupo Sanguineo: ");
            grupoSanguineo = entrada.nextLine();
            System.out.print("\nEnfermedad Crónica (si:t - no:f): ");
            enfermedadCronica = entrada.nextBoolean();
            entrada.nextLine();
            System.out.print("\nMedicacion permanente (si:true - no:false): ");
            medicacionPermanente = entrada.nextBoolean();
            entrada.nextLine();
            medicamento = RegistrarMedicamento(medicacionPermanente);
            categoriaSocio = categoria.AsignarCategoria(dia, mes, anio, enfermedadCronica, medicacionPermanente);
        }
    }

    public void MostrarSocios(Categoria categoria) {

        System.out.println("\n\n\t\tLista de Socios");

        for (Socio socio : socios) {
            String categoriaSocio = categoria.AsignarCategoria(dia, mes, anio, enfermedadCronica, medicacionPermanente);

            System.out.println("\nNombre: " + socio.nombre + "\nApellido: " + socio.apellido + "\nDNI:" + socio.dni
                    + "\nFecha Nacimiento: " + socio.dia + "/" + socio.mes + "/" + socio.anio + "\nDomicilio: " + socio.domicilio
                    + "\nLocalidad: " + socio.localidad + "\nTelefono: " + socio.telefono + "\nEmail: " + socio.email + "\nGrupo sanguineo: "
                    + socio.grupoSanguineo + "\nFactor: " + socio.factor + "\nEnfermedad cronica: " + socio.enfermedadCronica + "\nMedicacion permanente: "
                    + socio.medicacionPermanente + "\nMedicamento: " + socio.medicamento + "\nCategoria: " + categoriaSocio);
        }
        System.out.println("\n");
    }

    private String RegistrarMedicamento(boolean medicacionPermanente) {

        String medicacion = null;
        boolean estado = medicacionPermanente;

        if (estado) {
            System.out.print("\nIngrese el medicamento: ");
            medicacion = entrada.nextLine();
        } else {
            medicacion = "no";
        }
        return medicacion;

    }

    public boolean EsFactorNegativo(String factor) {

        boolean resultado;

        if (factor.equalsIgnoreCase("negativo")) {
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }
}
