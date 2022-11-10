package Modelo;

public class Reclamo {

    public String fechaActual;
    public String direccion;
    public String descripcion;
    public int idCategoria;
    public int idSubcategoria;
    public String correoUsuario;


    public Reclamo(String fechaActual, String direccion, String correoUsuario, int idCategoria,int idSubcategoria, String descripcion) {
        this.fechaActual = fechaActual;
        this.direccion = direccion;
        this.correoUsuario = correoUsuario;
        this.idCategoria = idCategoria;
        this.idSubcategoria = idSubcategoria;
        this.descripcion = descripcion;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setIdUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

}
