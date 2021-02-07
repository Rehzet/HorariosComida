public class MenuDia {

    private Comida desayuno;

    private Comida comidaPrimero;
    private Comida comidaSegundo;

    private Comida cena;

    public MenuDia() {
        desayuno = new Comida("", "", "", "");
        comidaPrimero = new Comida("", "", "", "");;
        comidaSegundo = new Comida("", "", "", "");
        cena = new Comida("", "", "", "");

    }

    public Comida getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(Comida desayuno) {
        this.desayuno = desayuno;
    }

    public Comida getComidaPrimero() {
        return comidaPrimero;
    }

    public void setComidaPrimero(Comida comidaPrimero) {
        this.comidaPrimero = comidaPrimero;
    }

    public Comida getComidaSegundo() {
        return comidaSegundo;
    }

    public void setComidaSegundo(Comida comidaSegundo) {
        this.comidaSegundo = comidaSegundo;
    }

    public Comida getCena() {
        return cena;
    }

    public void setCena(Comida cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {

        return "\tDesayuno: " + getDesayuno().getNombre() + "\n" +
                "\tComida: \n" +
                "\t\tPrimero: " + getComidaPrimero().getNombre() + "\n" +
                "\t\tSegundo: " + getComidaSegundo().getNombre() + "\n" +
                "\tCena: " + getCena().getNombre();
    }
}
