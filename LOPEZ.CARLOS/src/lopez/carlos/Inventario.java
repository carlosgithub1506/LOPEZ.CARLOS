
package lopez.carlos;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Predicate;

public class Inventario<T extends Serializable & Comparable<T>> implements Serializable {
    private List<T> elementos;

    public Inventario() {
        elementos = new ArrayList<>();
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public void eliminar(T elemento) {
        elementos.remove(elemento);
    }

    public void listar() {
        elementos.forEach(System.out::println);
    }

    public void ordenar() {
        Collections.sort(elementos); 
    }

    public void ordenar(Comparator<? super T> comparator) {
        elementos.sort(comparator);
    }

    public List<T> filtrar(Predicate<? super T> predicado) {
        return elementos.stream().filter(predicado).toList();
    }

    public void guardarEnArchivo(String ruta) throws IOException {
        File archivo = new File(ruta);
        archivo.getParentFile().mkdirs(); 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(elementos);
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDesdeArchivo(String ruta) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            elementos = (List<T>) ois.readObject();
        }
    }

    public void guardarEnJSON(String ruta) throws IOException {
        try (Writer writer = new FileWriter(ruta)) {
            Gson gson = new Gson();
            gson.toJson(elementos, writer);
        }
    }

       public void cargarDesdeJSON(String rutaArchivo, Class<T> clazz) throws IOException {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Gson gson = new Gson();
            
            
            Type tipoLista = TypeToken.getParameterized(List.class, clazz).getType();
            
            
            List<T> listaCargada = gson.fromJson(reader, tipoLista);
            
            
            elementos.clear();
            elementos.addAll(listaCargada);
        }
    }

    public void paraCadaElemento(java.util.function.Consumer<? super T> accion) {
        elementos.forEach(accion);
    }
}
