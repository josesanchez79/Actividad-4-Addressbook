import java.io.*;
import java.util.*;

public class AddressBook {


    //atributos addressbook
    private HashMap<String, String> contactos;
    private String archivo;

    //constructor usado para generar addressbook usando el hashmap y el string archivo
    public AddressBook(String archivo) {
        this.contactos = new HashMap<>();
        this.archivo = archivo;
    }


    //metodo load para cargar archivo
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String number = parts[0];
                    String name = parts[1];
                    contactos.put(number, name);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar contactos: " + e.getMessage());
        }
    }

    //metodo save para guardar cambios en contactos
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, String> entry : contactos.entrySet()) {
                String number = entry.getKey();
                String name = entry.getValue();
                writer.write(number + "," + name);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar contactos: " + e.getMessage());
        }
    }

    //metodo list para mostrar todos los contactos
    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            String number = entry.getKey();
            String name = entry.getValue();
            System.out.println(number + " : " + name);
        }
    }

    //metodo create para pedir numero y nombre de contacto y agregar al archivo
    public void create(String number, String name) {
        contactos.put(number, name);
        System.out.println("Contacto creado: " + number + " : " + name);
    }

    //metodo delete que elimina un contacto si el numero se encuentra en el hashmap
    public void delete(String number) {
        if (contactos.containsKey(number)) {
            String name = contactos.get(number);
            contactos.remove(number);
            System.out.println("Contacto eliminado: " + number + " : " + name);
        } else {
            System.out.println("No se encontró el contacto con el número: " + number);
        }
    }
}