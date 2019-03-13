package Beyond_memories;
import java.util.ArrayList;


public class Cementerio {

    private short capacidad;
    private String nombre;
    private String direccion;
    private int id;
    private Ubicacion ubicaciones[];
    ArrayList<Cliente>clientes = new ArrayList<>();
    ArrayList<Moderador>moderadores = new ArrayList<>();
    public static ArrayList<Cementerio>cementerios = new ArrayList<>();

    Cementerio(int id,String nombre, short capacidad, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.direccion = direccion;
        ubicaciones = new Ubicacion[capacidad];
        cementerios.add(this);
    }
    
    public void añadirModeradorCementerio(Moderador moderador){
        this.moderadores.add(moderador);
    }
    
    public void añadirClienteCementerio(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void añadirUbicacionCementerio(Ubicacion ubicacion) {
        this.ubicaciones[ubicacion.getIndice()] = ubicacion;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getId(){
        return id;
    }
    
    public static Cementerio buscarCementerio(int id){
        for(Cementerio c:cementerios){
            if (c.getId() == id){
                return c;
            }
        }
    return null;
    }
    
    public static void imprimirCementerios(){
        for(Cementerio c:cementerios){
            System.out.println(c.getId()+". " + c.getNombre());
        }
    }

}