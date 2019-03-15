package Beyond_memories;
import java.util.*;
public class Lapida {

    private String fechaDef;
    private String epitafio;
    private Ubicacion ubicacion;
    private boolean privacidad;
    private Persona dueno;
    private Cementerio cementerio;
    ArrayList<Lapida>Lapidas = new ArrayList<>();


    public Lapida(Persona persona,boolean privacidad,Ubicacion ubicacion,Cementerio cementerio,String epitafio,String fechaDef){
        this.fechaDef = fechaDef;  //Fecha de defunción de dueño(Puede estar vacía)
        this.epitafio = epitafio; //Epitafio de lápida(Puede estar vacío)
        this.privacidad = privacidad; //Privacidad de lápida
        this.dueno =  persona; //Dueño de lápida
        this.ubicacion = ubicacion; //Ubicacion de lápida
        this.cementerio = cementerio; //Cementerio donde está la lápida
        ArrayList<Memoria>Memorias =  new ArrayList<>(); //Lista de memorias
    }

    public Cementerio getCementerio() {
        return cementerio;
    }

    public String getFechaDef() {
        return fechaDef;
    }

    public void setFechaDef(String fechaDef) {
        this.fechaDef = fechaDef;
    }

    public String getEpitafio() {
        return epitafio;
    }

    public void setEpitafio(String epitafio) {
        this.epitafio = epitafio;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(boolean privacidad) {
        this.privacidad = privacidad;
    }

    public Persona getDueno() {
        return dueno;
    }

    public void setDueno(Persona dueño) {
        this.dueno = dueño;
    }
    
    
}