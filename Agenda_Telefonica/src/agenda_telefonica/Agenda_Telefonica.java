package agenda_telefonica;

import java.util.Scanner;

public class Agenda_Telefonica {

    static int contador = 0;
    static Contacto nuevoContactos[] = new Contacto[15];

    public static void main(String[] args) {
        //
        Scanner entrada = new Scanner(System.in);
        int op = 0;
        System.out.println("____________AGENDA TELEFONICA____________");
        System.out.println("__________Biendonido_______");

        do {
            System.out.println("    1. Guardar Contacto");
            System.out.println("    2. Ver Todos Los Contactos");
            System.out.println("    3. Buscar Un Contacto");
            System.out.println("    4. Actulizar Contacto");
            System.out.println("    5. Salir");
            System.out.println("Ingrese el Numero de Opcion");
            System.out.println("----------------------------------");

            op = entrada.nextInt();
            switch (op) {
                case 1:
                    crearContacto();
                    break;

                case 2:
                    System.out.println("------------Los_Datos_Son----------------");
                    verTodo();
                    break;

                case 3:
                    Scanner salir = new Scanner(System.in);
                    System.out.println("------------Buscar_Numero----------------");
                    System.out.println("_________Ingrese El Numero__________");
                    String Telefono = salir.nextLine();
                    System.out.println(buscarContacto(Telefono));

                    break;
                case 4:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("------------Buscar_Numero----------------");
                    System.out.println("_________Ingrese El Nombre__________");
                    String Nombre = sc.nextLine();
                    System.out.println(actulizarContacto(Nombre));
                    break;

                case 5:
                    System.out.println("");
                    System.out.println("_______Finalizado______");
                    System.out.println("");
                    break;

            }
        } while (op != 5);

    }

    static public void crearContacto() {
        if (contador >= 15) {
            System.out.println("La Memoria Esta Llena");
        } else {

            Scanner teclado = new Scanner(System.in);
            System.out.println("-------------NUEVO_NUMERO-------------");
            System.out.println("______Ingrese El Numero de Telefono____________");
            String Telefono = teclado.nextLine();
            System.out.println("______Ingrese Nombre Del Contacto_______");
            String Nombre = teclado.nextLine();
            System.out.println("______Ingrese El Domicilio_______");
            String Domicilio = teclado.nextLine();
            nuevoContactos[contador] = new Contacto(Telefono, Nombre, Domicilio);
            System.out.println("_______________Datos Almacenados_____________");
            contador++;
        }
    }

    static public void verTodo() {

        for (int i = 0; i < contador; i++) {
            System.out.println("Telefono: " + nuevoContactos[i].verTelefono());
            System.out.println("Nombre: " + nuevoContactos[i].verNombre());
            System.out.println("Domicilio: " + nuevoContactos[i].verDomicilio());
            System.out.println("#############################################");
        }
    }

    static public String buscarContacto(String Telefono) {
        int posicion = -1;
        for (int i = 0; i < 15; i++) {
            if (nuevoContactos[i] != null) {

                if (nuevoContactos[i].verTelefono().equals(Telefono)) {
                    posicion = i;
                    break;
                }
            }
        }

        if (posicion != -1) {
            return "Nombre: " + nuevoContactos[posicion].verNombre() + "  Domicilio: " + nuevoContactos[posicion].verDomicilio();

        } else {
            return "*Contacto No Encontrado*";

        }
    }
    
    static public String actulizarContacto(String nombre) {
        Scanner sc = new Scanner(System.in);

        int posicion = -1;
        for (int i = 0; i < 10; i++) {
            if (nuevoContactos[i] != null) {
                if (nuevoContactos[i].verNombre().equals(nombre)) {
                    System.out.println("Ingrese Nuevo Numero Telefono");
                    String Telefono = sc.nextLine();
                    nuevoContactos[i].setTelefono(Telefono);
                    System.out.println("Ingrese Nuevo Domicilio");
                    String  Domicilio = sc.nextLine();
                    nuevoContactos[i].setDomicilio(Domicilio);
                    posicion = i;
                    break;
                }

            }
        }
        if (posicion != -1) {
            return "Materia: " + nuevoContactos[posicion];
        } else {
            return "Profesor No Encontrado";

        }
    }

}
