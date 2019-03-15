package Beyond_memories;
import java.util.*;

public class Persona {

    private String nombre;
    private int documento;
    private String fechaNac;
    private Cementerio cementerio;
    Scanner intro = new Scanner(System.in);
    public static Map<Integer,Persona> Datos = new HashMap<Integer,Persona>();
    
    public Persona(String nombre, int documento, String fechaNac,Cementerio cementerio){
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNac = fechaNac;
        this.cementerio = cementerio;
        cementerio.visitantes.add(this);       
    }

    public static void mostrarPersona(Persona p,Cementerio cementerio){
        System.out.println("");
        if(cementerio.visitantes.contains(p)){
            System.out.println("---DATOS DE PERSONA---");
            System.out.println("Nombre: "+p.getNombre());
            System.out.println("Documento: "+p.getDocumento());
            System.out.println("Fecha de Nacimiento: "+p.getFechaNac());
            // Datos guardados dentro de los datos ficticios, Ricardo encargado.
        }
        else {
            System.out.println("Esta no es una Persona registrada.");
        }

    }
/*
    public static void imprimirPersonas(){
        int key;
        int numeroPersonas = 
        Iterator it = ListaPersonas.keySet().iterator();
        System.out.println("");
        System.out.println("---LISTADO DE PERSONAS---");
        if(numeroPersonas>0){
            while(it.hasNext()){
                key = (int)it.next();
                System.out.println("-Nombre: "+ ListaPersonas.get(key)+"   -Documento: "+ key);
            }
        }
        else {
            System.out.println("No hay personas inscritas.");
        }
    }
    */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setDocument(int documento){
        this.documento = documento;
    }
    public int getDocumento(){
        return documento;
    }

    public void setFechaNac(String fechaNac){
        this.fechaNac = fechaNac;
    }
    public String getFechaNac(){
        return fechaNac;
    }

}