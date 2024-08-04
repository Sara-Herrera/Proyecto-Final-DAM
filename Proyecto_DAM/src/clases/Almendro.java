
package clases;

import java.util.List;

public class Almendro extends Frutal{
    
    private String forma;
    
    //Contructor clase Almendro
    public Almendro(int id, String nombre, String especie, String floracion, List<String> zonasGeograficas, String forma){
        super(id, nombre, especie, floracion, zonasGeograficas);
        this.forma = forma; 
    }
    
    //Contructor clase Almendro [vacío]
    public Almendro(){
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
    
}
