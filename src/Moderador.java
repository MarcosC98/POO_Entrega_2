package cementerio.moderador;
import cementerio.persona.*;
import java.util.*;

public class Moderador extends Persona{

    private String contrasena;
    public static Map<Integer,String> ListaMods = new HashMap<Integer,String>();

    
    public Moderador(String nombre, int documento, String fechaNac, String contrasena){
        super(nombre,documento,fechaNac);
        this.contrasena = contrasena;
        ListaMods.put(documento,contrasena);
        // Datos guardados dentro de los datos ficticios, Ricardo encargado.
    }
    
    public static void mostrarMod(Moderador m){
        int doc = m.getDocumento();
        System.out.println("");
        if(ListaMods.containsKey(doc)){
            System.out.println("---DATOS DE MODERADOR---");
            System.out.println("Nombre: "+m.getNombre());
            System.out.println("Documento: "+ m.getDocumento());
            System.out.println("Fecha de Nacimiento: "+ m.getFechaNac());
        }
        else{
            System.out.println("Esta persona no es un Moderador.");
        }
    }

    public static void imprimirMods(){
        int key;
        int numeroMods = ListaMods.size();
        Iterator it = ListaMods.keySet().iterator();
        if(numeroMods>0){
            while(it.hasNext()){
                key = (int)it.next();
                System.out.println("Nombre: "+ ListaMods.get(key)+" Documento: "+ key);
            }
        }
        else {
            System.out.println("No hay Moderadores inscritos.");
        }
    }

    public static boolean verificarMod(int documento,String contrasena){
        if((ListaMods.containsKey(documento))&&(ListaMods.get(documento)==contrasena)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void convertirMod(Persona p,String contrasena){
        int doc = p.getDocumento();
        ListaMods.put(doc,contrasena);
    }


    public void setContrasena(double contrasena){
        this.contrasena = contrasena;
    }
    public String getContrasena(){
        return contrasena;
    }
            
    
}