package HorariosComida;

/**
 * Estructura de datos que contiene todas las comidas de un único día.
 */
public class MenuDia {

    private Comida desayuno;

    private Comida comidaPrimero;
    private Comida comidaSegundo;

    private Comida cena;

    /**
     * Constructor de la clase {@code HorariosComida.MenuDia}. Inicializa todas las comidas del día a cadenas vacías.
     */
    public MenuDia() {
        desayuno = new Comida("", "", "", "");
        comidaPrimero = new Comida("", "", "", "");
        comidaSegundo = new Comida("", "", "", "");
        cena = new Comida("", "", "", "");

    }

    /**
     * Devuelve el desayuno del día.
     * @return Devuelve el desayuno del día.
     */
    public Comida getDesayuno() {
        return desayuno;
    }

    /**
     * Establece el desayuno para el día.
     * @param desayuno Objeto del tipo {@code HorariosComida.Comida} que hace referencia al desayuno del día.
     */
    public void setDesayuno(Comida desayuno) {
        this.desayuno = desayuno;
    }

    /**
     * Devuelve el primer plato de la comida del día.
     * @return Devuelve el primer plato de la comida del día.
     */
    public Comida getComidaPrimero() {
        return comidaPrimero;
    }

    /**
     * Establece el primer plato de la comida del día.
     * @param comidaPrimero Objeto del tipo {@code HorariosComida.Comida} que hace referencia al primer plato del día.
     */
    public void setComidaPrimero(Comida comidaPrimero) {
        this.comidaPrimero = comidaPrimero;
    }

    /**
     * Devuelve el segundo plato de la comida del día.
     * @return Devuelve el segundo plato de la comida del día.
     */
    public Comida getComidaSegundo() {
        return comidaSegundo;
    }

    /**
     * Establece el primer plato de la comida del día.
     * @param comidaSegundo Objeto del tipo {@code HorariosComida.Comida} que hace referencia al segundo plato del día.
     */
    public void setComidaSegundo(Comida comidaSegundo) {
        this.comidaSegundo = comidaSegundo;
    }

    /**
     * Devuelve la cena del día.
     * @return Devuelve la cena del día.
     */
    public Comida getCena() {
        return cena;
    }

    /**
     * Establece la cena del día.
     * @param cena Objeto del tipo {@code HorariosComida.Comida} que hace referencia a la cena del día.
     */
    public void setCena(Comida cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {

        return "\tDesayuno: " + getDesayuno().getNombre() + "\n" +
                "\t\tPrimero: " + getComidaPrimero().getNombre() + "\n" +
                "\t\tSegundo: " + getComidaSegundo().getNombre() + "\n" +
                "\tCena: " + getCena().getNombre();
    }
}
