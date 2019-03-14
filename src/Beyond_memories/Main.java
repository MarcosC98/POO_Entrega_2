package Beyond_memories;
import java.util.Scanner;

public class Main {
    
    public static boolean existeCementerio = false;
    public static boolean noValido = true;
    public static String entrada;
    public static boolean excluido = true;
    static Scanner input = new Scanner(System.in);
    static boolean a = true;

    public static void opcionesVisitante() {
        System.out.println("Ingrese el numero de la opción a realizar");
        System.out.println("1. Adquirir Lapida");
        System.out.println("2. Escribir Memoria");
        System.out.println("3. Leer Lapida");
        System.out.println("4. Ingresar con otro perfil");
        System.out.println("5. Ingresar a otro cementerio");
        System.out.println("6. Salir");
        
    }

    public static void main(String[] args) {
        
        //DATOS FICTICIOS:
        Cementerio cementerio1 = new Cementerio(1, "Beyond Memories", (short) 50, "Calle 24 #45a-54 ");
        Moderador moderador1 = new Moderador("David", 1090514247, "23/02/1998", "456", cementerio1);
        Moderador moderador2 = new Moderador("Mario", 1010215392, "13/06/1994", "666", cementerio1);
        Moderador moderador3 = new Moderador("Marcos", 1090514246, "23/02/1998", "123", cementerio1);
        Ubicacion ubicacion1 = new Ubicacion(1, cementerio1);
        Lapida lapida1 = new Lapida(moderador1, false, ubicacion1, cementerio1, "", "");
        Cliente cliente1 = new Cliente(moderador1.getNombre(), moderador1.getDocumento(), moderador1.getFechaNac(), "789", lapida1);

        System.out.println("Bienvenido al sistema de administración para cementerios");
        
        // Marcos tuve que cambiar lo del orden de las cosas aquí...más que nada para hacer más legible el código.
        //No cambié nada de funcionalidad.
        //Tratemos de que solo haya un Try por While dentro de este Main.

        while(a==true){
            Main.ingresoCementerio(existeCementerio);
            Main.ingresoDocumento(noValido);
        }
    }
    
    public static void ingresoCementerio(boolean existeCementerio){
        while(existeCementerio==false){
            System.out.println("Ingrese el id del cementerio al cual desea entrar");
            Cementerio.imprimirCementerios();
            entrada = input.next();
            try {
                int idCementerio = Integer.parseInt(entrada);
                Cementerio cementerio = Cementerio.buscarCementerio(idCementerio);
                if (cementerio == null) {
                    throw new Exception();
                } 
                else {
                    System.out.println("Ha ingresado a la base de datos del cementerio: " + cementerio.getNombre());
                    existeCementerio = true;
                }
            }
            catch (Exception x) {
                System.out.println("Ingrese un id de cementerio valido por favor");       
            }
        }
    }

        
    public static void ingresoDocumento(boolean noValido){
        while(noValido==true){
            System.out.println("Ingrese su documento");
            entrada = input.next();           
            try{
                int documento = Integer.parseInt(entrada);
                if (documento < 0) {             
                    throw new Exception();
                }
                else {
                    Moderador moderador = Moderador.buscarModerador(documento);
                    Cliente cliente = Cliente.buscarCliente(documento);
                    if (moderador == null && cliente == null) {
                        System.out.println(" ");
                        System.out.println("No hay ninguna cuenta registrada con este documento");
                        System.out.println("Si desea crear una cuenta nueva con este documento, ingrese 0");
                        System.out.println("Si desea intentar ingresar con un documento distinto, ingrese 1");  
                        System.out.println("Si desea seleccionar un cementerio distinto, ingrese 2");
                        System.out.println(" ");
                        while (excluido==true) {
                            entrada = input.next();
                            if (entrada.equals("0") || entrada.equals("1") || entrada.equals("2")) {
                                switch (entrada) {
                                    case "0":
                                        System.out.println("Ingrese su nombre completo por favor");
                                        String nombre = input.next();
                                        System.out.println("Ingrese su fecha de nacimiento en formato dd/mm/yyyy");                                                    String fechaNac = input.next();
                                        Persona visitante = new Persona(nombre, documento, fechaNac);
                                        Persona.mostrarPersona(visitante);
                                        opcionesVisitante();
                                        noValido=false;
                                        excluido=false;
                                        a=false;
                                    case "1":
                                        excluido = false;
                                        break;
                                    case "2":
                                        excluido = false;
                                        noValido = false;
                                        break;            
                                }
                            }
                            else {
                                System.out.println("Ingrese una opción valida por favor");
                            }
                        }
                    }   
                }
            }
            catch (Exception e) {
                System.out.println("Ingrese un documento valido");
            }
        }
    }
}
        
    
    