
package Modelo;



public class Subcategoria {
    
    public String nombre;
    public int idSubcategoria;
    public int idCategoria;


    public Subcategoria() {
    }
    
    
    public Subcategoria(String nombre, int idSubcategoria, int idCategoria) {
        this.nombre = nombre;
        this.idSubcategoria = idSubcategoria;
        this.idCategoria = idCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setId(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    @Override
    public String toString() {
        return (nombre);
    }
    
    
}
