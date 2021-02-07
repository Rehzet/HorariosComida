import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class GenerarHorario {

    private ArrayList<Comida> comidas;
    private MenuDia semana[];

    private Map<Dias, String> restriccionesComidas;     // Ej: Martes -> Pasta
    private Map<Dias, String> restriccionesCenas;

    private HashSet<Integer> iDs;                     // Se guardan los id de las comidas para que no se repitan.

    public GenerarHorario(ArrayList<Comida> comidas) {
        this.comidas = comidas;
        semana = new MenuDia[7];


    }

    private MenuDia elegirMenuDia(){


        return null;
    }

    private Comida buscarComida(String categoria){
        Random random = new Random(System.currentTimeMillis());
        int numComida;

        do{
            numComida = random.nextInt(comidas.size());
        }while(!iDs.add(numComida) && comidas.get(numComida).getCategorias().contains(categoria));

        return comidas.get(numComida);
    }

    private void setDia(Dias dia, MenuDia menuDia){
        semana[dia.ordinal()] = menuDia;
    }

    public void setRestriccionComidaEnDia(Dias dia, String tipoComida){
        restriccionesComidas.put(dia, tipoComida);
    }

    public void setRestriccionCenaEnDia(Dias dia, String tipoComida){
        restriccionesCenas.put(dia, tipoComida);
    }
}
