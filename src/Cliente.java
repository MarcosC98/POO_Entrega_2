import java.util.*;
import cementerio.persona.*;

public class Cliente extends Persona{

    private String contrasena;
    public static HashMap<Integer,String> ListaClientes = new HashMap<Integer,String>();

    public Cliente(String nombre, int documento, String fechaNac, String contrasena){
        super(nombre,documento,fechaNac);
        this.contrasena = contrasena;
        ListaClientes.put(documento,contrasena);
    }

    public static void mostrarCliente(Cliente c){
        int doc = c.getDocumento();
        System.out.println("");
        if((ListaClientes.containsKey(doc))==true){
            System.out.println("---DATOS DE CLIENTE---");
            System.out.println("Nombre: "+c.getNombre());
            System.out.println("Documento: "+c.getDocumento());
            System.out.println("Fecha de Nacimiento: "+c.getFechaNac());
            // Datos guardados dentro de los datos ficticios, Ricardo encargado.
        }
        else {
            System.out.println("Esta no es Cliente registrado.");
        }

    }

    public static void imprimirClientes(){
        int key;
        int numeroClientes = ListaClientes.size();
        Iterator it = ListaClientes.keySet().iterator();
        if(numeroClientes>0){
            while(it.hasNext()){
                key = (int)it.next();
                System.out.println("Nombre: "+ ListaClientes.get(key)+" Documento: "+ key);
            }
        }
        else {
            System.out.println("No hay Clientes inscritos.");
        }
    }

    public static boolean verificarCliente(int documento,String contrasena){
        if((ListaClientes.containsKey(documento))&&(ListaClientes.get(documento)==contrasena)){
            return true;
        }
        else{
            return false;
        }
    }

    public void setContrasena(double contrasena){
        this.contrasena = contrasena;
    }

    public String getContrasena(){
        return contrasena;
    }
}