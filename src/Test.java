import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Comida> comidas = LeerComidas.leerComidas("D:\\Proyectos\\Java\\HorariosComida\\Comidas.xml");

        GenerarHorario gh = new GenerarHorario(comidas);

        //gh.setRestriccionComidaEnDia(Dias.VIERNES, "Verdura");
        MenuDia[] semana = gh.generarHorarioAleatorio();

        System.out.println(gh.horarioTexto(semana));
    }
}
