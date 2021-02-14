import Excepciones.NoComidaException;

import java.util.*;

public class GenerarHorario {

    //TODO elegir comidas según la época del año. Tener en cuenta el hemisferio.

    private final MenuDia[] semana;

    private final ArrayList<Comida> primeros;
    private final ArrayList<Comida> segundos;
    private final ArrayList<Comida> cenas;

    private final ArrayList<String>[] comidasPrimAceptadas;  // Contiene los tipos de comida que podrán aparecer en el día.
    private final ArrayList<String>[] comidasSegAceptadas;
    private final ArrayList<String>[] cenasAceptadas;

    private final ArrayList<String>[] comidasPrimRestringidas;
    private final ArrayList<String>[] comidasSegRestringidas;
    private final ArrayList<String>[] cenasRestringidas;

    private final HashSet<Integer> iDs;                     // Se guardan los id de las comidas para que no se repitan.

    private final boolean alternarComidas;

    /**
     * Constructor de la clase GenerarHorario.
     * @param comidas Lista de todas las comidas disponibles para generar el horario.
     */
    public GenerarHorario(ArrayList<Comida> comidas){
        this(comidas, false);
    }

    /**
     * Constructor de la clase GenerarHorario.
     * @param comidas Lista de todas las comidas disponibles para generar el horario.
     * @param alternarComidas Indica si se puede dar el mismo tipo de camida en días consecutivos. Por ejemplo,
     *                          si el lunes de segundo plato se come pollo, si alternarComidas vale true, el martes
     *                          no aparecerá pollo como segundo plato. En cambio, si vale false, el martes podría
     *                          aparecer pollo o no.
     */
    public GenerarHorario(ArrayList<Comida> comidas, boolean alternarComidas) {
        semana = new MenuDia[7];
        comidasPrimAceptadas = new ArrayList[7];
        comidasSegAceptadas = new ArrayList[7];
        cenasAceptadas = new ArrayList[7];

        comidasPrimRestringidas = new ArrayList[7];
        comidasSegRestringidas = new ArrayList[7];
        cenasRestringidas = new ArrayList[7];

        for(int i=0; i<7; i++){
            comidasPrimAceptadas[i] = new ArrayList<>();
            comidasSegAceptadas[i] = new ArrayList<>();
            cenasAceptadas[i] = new ArrayList<>();

            comidasPrimRestringidas[i] = new ArrayList<>();
            comidasSegRestringidas[i] = new ArrayList<>();
            cenasRestringidas[i] = new ArrayList<>();
        }
        iDs = new HashSet<>();

        primeros = new ArrayList<>();
        segundos = new ArrayList<>();
        cenas = new ArrayList<>();

        this.alternarComidas = alternarComidas;

        clasificarComidas(comidas);

    }

    /**
     * Genera un menú aleatorio para los 7 días de la semana.
     * @return Array de MenuDia de 7 posiciones.
     */
    public MenuDia[] generarHorarioAleatorio() {

        if(alternarComidas){
            for (Dias dia: Dias.values()){
                if(!dia.equals(Dias.LUNES)) {
                    comidasPrimRestringidas[dia.ordinal()].add(semana[dia.ordinal() - 1].getComidaPrimero().getTipo());
                    comidasSegRestringidas[dia.ordinal()].add(semana[dia.ordinal() - 1].getComidaSegundo().getTipo());
                    cenasRestringidas[dia.ordinal()].add(semana[dia.ordinal() - 1].getCena().getTipo());

                }
                semana[dia.ordinal()] = elegirMenuDia(dia);
            }
        }
        else{
            for (Dias dia: Dias.values()){
                semana[dia.ordinal()] = elegirMenuDia(dia);
            }
        }


        return semana;
    }

    /**
     * Añade una restricción al primer plato de un día concreto. Esta función es útil si, por ejemplo, el martes queremos
     * que solo se nos ofrezcan comidas del tipo "Pasta". Las restricciones son acumulables.
     * @param dia Día en el que se va a añadir una restricción.
     * @param tipoComida Restricción que se va a añadir basada en un tipo de comida.
     */
    public void setPrimerosRestringidos(Dias dia, String tipoComida){
        comidasPrimRestringidas[dia.ordinal()].add(tipoComida);
    }

    /**
     * Añade una restricción al segundo plato de un día concreto. Esta función es útil si, por ejemplo, el martes queremos
     * que solo se nos ofrezcan comidas del tipo "Pasta". Las restricciones son acumulables.
     * @param dia Día en el que se va a añadir una restricción.
     * @param tipoComida Restricción que se va a añadir basada en un tipo de comida.
     */
    public void setSegundosRestringidos(Dias dia, String tipoComida){
        comidasSegRestringidas[dia.ordinal()].add(tipoComida);
    }

    /**
     * Añade una restricción a la CENA de un día concreto. Esta función es útil si, por ejemplo, el jueves queremos
     * que solo se nos ofrezcan cenas del tipo "Pescado". Las restricciones son acumulables.
     * @param dia Día en el que se va a añadir una restricción.
     * @param tipoComida Restricción que se va a añadir basada en un tipo de comida.
     */
    public void setCenasRestringidasEnDia(Dias dia, String tipoComida){
        cenasRestringidas[dia.ordinal()].add(tipoComida);
    }

    /**
     * Añade una categoría de comida para el primer plato que se quiere que aparezca un día concreto. Por ejemplo,
     * si el martes queremos que se eligan comidas del tipo "Pasta" y del tipo "Arroz", se deberá llamar a esta función
     * dos veces indicando los tipos de comida mencionados, además del día. Los tipos de comida son acumulables.
     * @param dia Día en el que se va a añadir el tipo de comida.
     * @param tipoComida Tipo de comida elegible en el día especificado.
     */
    public void setPrimerosAceptados(Dias dia, String tipoComida){
        comidasPrimAceptadas[dia.ordinal()].add(tipoComida);
    }

    /**
     * Añade una categoría de comida para el segundo plato que se quiere que aparezca un día concreto. Por ejemplo,
     * si el martes queremos que se eligan comidas del tipo "Pasta" y del tipo "Arroz", se deberá llamar a esta función
     * dos veces indicando los tipos de comida mencionados, además del día. Los tipos de comida son acumulables.
     * @param dia Día en el que se va a añadir el tipo de comida.
     * @param tipoComida Tipo de comida elegible en el día especificado.
     */
    public void setSegundosAceptados(Dias dia, String tipoComida){
        comidasSegAceptadas[dia.ordinal()].add(tipoComida);
    }

    /**
     * Añade una categoría de comida que se quiere que aparezca un día concreto, a la hora de la CENA. Por ejemplo,
     * si el martes queremos que se eligan comidas del tipo "Pasta" y del tipo "Arroz", se deberá llamar a esta función
     * dos veces indicando los tipos de comida mencionados, además del día. Los tipos de comida son acumulables.
     * @param dia Día en el que se va a añadir el tipo de comida.
     * @param tipoComida Tipo de comida elegible en el día especificado.
     */
    public void setCenasAceptadasEnDia(Dias dia, String tipoComida){
        cenasAceptadas[dia.ordinal()].add(tipoComida);
    }

    /**
     * Convierte un horario dado a String
     * @param semana horario que se va a convertir a texto.
     * @return Se devuelve el horario en el formato:
     * ---- DÍA -----
     *  Desayuno: nombreDesayuno
     *  Comida:
     *      Primero: nombrePrimero
     *      Segundo: nombreSegundo
     *  Cena: nombreCena
     */
    public String horarioATexto(MenuDia[] semana) {
        StringBuilder str = new StringBuilder();
        for (Dias dia: Dias.values()){
            str.append("---- ").append(dia.name()).append(" ----\n").append(semana[dia.ordinal()].toString()).append("\n");
        }
        return str.toString();
    }

    /**
     * Se clasifican las comidas de la lista "comidas" en tres listas según su categoría.
     */
    private void clasificarComidas(ArrayList<Comida> comidas){

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
     * @param dia Día de la semana del que se va a generar un menú.
     * @return Devuelve el menú completo de ese día.
     */
    private MenuDia elegirMenuDia(Dias dia)  {
        // Si el primer plato es único, no hacer segundo plato.
        // Si el primer plato no es único, ignorar restricciones en el segundo.
        MenuDia menuDia = new MenuDia();

        menuDia.setDesayuno(new Comida("Leche con galletas", "Desayuno", "Bollería"));
        menuDia.setComidaPrimero(elegirComida(primeros, comidasPrimAceptadas[dia.ordinal()], comidasPrimRestringidas[dia.ordinal()] ));
        if(!menuDia.getComidaPrimero().getCategorias().contains("Comida(Unico)"))
            menuDia.setComidaSegundo(elegirComida(segundos, comidasSegAceptadas[dia.ordinal()], comidasSegRestringidas[dia.ordinal()]));
        menuDia.setCena( elegirComida(cenas, cenasAceptadas[dia.ordinal()], cenasRestringidas[dia.ordinal()]) );

        return menuDia;
    }

    /**
     * Se selecciona una comida aleatoria de entre todas las disponibles de la categoría que toque. Las comidas no se
     * repetirán a lo largo de la semana.
     * @param categoria Lista de comidas disponibles para la categoría de la propia lista.
     * @param comidasAceptadas Lista de tipos de comida aceptados. La comida que se elija solo podrá ser de uno de los tipos de la lista.
     * @param comidasRestringidas Lista de tipos de comida restrigidos. La comida que se elija NO podrá ser de ninguno de los tipos de la lista.
     *                            Las comidas restringidas tienen prioridad sobre las aceptadas.
     * @return Se devuelve una comida aleatoria.
     */
    private Comida elegirComida(ArrayList<Comida> categoria, ArrayList<String> comidasAceptadas, ArrayList<String> comidasRestringidas) throws NoComidaException {
        return elegirComida(categoria, comidasAceptadas, comidasRestringidas, false);
    }

    /**
     * Se selecciona una comida aleatoria de entre todas las disponibles de la categoría que toque. Las comidas no se
     * repetirán a lo largo de la semana.
     * @param categoria Lista de comidas disponibles para la categoría de la propia lista.
     * @param comidasAceptadas Lista de tipos de comida aceptados. La comida que se elija solo podrá ser de uno de los tipos de la lista.
     * @param comidasRestringidas Lista de tipos de comida restrigidos. La comda que se elija NO podrá ser de ninguno de los tipos de la lista.
     *                            Las comidas restringidas tienen prioridad sobre las aceptadas.
     * @param ignorarRestricciones Indica si se ignoran las restriccines o no.
     * @return Se devuelve una comida aleatoria.
     */
    private Comida elegirComida(ArrayList<Comida> categoria, ArrayList<String> comidasAceptadas, ArrayList<String> comidasRestringidas, boolean ignorarRestricciones)  {       // Categoría = Comida, Cena, etc.

        ArrayList<Comida> comidasElegibles = new ArrayList<>();

        if(!ignorarRestricciones){

            if(comidasAceptadas.size() == 0){
                for(Comida comida: categoria){
                    if(!iDs.contains(comida.getId()) && !comidasRestringidas.contains(comida.getTipo()))
                        comidasElegibles.add(comida);
                }
            }
            else{
                for(Comida comida: categoria){
                    if(!iDs.contains(comida.getId()) && comidasAceptadas.contains(comida.getTipo()) && !comidasRestringidas.contains(comida.getTipo()))
                        comidasElegibles.add(comida);
                }
            }

        }
        else{
            for(Comida comida: categoria){
                if(!iDs.contains(comida.getId()) )
                    comidasElegibles.add(comida);
            }
        }

        if(comidasElegibles.size() == 1){
            Comida c = comidasElegibles.get(0);
            iDs.add(c.getId());
            return c;
        }
        else if(comidasElegibles.size() > 1){
            Comida c = comidasElegibles.get(new Random(System.currentTimeMillis()).nextInt(comidasElegibles.size()) );
            iDs.add(c.getId());
            return c;
        }
        else {
            throw new NoComidaException();
        }
    }


}
