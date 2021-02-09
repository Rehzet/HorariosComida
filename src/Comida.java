import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comida {

    //TODO hacer que algunas comidas sean repetibles a lo largo de la semana.
    //TODO clasificar comidas por estación del año (calientes o frías).
    //TODO sustituir id por hash. Así no hay que guardar el id de una semana a otra.
    //TODO añadir etiqueta "fin de semana". Estas comidas solo podrán aparecer los fines de semana.
    //TODO incluir sistema de votación. Las comidas favoritas aparecerán más a menudo.

    private static int id = 0;
    private final int myId;

    private String nombre;
    private List<String> categorias;
    private String tipo;
    private String receta;

    /**
     * Se crea una comida con su receta. Todos los campos pueden contener una cadena vacía.
     * @param nombre Nombre de la comida.
     * @param categorias Hora del día a la que se puede consumir la comida. Categorías: Desayuno, Comida(Primero),
     *                   Comida(Segundo), Comida(Unico), Cena
     * @param tipo Tipo de la comida. Ej: Carne, pescado, pasta, arroz, etc.
     * @param receta Texto que incluye la receta de la comida.
     */
    public Comida(String nombre, String categorias, String tipo, String receta) {
        this.nombre = nombre;
        catToList(categorias);
        this.tipo = tipo;
        this.receta = receta;

        myId = id;
        id++;
    }

    /**
     * Se crea una comida con su receta. Todos los campos pueden contener una cadena vacía.
     * @param nombre Nombre de la comida.
     * @param categorias Hora del día a la que se puede consumir la comida. Categorías: Desayuno, Comida(Primero),
     *                   Comida(Segundo), Comida(Unico), Cena
     * @param tipo Tipo de la comida. Ej: Carne, pescado, pasta, arroz, etc.
     */
    public Comida(String nombre, String categorias, String tipo) {
        this.nombre = nombre;
        catToList(categorias);
        this.tipo = tipo;

        myId = id;
        id++;
    }

    /**
     * Convierte las categorías de la comida del formato String a una lista.
     * @param cat
     */
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
