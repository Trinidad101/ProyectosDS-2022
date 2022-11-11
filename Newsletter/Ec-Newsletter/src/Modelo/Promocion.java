
package Modelo;

public class Promocion {
    private int Id;
  private String descripcion;
  private int estado;
  private String fechaInicio;
  private String fechaFinal;

    public Promocion(int Id, String descripcion, int estado, String fechaInicio, String fechaFinal) {
        this.Id = Id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "Promocion(" + "fechaInicio= " + fechaInicio + "\nfechaFinal= " + fechaFinal + "\n" + descripcion + ')';
    }
    
}
