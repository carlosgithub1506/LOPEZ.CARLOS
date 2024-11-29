
package lopez.carlos;


import com.google.gson.Gson;
import java.io.Serializable;


public class Personaje implements Serializable, Comparable<Personaje> {
    private int id;
    private String nombre;
    private Clase clase;
    private int nivel;

    // Constructor
    public Personaje(int id, String nombre, Clase clase, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Clase getClase() {
        return clase;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Clase: " + clase + ", Nivel: " + nivel;
    }

    @Override
    public int compareTo(Personaje otro) {
        return this.nombre.compareTo(otro.nombre); // Orden natural por nombre
    }

    // metodo estatico fromJSON para deserializar desde JSON
    public static Personaje fromJSON(String json) {
        // Implementar deserialización desde JSON
        return new Gson().fromJson(json, Personaje.class);
    }
}

