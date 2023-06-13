import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //inicializacion de objeto addressbook
        AddressBook contactos = new AddressBook("Contactos.txt");
        contactos.load();

        //inicializacion de scanner y variable para menu
        Scanner lector = new Scanner(System.in);
        boolean exit = false;


        //uso de while para mantener loop hasta que el usuario decida salir
        while (!exit) {
            System.out.println("\nPor favor elige una de las siguientes opciones");
            System.out.println("1.- Mostrar contactos");
            System.out.println("2.- Crear contacto");
            System.out.println("3.- Eliminar contacto");
            System.out.println("4.- Guardar cambios");
            System.out.println("5.- Salir");

            int opc = lector.nextInt();
            lector.nextLine();

            //uso de switch para generar menu
            switch (opc) {
                case 1:
                    contactos.list();
                    break;
                case 2:
                    System.out.print("Ingrese el numero de contacto: ");
                    String number = lector.nextLine();
                    System.out.print("Ingrese el nombre de contacto: ");
                    String name = lector.nextLine();
                    contactos.create(number, name);
                    break;
                case 3:
                    System.out.print("Ingrese el numero de contacto a eliminar: ");
                    String deleteNumber = lector.nextLine();
                    contactos.delete(deleteNumber);
                    break;
                case 4:
                    contactos.save();
                    System.out.println("Cambios guardados.");
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        }

        lector.close();
    }
}
