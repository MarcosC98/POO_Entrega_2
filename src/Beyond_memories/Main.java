package Beyond_memories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //DATOS FICTICIOS:
        Cementerio cementerio1 = new Cementerio(1, "Beyond Memories", (short) 50, "Calle 24 #45a-54 ");
        Moderador moderador1 = new Moderador("David", 1090514247, "23/02/1998", "456", cementerio1);
        Moderador moderador2 = new Moderador("Mario", 1010215392, "13/06/1994", "666", cementerio1);
        Moderador moderador3 = new Moderador("Marcos", 1090514246, "23/02/1998", "123", cementerio1);
        Ubicacion ubicacion1 = new Ubicacion(1, cementerio1);
        Lapida lapida1 = new Lapida(moderador1, false, ubicacion1, cementerio1, "", "");
        Cliente cliente1 = new Cliente(moderador1.getNombre(), moderador1.getDocumento(), moderador1.getFechaNac(), "789", lapida1);

        System.out.println("Bienvenido al sistema de administración para cementerios");
        System.out.println("Ingrese el cementerio al cual desea entrar");
        Cementerio.imprimirCementerios();
        while (true) {
            String entrada = input.next();
            try {
                int ent = Integer.parseInt(entrada);
                while (true) {
                    Cementerio ce = Cementerio.buscarCementerio(ent);
                    if (ce != null) {
                        System.out.println("Ha ingresado al sistema del cementerio " + ce.getNombre());
                        System.out.println("Ingrese su documento");
                        while (true) {
                            entrada = input.next();
                            try {
                                int documento = Integer.parseInt(entrada);
                                while(true){
                                    if(documento>0){
                                        Moderador m = Moderador.buscarModerador(documento);
                                        Cliente c = Cliente.buscarCliente(documento);
                                        if (m == null && c == null) {
                                            System.out.println("No hay ninguna cuenta registrada");

                                        }
                                    }
                                    else{
                                        System.out.println("Por favor ingrese un numero positivo");
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Ingrese un número");
                            }

                        }
                    } else {
                        System.out.println("No hay ningún cementerio con ese Id, ingrese un id valido");
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Ingrese un número");
            }
        }

    }
}
