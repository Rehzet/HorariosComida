package HorariosComida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * La clase {@code HorariosComida.Comida} no es m&aacute;s que una estructura de datos donde se almacena toda la informaci&oacute;n sobre un plato,
 * como su nombre, categor&iacute;as y tipo y la receta.
 * Cada comida tiene un ID &uacute;nico, que permite diferenciarla de las dem&aacute;s.
 */
public class Comida {

    //TODO hacer que algunas comidas sean repetibles a lo largo de la semana.
    //TODO clasificar comidas por estación del año (calientes o frías).
    //TODO añadir etiqueta "fin de semana". Estas comidas solo podrán aparecer los fines de semana.
    //TODO incluir sistema de votación. Las comidas favoritas aparecerán más a menudo.

    private final int id;

    private String nombre;
    private List<String> categorias;
    private String tipo;
    private String receta;

    /**
     * Se crea una comida con su receta. Todos los campos pueden contener una cadena vac&iacute;a.
     * @param nombre Nombre de la comida.
     * @param categorias Hora del d&iacute;a a la que se puede consumir la comida. Categor&iacute;as: Desayuno, Comida(Primero),
     *                   Comida(Segundo), Comida(Unico), Cena
     * @param tipo Tipo de la comida. Ej: Carne, pescado, pasta, arroz, etc.
     * @param receta Texto que incluye la receta de la comida.
     */
    public Comida(String nombre, String categorias, String tipo, String receta) {
        this.nombre = nombre;
        catToList(categorias);
        this.tipo = tipo;
        this.receta = receta;

        id = hashCode();
    }

    /**
     * Se crea una comida con su receta. Todos los campos pueden contener una cadena vacía.
     * @param nombre Nombre de la comida.
     * @param categorias Hora del d&iacute;a a la que se puede consumir la comida. Categorías: Desayuno, Comida(Primero),
     *                   Comida(Segundo), Comida(Unico), Cena
     * @param tipo Tipo de la comida. Ej: Carne, pescado, pasta, arroz, etc.
     */
    public Comida(String nombre, String categorias, String tipo) {
        this.nombre = nombre;
        catToList(categorias);
        this.tipo = tipo;

        id = hashCode();
    }

    /**
     * Convierte las categor&iacute;as de la comida del formato String a una lista. Vienen dadas en el formato {@code Cat1, Cat2, Cat3, etc}.
     * @param cat Cadena de texto que contiene las categor&iacute;as de la comida.
     */
    private void catToList(String cat){
        cat = cat.replaceAll(" ", "");
        categorias = new ArrayList<>();
        categorias = Arrays.asList(cat.split(","));
    }

    /**
     * Devuelve el identificador &uacute;nico del objeto actual.
     * @return Identificador del objeto {@code Comida} actual.
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el nombre de la comida.
     * @return Devuelve el nombre de la comida.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para la comida.
     * @param nombre Nuevo nombre para la comida.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una lista de todas las categor&iacute;as de la comida. La categor&iacute;a indica a la hora a la que se va
     * a consumir la comida (Desayuno, Comida(Primero), Comida(Segundo), Cena).
     * @return Lista de Strings que contiene todas las categor&iacute;as de la comida.
     */
    public List<String> getCategorias() {
        return categorias;
    }

    /**
     * Añade una o varias categor&iacute;as nuevas a la lista de categor&iacute;as.
     * @param categorias Cadena de texto que contiene las categor&iacute;as de la comida. Si se quiere a&nacute;adir m&aacute;s de una, deber&aacute;n estar
     *                   separadas por comas, con un espacio opcional entre medias.
     */
    public void setCategorias(String categorias) {
        catToList(categorias);
    }

    /**
     * Devuelve el tipo de la comida. El tipo indica el ingrediente principal del plato. Por ejemplo: pasta, cerdo, etc.
     * @return Devuelve el tipo de la comida.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece un nuevo tipo para la comida. El tipo indica el ingrediente principal del plato. Por ejemplo: pasta, cerdo, etc.
     * @param tipo String que contiene el tipo de la comida.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la receta en formato String.
     * @return Devuelve la receta en formato String. Si la receta es una cadena vac&iacute;a, significa que no tiene receta.
     */
    public String getReceta() {
        return receta;
    }

    /**
     * Se establece una receta para el plato.
     * @param receta String que contiene la receta de la comida.
     */
    public void setReceta(String receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", categorias=" + categorias +
                ", tipo='" + tipo + '\'' +
                ", receta='" + receta + '\'';
    }
}
