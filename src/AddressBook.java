import java.io.*;
import java.util.*;

public class AddressBook {
    private HashMap<String, String> contactos;
    private String archivo;

    public AddressBook(String archivo) {
        this.contactos = new HashMap<>();
        this.archivo = archivo;
    }

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

    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            String number = entry.getKey();
            String name = entry.getValue();
            System.out.println(number + " : " + name);
        }
    }

    public void create(String number, String name) {
        contactos.put(number, name);
        System.out.println("Contacto creado: " + number + " : " + name);
    }

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