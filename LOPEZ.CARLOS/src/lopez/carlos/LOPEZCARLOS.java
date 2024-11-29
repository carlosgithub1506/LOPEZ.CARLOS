
package lopez.carlos;

import java.io.IOException;
import java.util.Comparator;


public class LOPEZCARLOS {

    public static void main(String[] args) {
        try {
//             crear un inventario de personajes jugables
            Inventario<Personaje> inventarioPersonajes = new Inventario<>();
            inventarioPersonajes.agregar(new Personaje(1, "Aragorn", Clase.GUERRERO, 20));
            inventarioPersonajes.agregar(new Personaje(2, "Gandalf", Clase.MAGO, 50));
            inventarioPersonajes.agregar(new Personaje(3, "Legolas", Clase.ARQUERO, 25));
            inventarioPersonajes.agregar(new Personaje(4, "Frodo", Clase.GUERRERO, 10));
            inventarioPersonajes.agregar(new Personaje(5, "Saruman", Clase.MAGO, 40));
            inventarioPersonajes.agregar(new Personaje(6, "Robin Hood", Clase.ARQUERO, 30));

//             mostrar todos los personajes en el inventario
            System.out.println("Inventario de personajes:");
            inventarioPersonajes.paraCadaElemento(personaje -> System.out.println(personaje));

//             Ordenar personajes de manera natural (por nombre)
            System.out.println("\nPersonajes ordenados por nombre (orden natural):");
            inventarioPersonajes.ordenar();
            inventarioPersonajes.paraCadaElemento(personaje -> System.out.println(personaje));

//             Ordenar personajes por nivel utilizando un Comparator
            System.out.println("\nPersonajes ordenados por nivel:");
            inventarioPersonajes.ordenar(Comparator.comparingInt(Personaje::getNivel));
            inventarioPersonajes.paraCadaElemento(personaje -> System.out.println(personaje));

//             Filtrar personajes de clase MAGO
            System.out.println("\nPersonajes de la clase MAGO:");
            inventarioPersonajes.filtrar(personaje -> personaje.getClase() == Clase.MAGO)
                .forEach(personaje -> System.out.println(personaje));

//             Guardar el inventario en un archivo binario
            inventarioPersonajes.guardarEnArchivo("src/data/personajes.dat");

//             Cargar el inventario desde el archivo binario
            Inventario<Personaje> inventarioCargado = new Inventario<>();
            inventarioCargado.cargarDesdeArchivo("src/data/personajes.dat");
            System.out.println("\nPersonajes cargados desde archivo binario:");
            inventarioCargado.paraCadaElemento(personaje -> System.out.println(personaje));

//             Guardar el inventario en un archivo JSON
            inventarioPersonajes.guardarEnJSON("src/data/personajes.json");

//          Cargar el inventario desde el archivo JSON
        inventarioCargado.cargarDesdeJSON("src/data/personajes.json", Personaje.class);
        System.out.println("\nPersonajes cargados desde archivo JSON:");
        inventarioCargado.paraCadaElemento(personaje -> System.out.println(personaje));



        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    
}


  
