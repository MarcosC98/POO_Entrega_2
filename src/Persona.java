package cementerio.persona;
import java.util.*;

public class Persona {

    private String nombre;
    private int documento;
    private String fechaNac;
    Scanner intro = new Scanner(System.in);
    public static Map<Integer,String> ListaPersonas = new HashMap<Integer,String>();
    public static Map<Integer,Persona> Datos = new HashMap<Integer,Persona>();
    
    public Persona(String nombre, int documento, String fechaNac){
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNac = fechaNac;
        ListaPersonas.put(documento,nombre);
    }

    public static void mostrarPersona(Persona p){
        int doc = p.getDocumento();
        System.out.println("");
        if((ListaPersonas.containsKey(doc))==true){
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

    public static void imprimirPersonas(){
        int key;
        int numeroPersonas = ListaPersonas.size();
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