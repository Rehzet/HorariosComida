import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        System.out.println("Hola");
        ArrayList<Comida> comidas = LeerComidas.leerComidas("D:\\Proyectos\\Java\\HorariosComida\\Comidas.xml");

        GenerarHorario gh = new GenerarHorario(comidas);
    }
}
