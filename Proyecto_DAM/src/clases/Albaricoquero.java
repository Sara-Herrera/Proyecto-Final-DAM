
package clases;

import java.util.List;

public class Albaricoquero extends Frutal {
    
    private String color;
    
    //Constructor clase Albaricoquero
    public Albaricoquero(int id, String nombre, String especie, String floracion, List<String> zonasGeograficas, String color){
        super(id, nombre, especie, floracion, zonasGeograficas);
        this.color = color;
    }
    
    //Constructor clase Albaricoquero [vacío]
    public Albaricoquero(){
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
