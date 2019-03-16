package Beyond_memories;


public class Ubicacion {

    private final int indice;
    private final Cementerio cementerio;
    public static Ubicacion ubicaciones[];

    public Ubicacion(int indice, Cementerio cementerio) {
        this.indice = indice;
        this.cementerio = cementerio;
        Ubicacion.añadirUbicacion(this);
    }

    public int getIndice() {
        return indice;
    }
    
    public static void añadirUbicacion(Ubicacion ubicacion){
        ubicaciones[ubicacion.getIndice()] = ubicacion;
    }
    
    public static boolean revisarDisponibilidadUbicacion(Cementerio cementerio,int indice){
        if(ubicaciones[indice]==null){
            return true;
        }else{
            return false;
        }
    }

}
