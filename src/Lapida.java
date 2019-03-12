import cementerio.*;
import java.util.*;
public class Lapida {

    private String fechaDef;
    private String epitafio;
    private int ubicacion;
    private boolean privacidad;
    public static HashMap<Integer,Integer> Lapidas = new HashMap <Integer,Integer>();


    public Lapida(String epitafio, int ubicacion, boolean privacidad, String fechaDef){
        this.epitafio=epitafio;
        this.ubicacion=ubicacion;
        this.privacidad=privacidad;
        // Datos guardados dentro de los datos ficticios, Ricardo encargado.


    }

    public void mostrarLapida(){

    }

}