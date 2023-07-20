package agenda_telefonica;

import java.util.Scanner;

public class Agenda_Telefonica {

    static int contador = 0;
    static Contacto nuevoContactos[] = new Contacto[15];

    public static void main(String[] args) {
        //Agenda Telefonica con arreglos unidimencionales
        Scanner entrada = new Scanner(System.in);
        int op = 0;
        //Menu
        System.out.println("____________AGENDA TELEFONICA____________");
        System.out.println("__________Biendonido_______");
        try {
            do {
                //Menu
                System.out.println("");
                System.out.println("    1. Guardar Contacto");
                System.out.println("    2. Ver Todos Los Contactos");
                System.out.println("    3. Buscar Un Contacto");
                System.out.println("    4. Actulizar Contacto");
                System.out.println("    5. Salir");
                System.out.println("Ingrese el Numero de Opcion");
                System.out.println("----------------------------------");

                op = entrada.nextInt();
                System.out.println("");
                switch (op) {
                    case 1:
                        crearContacto();
                        break;

                    case 2:
                        System.out.println("------------LOS_DATOS_SON----------------");
                        System.out.println("");
                        verTodo();
                        break;

                    case 3:
                        Scanner salir = new Scanner(System.in);
                        System.out.println("------------BUSCAR_NUMERO----------------");
                        System.out.println("");
                        System.out.println("_________Ingrese El Numero__________");
                        String Telefono = salir.nextLine();
                        System.out.println(buscarContacto(Telefono));

                        break;
                    case 4:
                        Scanner sc = new Scanner(System.in);
                        System.out.println("------------ACTULIZAR_CONTACTO----------------");
                        System.out.println("");
                        System.out.println("_________Ingrese El Numero__________");
                        String Numero = sc.nextLine();
                        System.out.println(actulizarContacto(Numero));
                        break;

                    case 5:
                        System.out.println("");
                        System.out.println("_______Finalizado______");
                        System.out.println("");
                        break;

                    default:
                        System.out.println("!!!-Solo Numeros Entre 1 y 5-!!!");

                }

            } while (op != 5);
        } catch (Exception e) {
            System.out.println("-Debe Insertar Un Numero-!!!!");
        }

    }
    //Funciones
     //Un metodo para crear un nuevo contacto
    static public void crearContacto() {
        if (contador >= 15) {
            System.out.println("La Memoria Esta Llena");
        } else {

            Scanner teclado = new Scanner(System.in);
            System.out.println("-------------NUEVO_NUMERO-------------");
            System.out.println("");
            System.out.println("______Ingrese El Numero de Telefono____________");
            System.out.println("----------------------");
            String Telefono = teclado.nextLine();
            System.out.println("----------------------");
            System.out.println("______Ingrese Nombre Del Contacto_______");
            System.out.println("-----------------------");
            String Nombre = teclado.nextLine();
            System.out.println("-----------------------");
            System.out.println("______Ingrese El Domicilio_______");
            System.out.println("------------------------");
            String Domicilio = teclado.nextLine();
            System.out.println("------------------------");
            nuevoContactos[contador] = new Contacto(Telefono, Nombre, Domicilio);
            System.out.println("_______________Datos Almacenados_____________");
            contador++;
        }
    }
    //Metodo para ver los 3 parametros
    static public void verTodo() {
        System.out.println("#################################################");
        for (int i = 0; i < contador; i++) {
            System.out.println("Telefono: " + nuevoContactos[i].verTelefono());
            System.out.println("Nombre: " + nuevoContactos[i].verNombre());
            System.out.println("Domicilio: " + nuevoContactos[i].verDomicilio());
            System.out.println("###############################################");
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
      //Base de datos para actulizarlo con los anteriores
    static public String actulizarContacto(String nombre) {

        Scanner sc = new Scanner(System.in);

        int posicion = -1;
        for (int i = 0; i < 15; i++) {
            if (nuevoContactos[i] != null) {
                if (nuevoContactos[i].verNombre().equals(nombre)) {
                    System.out.println("Ingrese El Nuevo Nombre");
                    String Nombre = sc.nextLine();
                    nuevoContactos[i].setNombre(Nombre);
                    System.out.println("Ingrese Nuevo Domicilio");
                    String Domicilio = sc.nextLine();
                    nuevoContactos[i].setDomicilio(Domicilio);
                    posicion = i;
                    break;
                }

            }
        }
        if (posicion != -1) {
            return "____Se_A__Actulizado_El_Contacto___";

        } else {
            return "Contacto_No_Encontrado";

        }

    }

}
