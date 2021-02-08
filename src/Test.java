import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        String[] rutas = {"D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Legumbres.xml",
                          "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Pasta.xml",
                          "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Verdura.xml",
                          "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Arroz.xml"};

        ArrayList<Comida> comidas = LeerComidas.leerComidas(rutas);

        GenerarHorario gh = new GenerarHorario(comidas);

        gh.setRestriccionComidaEnDia(Dias.LUNES, "Verdura");
        gh.setRestriccionComidaEnDia(Dias.MARTES, "Pasta");
        gh.setRestriccionComidaEnDia(Dias.MIERCOLES, "Legumbres");
        gh.setRestriccionComidaEnDia(Dias.VIERNES, "Verdura");
        gh.setRestriccionComidaEnDia(Dias.VIERNES, "Arroz");

        MenuDia[] semana = gh.generarHorarioAleatorio();

        System.out.println(gh.horarioATexto(semana));
    }
}
