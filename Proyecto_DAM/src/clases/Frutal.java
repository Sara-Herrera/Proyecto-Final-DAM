
package clases;

import java.util.ArrayList;
import java.util.List;


public class Frutal {
    
    private int id;
    private String nombre;
    private String especie;
    private String floracion;
    private List<String> zonasGeograficas;

    
    //Constructor clase Frutal
    public Frutal(int id, String nombre, String especie, String floracion, List<String> zonasGeograficas){
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.floracion = floracion;
        this.zonasGeograficas = zonasGeograficas;
    };
    
    //Constructor clase Frutal [vacío]
    public Frutal(){
        zonasGeograficas = new ArrayList<>();
    };
   
    //Métodos Getters
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getFloracion() {
        return floracion;
    } 
    
    public List<String> getZonasGeograficas() {
        return zonasGeograficas;
    } 

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setFloracion(String floracion) {
        this.floracion = floracion;
    }

    public void setZonasGeograficas(List<String> zonasGeograficas) {
        this.zonasGeograficas = zonasGeograficas;
    }
    
}
