
package tp1ds.pkg2022;

import java.util.ArrayList;


public class Donacion {
    private int dia;
    private int mes;
    private int anio;
    Categoria categoria;
    
    
    private static ArrayList<Socio> socios = new ArrayList();
    
    

    public void AsignarDonadores(Peticion peticion,Socio socio){
        
        for(int x=0;x<peticion.getCantidadDonantes(); x++){
            
       socio.donadores(categoria);
       
        System.out.print("Donadores");
        System.out.print(socio);
    }
      
    }
}
