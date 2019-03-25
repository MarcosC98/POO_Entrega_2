package Beyond_memories;

import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static boolean privacidad;
    public static boolean a = true;
    public static boolean existeCementerio = false;
    public static boolean noValido = true;
    public static boolean excluido = true;
    public static boolean valido;
    public static boolean pedirCementerio = true;
    public static boolean realizarIngreso = true;
    public static boolean doit = true;
    public static int id;
    public static String entrada;
    public static String idiom;

    public static void main(String[] args) {

        //DATOS FICTICIOS:
        Cementerio cementerio1 = new Cementerio(1, "Beyond Memories", (short) 50, "Calle 24 #45a-54 ");
        Cementerio cementerio2 = new Cementerio(2, "San Lorenzo", (short) 50, "Boston/Prado");
        Persona persona1 = new Persona("Simona", 1010, "19/06/2017", cementerio1);
        Persona persona2 = new Persona("Luna", 1011, "18/02/2013", cementerio1);
        Persona persona3 = new Persona("Leonor", 1111, "Nacimiento", cementerio1);
        Moderador moderador1 = new Moderador("David", 1090514247, "23/02/1998", "456", cementerio1);
        Moderador moderador2 = new Moderador("Mario", 1010215392, "13/06/1994", "666", cementerio2);
        Moderador moderador3 = new Moderador("Marcos", 1090514246, "23/02/1998", "123", cementerio1);
        Ubicacion ubicacion1 = new Ubicacion(1, cementerio1);
        Ubicacion ubicacion2 = new Ubicacion(2, cementerio1);
        Lapida lapida1 = new Lapida(persona3, true, ubicacion1, cementerio1, "", "");
        Lapida lapida2 = new Lapida(moderador2, true, ubicacion2, cementerio1, "", "");
        Cliente cliente1 = new Cliente(moderador1, "789", lapida1);
        Cliente cliente2 = new Cliente(persona1, "963", lapida2);

        //Marcos tuve que cambiar lo del orden de las cosas aquí...más que nada para hacer más legible el código.
        //No cambié nada de funcionalidad.
        //Tratemos de que solo haya un Try por While dentro de este Main.
        //Se pueden crear 2 clientes con la misma lápida.
        Texto.presentacion();
        idiom = input.next();
        Texto.setIdiom(idiom);
        Cementerio cementerio = null;

        while (a == true) {

            if (pedirCementerio == true) {
                cementerio = Main.ingresoCementerio();
            }

            if (realizarIngreso == true) {
                Main.ingresoID();
            }

            if (Moderador.modExiste(id, cementerio) == true) {
                Moderador mod = Moderador.buscarModerador(id);
                if(Cliente.clienteExiste(id, cementerio)){
                    System.out.println("Menu para que elija si entrar como moderador o cliente.");//Moderador y cliente a la vez.
                    a=false;//Este solo se colocó para que rompa el ciclo.
                }
                else{
                    Main.menuMod(mod);//Si solo es moderador.
                }
                
            // Lanzamiento para Menú de Clientes.
            } else if (Cliente.clienteExiste(id, cementerio) == true) {
                Cliente cliente = Cliente.buscarCliente(id);
                Main.menuCliente(cliente);
                
            //Lanzamiento para Menú de Visitante.TERMINADO CON BUGS.
            } else if (Persona.visitanteExiste(id, cementerio) == true) {
                Persona visitante = Persona.buscarPersona(id);
                Main.menuVisitante(visitante);

            // Lanzamiento para primer ingreso. ELABORADO PERO FALTAR IMPLEMENTAR.
            } else {
                System.out.println("PrimerIngreso");
                Main.nuevoIngreso(noValido, cementerio);
            }
        }
    }

    public static void ingresoID() {
        valido = false;
        while (valido == false) {
            System.out.println(" ");
            System.out.println("Por favor ingrese el número de su documento de identificación a continuación: ");
            System.out.println(" ");
            try {
                id = input.nextInt();
                System.out.println("Si entra el dato.");//Esto es una comprobación que hice.
                realizarIngreso = false;
                valido = true;
            } catch (Exception e) {
                System.out.println("Dato ingresado no valido");
                System.out.println(" ");
            }

        }
    }

    public static void menuMod(Moderador mod) {
        while (doit == true) {
            System.out.println(" ");
            System.out.println("Ingrese el numero de la opción a realizar");
            System.out.println(" ");
            System.out.println("1. Ver mi Tumba."); // Solo muestra la información de mi tumba(Lapida y Ubicación).
            System.out.println("2. Modificar mi Tumba.");// Muestra otro menú para acciones con la propia tumba.
            System.out.println("2. Ver Listado Tumba."); //Método por confirmar.
            System.out.println("3. Buscar Allegado."); // 
            System.out.println("4. Saber más acerca de mi cementerio.");
            System.out.println("5. Ingresar con otro documento."); 
            System.out.println("6. Ingresar a otro cementerio.");
            System.out.println("7. Salir");
            System.out.println(" ");
            System.out.println("Su Seleccion:");
            entrada = input.next();
            try {
                int opcion = Integer.parseInt(entrada);
                Cementerio cementerio = mod.getCementerio();
                if (opcion <= 0 || opcion > 7) {
                    throw new Exception();
                } else {
                    switch (opcion) {
                        case 1:
                            break;
                        case 2:
                            System.out.println("Menú para modificar la propia lápida.");
                        case 3:
                            Main.imprimirLapidas(cementerio);
                            break;
                        case 4:
                            System.out.println("Mostrar allegados");//Todavía estoy pensando si añadirlo o no.
                            break;
                        case 5:
                            System.out.println("Imprime información del cementerio...blablabla");
                            break;
                        case 6:
                            doit = false;
                            pedirCementerio = false;
                            realizarIngreso = true;
                            break;
                        case 7:
                            doit = false;
                            realizarIngreso = true;
                            pedirCementerio = true;
                            break;
                        case 8:
                            doit = false;
                            a = false;
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opción valida por favor");
            }
        }
    }

    public static void menuCliente(Cliente cliente) {
        while (doit == true) {
            System.out.println(" ");
            System.out.println("Ingrese el numero de la opción a realizar");
            System.out.println(" ");
            System.out.println("1. Ver mi Tumba."); // Solo muestra la información de mi tumba(Lapida y Ubicación).
            System.out.println("2. Modificar mi Tumba.");// Muestra otro menú para acciones con la propia tumba.
            System.out.println("2. Ver Listado Tumba."); //Método por confirmar.
            System.out.println("3. Buscar Allegado."); // 
            System.out.println("4. Saber más acerca de mi cementerio.");
            System.out.println("5. Ingresar con otro documento."); 
            System.out.println("6. Ingresar a otro cementerio.");
            System.out.println("7. Salir");
            System.out.println(" ");
            System.out.println("Su Seleccion:");
            entrada = input.next();
            try {
                int opcion = Integer.parseInt(entrada);
                Cementerio cementerio = cliente.getCementerio();
                if (opcion <= 0 || opcion > 7) {
                    throw new Exception();
                } else {
                    switch (opcion) {
                        case 1:
                            Lapida l = cliente.getLapida();
                            Main.miLapida(cliente,l);
                            break;
                        case 2:
                            System.out.println("Menú para modificar la propia lápida.");
                        case 3:
                            Main.imprimirLapidas(cementerio);
                            break;
                        case 4:
                            System.out.println("Mostrar allegados");//Todavía estoy pensando si añadirlo o no.
                            break;
                        case 5:
                            System.out.println("Imprime información del cementerio...blablabla");
                            break;
                        case 6:
                            doit = false;
                            pedirCementerio = false;
                            realizarIngreso = true;
                            break;
                        case 7:
                            doit = false;
                            realizarIngreso = true;
                            pedirCementerio = true;
                            break;
                        case 8:
                            doit = false;
                            a = false;
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opción valida por favor");
            }
        }
    }

    public static void menuVisitante(Persona persona) {
        while (doit == true) {
            System.out.println(" ");
            System.out.println("Ingrese el numero de la opción a realizar");
            System.out.println(" ");
            System.out.println("1. Adquirir Lapida");//Está el problema de los NextLine...porque también está tomando el "Enter" como un comando de entrada y está dejando vacío los epitafios. Si se pone como Next está el problema del interespaciado.
            System.out.println("2. Mapa del Cementerio");
            System.out.println("3. Escribir Memoria");
            System.out.println("4. Leer Lapida");//Acá hay un bug cuando se coloca un dato invalido en documento, imprime luego dos veces este el MenuVisitante.
            System.out.println("5. Saber más acerca del cementerio.");//Este lo coloco porque nos va a ser de utilidad en un futuro en la aplicación Web.
            System.out.println("6. Ingresar a otro perfil con otro documento.");//Dentro del mismo cementerio.
            System.out.println("7. Ingresar a otro cementerio.");
            System.out.println("8. Salir");
            System.out.println(" ");
            System.out.println("Su Seleccion:");
            entrada = input.next();
            try {
                int opcion = Integer.parseInt(entrada);
                Cementerio cementerio = persona.getCementerio();
                if (opcion <= 0 || opcion > 8) {
                    throw new Exception();
                } else {
                    switch (opcion) {
                        case 1:
                            Cliente nuevoCliente = Main.adquirirLapida(cementerio, persona);
                            doit=false;
                            pedirCementerio=false;
                            realizarIngreso=false;
                            
                            break;
                        case 2:
                            Main.imprimirLapidas(cementerio);
                            break;
                        case 3:
                            Main.escribirMemoria(cementerio);
                            break;
                        case 4:
                            Main.mostrarLapida(cementerio);//Hay un error cuando se ingresa un dato invalido, imprime dos veces el menúVisitante.
                            break;
                        case 5:
                            System.out.println("Imprime información del cementerio...blablabla");
                            break;
                        case 6:
                            doit = false;
                            pedirCementerio = false;
                            realizarIngreso = true;
                            break;
                        case 7:
                            doit = false;
                            realizarIngreso = true;
                            pedirCementerio = true;
                            break;
                        case 8:
                            doit = false;
                            a = false;
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opción valida por favor");
            }
        }

    }

    public static void nuevoIngreso(boolean noValido, Cementerio cementerio) {
        System.out.println("Ingrese su documento");//Depronto esto sobra porque previamente ya se pregunto por documento, ya lo arreglaré con tiempo.
        while (noValido == true) {
            entrada = input.next();
            try {
                int documento = Integer.parseInt(entrada);
                if (documento < 0) {
                    throw new Exception();
                } else {
                    Moderador moderador = Moderador.buscarModerador(documento);
                    Cliente cliente = Cliente.buscarCliente(documento);
                    //Persona visitante = Persona.buscaVisitante(documento,cementerio);
                    if (moderador == null && cliente == null /* && visitante == null */) {
                        System.out.println(" ");
                        System.out.println("No hay ninguna cuenta registrada con este documento");
                        System.out.println("Si desea crear una cuenta nueva con este documento, ingrese 0");
                        System.out.println("Si desea intentar ingresar con un documento distinto, ingrese 1");
                        System.out.println("Si desea seleccionar un cementerio distinto, ingrese 2");
                        System.out.println(" ");
                        excluido = true;
                        while (excluido == true) {
                            entrada = input.nextLine();
                            if (entrada.equals("0") || entrada.equals("1") || entrada.equals("2")) {
                                switch (entrada) {
                                    case "0":
                                        while (true) {
                                            System.out.println("Ingrese su nombre completo por favor");
                                            String nombre = input.nextLine();
                                            System.out.println("Ingrese su fecha de nacimiento en formato dd/mm/yyyy");
                                            String fechaNac = input.nextLine();

                                            if (!fechaNac.isEmpty() && !nombre.isEmpty()) {
                                                Persona visitante = new Persona(nombre, documento, fechaNac, cementerio);
                                                Persona.mostrarPersona(visitante);
                                                menuVisitante(visitante);
                                                noValido = false;
                                                excluido = false;
                                                a = false;
                                                break;
                                            } else {
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
                            } else if (entrada.equals("")) {
                            } else {
                                System.out.println(" ");
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

    public static void miLapida(Persona persona, Lapida lapida) {
        System.out.println(" ");
        System.out.println("---LAPIDA DE " + persona.getNombre() + " ---");
        System.out.println("Epitafio: " + lapida.getEpitafio());
        System.out.println(persona.getFechaNac() + " - " + lapida.getFechaDef());
        System.out.println("Indice: " + lapida.getUbicacion().getIndice());
        System.out.println("Cementerio: " + persona.getCementerio().getNombre());
        System.out.println(" ");
        //Adicionar las memorias aquí.
    }

    public static void mostrarLapida(Cementerio cementerio) {
        while (true) {
            System.out.println("Por favor ingrese el documento de la persona dueña de la tumba que desea ver:");
            int doc = input.nextInt();
            if (Cliente.clienteExiste(doc, cementerio)) {
                Cliente c = Cliente.buscarCliente(doc);
                Lapida l = c.getLapida();
                System.out.println(" ");
                System.out.println("---LAPIDA DE: " + c.getNombre() + " ---");
                System.out.println("Epitafio: " + l.getEpitafio());
                System.out.println(c.getFechaNac() + " - " + l.getFechaDef());
                System.out.println("Indice: " + l.getUbicacion().getIndice());
                System.out.println("Cementerio: " + c.getCementerio().getNombre());
                System.out.println(" ");
                break;
            } else {
                System.out.println("No hay nadie registrado con esta tumba.");
                break;
            }

        }
    }

    public static void imprimirLapidas(Cementerio cementerio) {

        System.out.println("LISTADO DE LAPIDAS EN EL CEMENTERIO " + cementerio.getNombre());
        System.out.println(" ");
        for (Lapida l : Lapida.lapidas) {
            System.out.println("Aquí yace:" + l.getDueno().getDocumento() + "---" + l.getDueno().getNombre() + " --- Ubicado en la cripta Número: " + l.getIndiceU());
        }
    }

    public static void mostrarCliente(Cliente cliente, Cementerio cementerio) {
        if (Cliente.clientes.contains(cliente)) {
            Persona.mostrarPersona(cliente);
            System.out.println("Tipo de perfil: Cliente");
            //Main.mostrarLapida(cliente, cliente.getLapida());
        } else {
            System.out.println("No existe información de este cliente en este cementerio");
        }
    }

    public static void escribirMemoria(Cementerio cementerio) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el documento de la persona dueña de la lapida");
        String entrada = input.nextLine();
        try {
            int documento = Integer.parseInt(entrada);
            if (documento <= 0) {
                throw new Exception();
            }
            Cliente cliente = Cliente.buscarCliente(documento);
            if (cliente == null) {
                System.out.println("No existe un cliente con ese documento");
            } else {

            }
        } catch (Exception e) {
            System.out.println("Ingrese un documento valido");
        }

    }

    public static Cliente adquirirLapida(Cementerio cementerio, Persona persona) {
        System.out.println(" ");
        System.out.println("---BIENVENIDO A LA CREACION DE LAPIDA---");
        System.out.println(" ");
        System.out.println("Ingrese la contraseña que desea para su lapida: ");
        while (true) {
            String contrasena = input.next();
            System.out.println(" ");
            System.out.println("Ingrese el epitafio que desea para su lapida");
            String epitafio = input.next();
            System.out.println(" ");
            System.out.println("Ingrese la privacidad que desea para su lapida:");
            System.out.println(" ");
            System.out.println("   0. para publica.");
            System.out.println("   1. para privado.");
            System.out.println(" ");
            System.out.println("Su Selección: ");
            while (true) {
                String entrada = input.next();
                if (!entrada.isEmpty() && entrada.equals("1") || entrada.equals("0")) {
                    if (entrada == "1") {
                        privacidad = true;
                        break;
                    } else {
                        privacidad = false;
                        break;
                    }
                } else {
                    System.out.println("Ingrese una opción valida.");
                }
            }

            System.out.println("Ingrese la ubicación donde desea que esté su lapida.");
            while (true) {
                entrada = input.next();
                try {
                    int indice = Integer.parseInt(entrada);
                    if (Ubicacion.revisarDisponibilidadUbicacion(cementerio, indice)) {
                        Ubicacion ubicacion = new Ubicacion(indice, cementerio);
                        Lapida lapida = new Lapida(persona, privacidad, ubicacion, cementerio, epitafio, "");
                        Cliente cliente = new Cliente(persona, contrasena, lapida);
                        Main.mostrarCliente(cliente, cementerio);
                        System.out.println("");
                        Main.miLapida(cliente,lapida);
                        return cliente;
                    } else {
                        System.out.println("Esta ubicación no está disponible, ingrese una distinta");
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese una ubicación valida");
                }
            }
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
                    pedirCementerio = false;
                    return cementerio;
                }
            } catch (Exception x) {
                System.out.println("Ingrese un id de cementerio valido por favor");
            }
        }
    }

}
