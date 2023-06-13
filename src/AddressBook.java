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
                    String numero = parts[0];
                    String nombre = parts[1];
                    contactos.put(numero, nombre);
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
                String numero = entry.getKey();
                String nombre = entry.getValue();
                writer.write(numero + "," + nombre);
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
            String numero = entry.getKey();
            String nombre = entry.getValue();
            System.out.println(numero + " : " + nombre);
        }
    }

    //metodo create para pedir numero y nombre de contacto y agregar al archivo
    public void create(String numero, String nombre) {
        contactos.put(numero, nombre);
        System.out.println("Contacto creado: " + numero + " : " + nombre);
    }

    //metodo delete que elimina un contacto si el numero se encuentra en el hashmap
    public void delete(String numero) {
        if (contactos.containsKey(numero)) {
            String nombre = contactos.get(numero);
            contactos.remove(numero);
            System.out.println("Contacto eliminado: " + numero + " : " + nombre);
        } else {
            System.out.println("No se encontró el contacto con el número: " + numero);
        }
    }
}