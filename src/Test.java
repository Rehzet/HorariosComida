import HorariosComida.*;

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

        GenerarHorario gh = new GenerarHorario(comidas, true);

        /*
        gh.setComidasAceptadasEnDia(HorariosComida.Dias.LUNES, "Verdura");
        gh.setComidasAceptadasEnDia(HorariosComida.Dias.MARTES, "Pasta");
        gh.setComidasAceptadasEnDia(HorariosComida.Dias.MIERCOLES, "Legumbres");
        gh.setComidasAceptadasEnDia(HorariosComida.Dias.JUEVES, "Verdura");
        gh.setComidasAceptadasEnDia(HorariosComida.Dias.VIERNES, "Verdura");
        gh.setComidasAceptadasEnDia(HorariosComida.Dias.VIERNES, "Arroz");

        gh.setCenasAceptadasEnDia(HorariosComida.Dias.SABADO, "Basura");

         */

        gh.setPrimerosAceptados(Dias.LUNES, "Verdura");
        gh.setPrimerosAceptados(Dias.LUNES, "Arroz");

        gh.setPrimerosRestringidos(Dias.LUNES, "Verdura");

        gh.setSegundosAceptados(Dias.LUNES, "Pollo");

        MenuDia[] semana = gh.generarHorarioAleatorio();

        System.out.println(gh.horarioATexto(semana));

    }
}
