package tp1ds.pkg2022;

import java.util.Scanner;

public class Peticion {

    private int cantidadDonantes;
    private int dia;
    private int mes;
    private int anio;
    private String grupoSanguineo;
    private String factor;

    public Peticion (){};
    
    public Peticion(int cantidadDonantes, int dia, int mes, int anio, String grupoSanguineo, String factor) {
        this.cantidadDonantes = cantidadDonantes;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.grupoSanguineo = grupoSanguineo;
        this.factor = factor;
    }

    public int getCantidadDonantes() {
        return cantidadDonantes;
    }

    public void setCantidadDonantes(int cantidadDonantes) {
        this.cantidadDonantes = cantidadDonantes;
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

    public void RegistrarPeticion() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("\nIngrese la cantidad de donadores: ");
        cantidadDonantes = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\t\t\tFecha Limite");
        System.out.print("\nDia: ");
        dia = teclado.nextInt();
        System.out.print("\nMes: ");
        mes = teclado.nextInt();
        System.out.print("\nAnio: ");
        anio = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\n\t\t\tTipo de Sangre");
        System.out.print("\nIngrese grupo sanguineo: ");
        grupoSanguineo = teclado.nextLine();
        System.out.print("\nIngrese el factor: ");
        factor = teclado.nextLine();
    }

    public void mostrarPeticion() {
        System.out.println("\nCantidad de donadores: " + cantidadDonantes + "\nFecha Limite: " + dia + "/" + mes + "/" + anio + 
                "\n\t\tTipo Sangre " + "\nGrupo Sanguineo: " + grupoSanguineo + "\nfactor: " + factor);
    }

}
