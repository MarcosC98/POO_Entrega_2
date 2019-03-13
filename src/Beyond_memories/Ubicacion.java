package Beyond_memories;


public class Ubicacion {

    private final int indice;
    private final Cementerio cementerio;

    public Ubicacion(int indice, Cementerio cementerio) {
        this.indice = indice;
        this.cementerio = cementerio;
        cementerio.añadirUbicacionCementerio(this);
    }

    public int getIndice() {
        return indice;
    }

}
