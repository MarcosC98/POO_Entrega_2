package Beyond_memories;

import java.util.Scanner;
public class Main {

    public static boolean existeCementerio = false;
    public static boolean noValido = true;
    public static boolean excluido = true;
    public static String entrada;
    public static String idiom;
    static Scanner input = new Scanner(System.in);
    static boolean a = true;
    
    public static void mostrarLapida(Lapida lapida){
        System.out.println("---LAPIDA DE " + lapida.getDueno().getNombre() + " ---");
        System.out.println("Epitafio: " + lapida.getEpitafio());
        System.out.println(lapida.getDueno().getFechaNac() + " - " + lapida.getFechaDef());
        System.out.println("Indice: " +lapida.getUbicacion().getIndice());
        System.out.println("Cementerio: " + lapida.getCementerio().getNombre());
        System.out.println(" ");
    }
    
    public static void mostrarCliente(Cliente cliente,Cementerio cementerio){
        if(cementerio.clientes.contains(cliente)){
            Persona.mostrarPersona(cliente, cementerio);
            System.out.println("Tipo de perfil: Cliente");
            Main.mostrarLapida(cliente.getLapida());
    }else{
            System.out.println("No existe información de este cliente en este cementerio");  
        }
    }
    
    public static void escribirMemoria(Cementerio cementerio){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el documento de la persona dueña de la lapida");
        String entrada = input.nextLine();
        try{
            int documento = Integer.parseInt(entrada);
            if(documento<=0){
                throw new Exception();
            }
            Cliente cliente = Cliente.buscarCliente(documento, cementerio);
            if(cliente == null){
                System.out.println("No existe un cliente con ese documento");
            }else{
                
            }
        }catch(Exception e){
            System.out.println("Ingrese un documento valido");
        }
        
    }

    public static void opcionesVisitante(Persona persona,Cementerio cementerio){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Ingrese el numero de la opción a realizar");
            System.out.println("1. Adquirir Lapida");
            System.out.println("2. Escribir Memoria");
            System.out.println("3. Leer Lapida");
            System.out.println("4. Ingresar con otro perfil");
            System.out.println("5. Ingresar a otro cementerio");
            System.out.println("6. Salir");
            String entrada = input.next();
            try{
                int opcion = Integer.parseInt(entrada);
                if(opcion<=0 || opcion >6){
                    throw new Exception();
                }else{
                    switch(opcion){
                        case 1:
                            Main.adquirirLapida(cementerio,persona);
                            break;
                        case 2:
                            Main.escribirMemoria(cementerio);
                            break;
                        case 3:
                            System.out.println("opcion3");
                            break;
                        case 4:
                            System.out.println("opcion4");
                            break;
                        case 5:
                            System.out.println("opcion5");
                            break;
                        case 6:
                            System.out.println("opcion6");
                            break;
                    }
                }
            }catch(Exception e){
                System.out.println("Ingrese una opción valida por favor");
            }
        }

    }
    
    public static void adquirirLapida(Cementerio cementerio,Persona persona){
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido al menú de creación de lapida");
        System.out.println("Ingrese la contraseña que desea para su lapida");
        while (true){
            String contrasena = input.nextLine();
            if (contrasena.isEmpty()){
                System.out.println("La contraseña no puede estar vacía");
            }else{
                System.out.println("Ingrese el epitafio que desea para su lapida");
                String epitafio = input.nextLine();
                System.out.println("Ingrese la privacidad que desea para su lapida, 0 para publica, 1 para privado");
                while(true){
                    String entrada = input.nextLine();
                    if(!entrada.isEmpty() && entrada.equals("1") || entrada.equals("0")){
                   boolean privacidad;
                   if(entrada=="1"){
                       privacidad = true;
                   }else{
                       privacidad = false;
                   }
                   System.out.println("Ingrese la ubicación donde desea que esté su lapida");
                   while(true){
                       entrada = input.next();
                       try{
                           int indice = Integer.parseInt(entrada);
                           if(Cementerio.revisarDisponibilidadUbicacion(cementerio, indice)){
                               Ubicacion ubicacion = new Ubicacion(indice,cementerio);
                               Lapida lapida = new Lapida(persona,privacidad,ubicacion,cementerio,epitafio,"");
                               Cliente cliente = new Cliente(persona,contrasena,lapida);
                               Main.mostrarCliente(cliente, cementerio);
                               break;
                           }else{
                               System.out.println("Esta ubicación no está disponible, ingrese una distinta");
                           }
                       }catch(Exception e){
                           System.out.println("Ingrese una ubicación valida");
                       }
                   }
                   break;
               }else{
                        System.out.println("Ingrese una opción valida");
                    }
                }
                break;
            }
        }
        
    }

    public static void main(String[] args) {

        //DATOS FICTICIOS:
        Cementerio cementerio1 = new Cementerio(1, "Beyond Memories", (short) 50, "Calle 24 #45a-54 ");
        Moderador moderador1 = new Moderador("David", 1090514247, "23/02/1998", "456", cementerio1);
        Moderador moderador2 = new Moderador("Mario", 1010215392, "13/06/1994", "666", cementerio1);
        Moderador moderador3 = new Moderador("Marcos", 1090514246, "23/02/1998", "123", cementerio1);
        Ubicacion ubicacion1 = new Ubicacion(1, cementerio1);
        Lapida lapida1 = new Lapida(moderador1, false, ubicacion1, cementerio1, "", "");
        Cliente cliente1 = new Cliente(moderador1,"789", lapida1);

        //Marcos tuve que cambiar lo del orden de las cosas aquí...más que nada para hacer más legible el código.
        //No cambié nada de funcionalidad.
        //Tratemos de que solo haya un Try por While dentro de este Main.
        while (a == true) {
            Texto.presentacion();
            idiom = input.next();
            Texto.setIdiom(idiom);
            Cementerio cementerio = Main.ingresoCementerio();
            Main.nuevoIngreso(noValido,cementerio);
        }
    }

    public static Cementerio ingresoCementerio() {
        System.out.println("Ingrese el id del cementerio al cual desea entrar");        
        while (true) {
            Cementerio.imprimirCementerios();
            entrada = input.next();
            try {
                int idCementerio = Integer.parseInt(entrada);
                Cementerio cementerio = Cementerio.buscarCementerio(idCementerio);
                if (cementerio == null) {
                    throw new Exception();
                } else {
                    System.out.println("Ha ingresado a la base de datos del cementerio: " + cementerio.getNombre());
                    return cementerio;
                }
            } catch (Exception x) {
                System.out.println("Ingrese un id de cementerio valido por favor");
            }
        }
    }

    public static void nuevoIngreso(boolean noValido,Cementerio cementerio) {
        System.out.println("Ingrese su documento");
        while (noValido == true) {
            entrada = input.next();
            try {
                int documento = Integer.parseInt(entrada);
                if (documento < 0) {
                    throw new Exception();
                } else {
                    Moderador moderador = Moderador.buscarModerador(documento,cementerio);
                    Cliente cliente = Cliente.buscarCliente(documento,cementerio);
                    //Persona visitante = Persona.buscaVisitante(documento,cementerio);
                    if (moderador == null && cliente == null /* && visitante == null */) {
                        System.out.println(" ");
                        System.out.println("No hay ninguna cuenta registrada con este documento");
                        System.out.println("Si desea crear una cuenta nueva con este documento, ingrese 0");
                        System.out.println("Si desea intentar ingresar con un documento distinto, ingrese 1");
                        System.out.println("Si desea seleccionar un cementerio distinto, ingrese 2");
                        excluido = true;
                        while (excluido == true) {
                            entrada = input.nextLine();
                            if (entrada.equals("0") || entrada.equals("1") || entrada.equals("2")) {
                                switch (entrada) {
                                    case "0":
                                        while(true){
                                            System.out.println("Ingrese su nombre completo por favor");
                                            String nombre = input.nextLine();
                                            System.out.println("Ingrese su fecha de nacimiento en formato dd/mm/yyyy");
                                            String fechaNac = input.nextLine();
                                            
                                            if(!fechaNac.isEmpty() && !nombre.isEmpty()){
                                                Persona visitante = new Persona(nombre, documento, fechaNac,cementerio);
                                                Persona.mostrarPersona(visitante,cementerio);
                                                opcionesVisitante(visitante,cementerio);
                                                noValido = false;
                                                excluido = false;
                                                a = false;
                                                break;
                                            }else{
                                                System.out.println("Por favor ingrese los datos completos");
                                                System.out.println("  ");
                                            }
                                        }
                                    case "1":
                                        System.out.println("Ingrese su documento");
                                        excluido = false;
                                        break;
                                    case "2":
                                        cementerio = Main.ingresoCementerio();
                                        System.out.println("Ingrese su documento");
                                        excluido = false;
                                        break;
                                }
                            }else if(entrada.equals("")){
                            }
                            else {
                                System.out.println("Ingrese una opción válida por favor");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese un documento valido");
            }
        }
    }
}
