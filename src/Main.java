import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook contactos = new AddressBook("Contactos.txt");
        contactos.load();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPor favor elige una de las siguientes opciones");
            System.out.println("1.- Mostrar contactos");
            System.out.println("2.- Crear contacto");
            System.out.println("3.- Eliminar contacto");
            System.out.println("4.- Guardar cambios");
            System.out.println("5.- Salir");

            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    contactos.list();
                    break;
                case 2:
                    System.out.print("Ingrese el numero de contacto: ");
                    String number = scanner.nextLine();
                    System.out.print("Ingrese el nombre de contacto: ");
                    String name = scanner.nextLine();
                    contactos.create(number, name);
                    break;
                case 3:
                    System.out.print("Ingrese el numero de contacto a eliminar: ");
                    String deleteNumber = scanner.nextLine();
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

        scanner.close();
    }
}
