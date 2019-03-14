package Beyond_memories;

import java.util.*;

public class Moderador extends Persona {

    private String contrasena;
    private Cementerio cementerio;
    static ArrayList<Moderador> moderadores = new ArrayList<>();

    public Moderador(String nombre, int documento, String fechaNac, String contrasena,Cementerio cementerio) {
        super(nombre, documento, fechaNac);
        this.contrasena = contrasena;
        this.cementerio = cementerio;
        cementerio.añadirModeradorCementerio(this);
    }

    public static Moderador buscarModerador(int documento) {
        for (Moderador m : moderadores){
            if (m.getDocumento() ==  documento){
                return m;
            }
        }
        return null;
    }
    
    public static void mostrarMod(Moderador m){
        int doc = m.getDocumento();
        System.out.println("");
        if(moderadores.contains(doc)){
            System.out.println("---DATOS DE MODERADOR---");
            System.out.println("Nombre: "+m.getNombre());
            System.out.println("Documento: "+ m.getDocumento());
            System.out.println("Fecha de Nacimiento: "+ m.getFechaNac());
        }
        else{
            System.out.println("Esta persona no es un Moderador.");
        }
    }
}

    /*

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

/*
    public void setContrasena(double contrasena){
        this.contrasena = contrasena;
    }
*/
    
