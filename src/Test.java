import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        String[] rutas = {
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Arroces.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Cerdo.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\ComidaBasura.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Legumbres.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\OtrasCarnes.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Otros.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Pastas.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Pollo.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Ternera.xml",
                "D:\\Proyectos\\Java\\HorariosComida\\Comidas\\Verduras.xml"
        };

        ArrayList<Comida> comidas = LeerComidas.leerComidas(rutas);

        GenerarHorario gh = new GenerarHorario(comidas);

        gh.setRestriccionComidaEnDia(Dias.LUNES, "Verdura");
        gh.setRestriccionComidaEnDia(Dias.MARTES, "Pasta");
        gh.setRestriccionComidaEnDia(Dias.MIERCOLES, "Legumbres");
        gh.setRestriccionComidaEnDia(Dias.JUEVES, "Verdura");
        gh.setRestriccionComidaEnDia(Dias.VIERNES, "Verdura");
        gh.setRestriccionComidaEnDia(Dias.VIERNES, "Arroz");

        gh.setRestriccionCenaEnDia(Dias.SABADO, "Basura");

        MenuDia[] semana = gh.generarHorarioAleatorio();

        System.out.println(gh.horarioATexto(semana));
    }
}
