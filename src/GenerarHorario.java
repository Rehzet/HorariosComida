import java.util.*;

public class GenerarHorario {

    private ArrayList<Comida> comidas;
    private MenuDia semana[];

    private ArrayList<Comida> primeros;
    private ArrayList<Comida> segundos;
    private ArrayList<Comida> cenas;

    private ArrayList<String>[] restriccionesComidas;  // Ej: Martes -> Pasta
    private ArrayList<String>[] restriccionesCenas;

    private HashSet<Integer> iDs;                     // Se guardan los id de las comidas para que no se repitan.

    /**
     * Constructor de la clase GenerarHorario.
     * @param comidas Lista de todas las comidas disponibles para generar el horario.
     */
    public GenerarHorario(ArrayList<Comida> comidas) {
        this.comidas = comidas;
        semana = new MenuDia[7];
        restriccionesComidas = new ArrayList[7];
        restriccionesCenas = new ArrayList[7];
        for(int i=0; i<7; i++){
            restriccionesComidas[i] = new ArrayList<>();
            restriccionesCenas[i] = new ArrayList<>();
        }
        iDs = new HashSet<>();

        primeros = new ArrayList<>();
        segundos = new ArrayList<>();
        cenas = new ArrayList<>();

        clasificarComidas();

    }

    /**
     * Genera un menú aleatorio para los 7 días de la semana.
     * @return Array de MenuDia de 7 posiciones.
     */
    public MenuDia[] generarHorarioAleatorio(){
        for (Dias dia: Dias.values()){
            semana[dia.ordinal()] = elegirMenuDia(dia);
        }

        return semana;
    }

    public void setRestriccionComidaEnDia(Dias dia, String tipoComida){
        restriccionesComidas[dia.ordinal()].add(tipoComida);
    }

    public void setRestriccionCenaEnDia(Dias dia, String tipoComida){
        restriccionesCenas[dia.ordinal()].add(tipoComida);
    }

    public String horarioTexto(MenuDia[] semana) {
        String str = "";
        for (Dias dia: Dias.values()){
            str += "---- " + dia.name() + " ----\n" + semana[dia.ordinal()].toString() + "\n";
        }
        return str;
    }

    /**
     * Se clasifican las comidas de la lista "comidas" en tres listas según su categoría.
     */
    private void clasificarComidas(){

        for(Comida comida: comidas){
            if(comida.getCategorias().contains("Comida(Primero)") || comida.getCategorias().contains("Comida(Unico)"))
                primeros.add(comida);
            else if(comida.getCategorias().contains("Comida(Segundo)"))
                segundos.add(comida);
            else if(comida.getCategorias().contains("Cena"))
                cenas.add(comida);
        }
    }

    /**
     * Se genera un menú aleatorio para un día de la semana. Para cada categoría de comida se tienen unas restricciones concretas,
     * que dependen del día de la semana.
     * @param dia
     * @return Devuelve el menú completo de ese día.
     */
    private MenuDia elegirMenuDia(Dias dia){
        // Si el primer plato es único, no hacer segundo plato.
        // Si el primer plato no es único, ignorar restricciones en el segundo.
        MenuDia menuDia = new MenuDia();

        menuDia.setDesayuno(new Comida("Leche con galletas", "Desayuno", "Bollería"));
        menuDia.setComidaPrimero(elegirComida(primeros, restriccionesComidas[dia.ordinal()]));
        if(!menuDia.getComidaPrimero().getCategorias().contains("Comida(Unico)"))
            menuDia.setComidaSegundo(elegirComida(segundos, restriccionesComidas[dia.ordinal()], true));
        menuDia.setCena(elegirComida(cenas, restriccionesCenas[dia.ordinal()]));

        return menuDia;
    }

    /**
     * Se selecciona una comida aleatoria de entre todas las disponibles de la categoría que toque. Las comidas no se
     * repetirán a lo largo de la semana.
     * @param categoria Lista de comidas disponibles para la categoría de la propia lista.
     * @param restricciones Lista de restricciones para tener en cuenta a la hora de elegir una comida.
     * @return Se devuelve una comida aleatoria.
     */
    private Comida elegirComida(ArrayList<Comida> categoria, ArrayList<String> restricciones){
        return elegirComida(categoria, restricciones, false);
    }

    /**
     * Se selecciona una comida aleatoria de entre todas las disponibles de la categoría que toque. Las comidas no se
     * repetirán a lo largo de la semana.
     * @param categoria Lista de comidas disponibles para la categoría de la propia lista.
     * @param restricciones Lista de restricciones para tener en cuenta a la hora de elegir una comida.
     * @param ignorarRestricciones Indica si se ignoran las restriccines o no.
     * @return Se devuelve una comida aleatoria.
     */
    private Comida elegirComida(ArrayList<Comida> categoria, ArrayList<String> restricciones, boolean ignorarRestricciones){       // Categoría = Comida, Cena, etc.

        ArrayList<Comida> comidasElegibles = new ArrayList<>();

        if(!ignorarRestricciones && restricciones.size() > 0){
            for(Comida comida: categoria){
                if(!iDs.contains(comida.getId()) && restricciones != null && restricciones.contains(comida.getTipo()) )
                    comidasElegibles.add(comida);
            }
        }
        else{
            for(Comida comida: categoria){
                if(!iDs.contains(comida.getId()) )
                    comidasElegibles.add(comida);
            }
        }

        if(comidasElegibles.size() > 0 && comidasElegibles.size() <= 1){
            Comida c = comidasElegibles.get(0);
            iDs.add(c.getId());
            return c;
        }
        else if(comidasElegibles.size() > 1){
            Comida c = comidasElegibles.get(new Random(System.currentTimeMillis()).nextInt(comidasElegibles.size()) );
            iDs.add(c.getId());
            return c;
        }
        else
            return new Comida("", "", "", "");
    }


}
