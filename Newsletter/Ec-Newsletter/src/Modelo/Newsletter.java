
package Modelo;

public class Newsletter {
    private String titulo;
 private String fechaEnvio;
 private String asunto;
 private int id;
 private String correoEmisor;
 private String correoReceptor;
 Promocion promocion;

    public Newsletter() {
    }

 
    public Newsletter(String fechaEnvio, String asunto, String correoReceptor,Promocion promocion) {
  
        this.fechaEnvio = fechaEnvio;
        this.asunto = asunto;
        
        this.correoReceptor = correoReceptor;
        this.promocion = promocion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCorreoEmisor() {
        return correoEmisor;
    }

    public void setCorreoEmisor(String correoEmisor) {
        this.correoEmisor = correoEmisor;
    }

    public String getCorreoReceptor() {
        return correoReceptor;
    }

    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    @Override
    public String toString() {
        return "Newsletter{" + "fechaEnvio=" + fechaEnvio + ", asunto=" + asunto + ", correoReceptor=" + correoReceptor + ", promocion=" + promocion + '}';
    }

}
