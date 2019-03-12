import Java.util.*;
import cementerio.persona.*;
import cementerio.moderador.*;
import cementerio.cliente.*;
import cementerio.lapida.*;
public class Main{

    public static void main(String[] args) {

        Moderador m1 = new Moderador("MarioAguilera", 1010215392, "13/06/1994","Simona10");
        Persona p2 = new Persona("Alejandra",1010,"12/10/1963");
        Lapida l2 = new Lapida("Me encanta oís",2,true,"10/03/2019");
        Cliente c1 = new Cliente("LinaChavez",2442,"26/03/1986","Yep");

        Persona.mostrarPersona(m1);
        Persona.mostrarPersona(p2);
        Moderador.mostrarMod(m1);
        Moderador.convertirMod(p2, "Simona10");
        Persona.imprimirPersonas();

        //Imprimir texto presentacion.


    }
}