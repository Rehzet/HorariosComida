import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comida {

    //TODO hacer que algunas comidas sean repetibles a lo largo de la semana.

    private static int id = 0;
    private final int myId;

    private String nombre;
    private List<String> categorias;
    private String tipo;
    private String receta;

    public Comida(String nombre, String categorias, String tipo, String receta) {
        this.nombre = nombre;
        catToList(categorias);
        this.tipo = tipo;
        this.receta = receta;

        myId = id;
        id++;
    }

    public Comida(String nombre, String categorias, String tipo) {
        this.nombre = nombre;
        catToList(categorias);
        this.tipo = tipo;

        myId = id;
        id++;
    }

    private void catToList(String cat){
        cat = cat.replaceAll(" ", "");
        categorias = new ArrayList<>();
        categorias = Arrays.asList(cat.split(","));
    }

    public int getId() {
        return myId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        catToList(categorias);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "nombre='" + nombre + '\'' +
                ", categorias=" + categorias +
                ", tipo='" + tipo + '\'' +
                ", receta='" + receta + '\'' +
                '}';
    }
}
