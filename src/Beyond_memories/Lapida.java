package Beyond_memories;
import java.util.*;
public class Lapida {

    private String fechaDef;
    private String epitafio;
    private Ubicacion ubicacion;
    private boolean privacidad;
    private Persona dueño;
    private Cementerio cementerio;
    ArrayList<Lapida>Lapidas = new ArrayList<>();


    public Lapida(Persona persona,boolean privacidad,Ubicacion ubicacion,Cementerio cementerio,String epitafio,String fechaDef){
        this.fechaDef = fechaDef;  //Fecha de defunción de dueño(Puede estar vacía)
        this.epitafio = epitafio; //Epitafio de lápida(Puede estar vacío)
        this.privacidad = privacidad; //Privacidad de lápida
        this.dueño =  persona; //Dueño de lápida
        this.ubicacion = ubicacion; //Ubicacion de lápida
        this.cementerio = cementerio; //Cementerio donde está la lápida
        ArrayList<Memoria>Memorias =  new ArrayList<>(); //Lista de memorias
    }

    public Cementerio getCementerio() {
        return cementerio;
    }
    
    
}