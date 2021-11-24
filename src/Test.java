import HorariosComida.*;

import java.util.ArrayList;


public class Test {

    public static void main(String[] args) {

        /*
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
        */

        /*
        String[] rutas = {
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/Arroces.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/Cerdo.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/ComidaBasura.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/Legumbres.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/OtrasCarnes.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/Otros.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/Pastas.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/Pollo.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/Ternera.xml",
                "/mnt/HDD/Proyectos/Java/HorariosComida/Comidas/Verduras.xml"
        };
         */

        String[] rutas = {
                "<comidas>\n" +
                        "<comida nombre=\"Arroz con tomate\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"Arroz\"> </comida>\n" +
                        "<comida nombre=\"Arroz tres delicias\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Arroz\"> </comida>\n" +
                        "<comida nombre=\"Arroz con salmón\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"Arroz\"> </comida>\n" +
                        "<comida nombre=\"Arroz con carne al curry\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"Arroz\"> </comida>\n" +
                        "<comida nombre=\"Arroz con carne en salsa\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"Arroz\"> </comida>\n" +
                        "<comida nombre=\"Risotto de setas\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Arroz\"> </comida>\n" +
                        "</comidas>",
                "<comidas>\n" +
                        "<comida nombre=\"Solomillo Wellington\" categoria=\"HorariosComida.Comida(Segundo)\" tipo=\"Cerdo\"> </comida>\n" +
                        "<comida nombre=\"Solomillo de cerdo con champiñones\" categoria=\"HorariosComida.Comida(Segundo)\" tipo=\"Cerdo\"> </comida>\n" +
                        "<comida nombre=\"Pinchos morunos\" categoria=\"HorariosComida.Comida(Segundo)\" tipo=\"Cerdo\"> </comida>\n" +
                        "<comida nombre=\"Solomillo de cerdo a la plancha\" categoria=\"HorariosComida.Comida(Segundo)\" tipo=\"Cerdo\"> </comida>\n" +
                        "</comidas>",
                "<comidas>\n" +
                        "<comida nombre=\"Hamburguesa\" categoria=\"Cena\" tipo=\"Basura\"> </comida>\n" +
                        "<comida nombre=\"Pizza\" categoria=\"Cena\" tipo=\"Basura\"> </comida>\n" +
                        "<comida nombre=\"Perritos calientes\" categoria=\"Cena\" tipo=\"Basura\"> </comida>\n" +
                        "<comida nombre=\"Sándwiches variados\" categoria=\"Cena\" tipo=\"Basura\"> </comida>\n" +
                        "</comidas>",
                "<comidas>\n" +
                        "<comida nombre=\"Lentejas\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Legumbres\"> </comida>\n" +
                        "<comida nombre=\"Garbanzos con tomate\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Legumbres\"> </comida>\n" +
                        "<comida nombre=\"Cocido madrileño\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"Legumbres\"> </comida>\n" +
                        "<comida nombre=\"Guisantes con jamón\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Legumbres\"> </comida>\n" +
                        "<comida nombre=\"Ensalada de garbanzos\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Legumbres\"> </comida>\n" +
                        "</comidas>",
                "<comidas>\n" +
                        "<comida nombre=\"Albóndigas en salsa con patatas fritas\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"OtrasCarnes\"> </comida>\n" +
                        "<comida nombre=\"Rollo de carne picada\" categoria=\"HorariosComida.Comida(Segundo)\" tipo=\"OtrasCarnes\"> </comida>\n" +
                        "<comida nombre=\"Filetes rusos\" categoria=\"HorariosComida.Comida(Segundo)\" tipo=\"OtrasCarnes\"> </comida>\n" +
                        "<comida nombre=\"Albóndigas con salsa de almendras\" categoria=\"HorariosComida.Comida(Segundo)\" tipo=\"OtrasCarnes\"> </comida>\n" +
                        "<comida nombre=\"Fajitas de carne\" categoria=\"HorariosComida.Comida(Segundo)\" tipo=\"OtrasCarnes\"> </comida>\n" +
                        "</comidas>",
                "<comidas>\n" +
                        "<comida nombre=\"Croquetas de jamón\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "<comida nombre=\"Empanadillas de atún\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "<comida nombre=\"Empanada de atún\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "<comida nombre=\"Empanada de pollo\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "<comida nombre=\"Sopa de fideos\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "<comida nombre=\"Sopa maravilla\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "<comida nombre=\"Huevos rellenos\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "<comida nombre=\"Tortilla de patatas\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "<comida nombre=\"Patatas fritas con huevo revuelto\" categoria=\"Cena\" tipo=\"Otros\"> </comida>\n" +
                        "</comidas>",
                "<comidas>\n" +
                        "<comida nombre=\"Macarrones boloñesa\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"Pasta\"> 1. Cocer macarrones. 2. Comer. </comida>\n" +
                        "<comida nombre=\"Lasaña\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Espaguetis carbonara\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Tallarines caprese\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Tallarines con aguacate\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Tallarines con salsa de setas\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Tallarines con ajo y aceite\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Pasta china con verduras\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Ñoquis al pesto\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Ñoquis al pesto rojo\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Ñoquis con salsa de trufas\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Raviolis con salsa de queso\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Raviolis al pesto\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Raviolis con salsa de trufas\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Fideos negros con gulas\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Ensalada de pasta\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Macarrones con chorizo\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Macarrones con atún\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Macarrones con queso (mac and cheese)\" categoria=\"HorariosComida.Comida(Unico)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Espaguetis con boloñesa de soja texturizada\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "<comida nombre=\"Cuscús\" categoria=\"HorariosComida.Comida(Primero)\" tipo=\"Pasta\"> </comida>\n" +
                        "</comidas>"
        };

        ArrayList<Comida> comidas = LeerComidas.leerComidas(rutas, false);

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

/*
        gh.setPrimerosAceptados(Dias.LUNES, "Verdura");
        gh.setPrimerosAceptados(Dias.LUNES, "Arroz");

        gh.setPrimerosRestringidos(Dias.LUNES, "Verdura");

        gh.setSegundosAceptados(Dias.LUNES, "Pollo");

        gh.setCenasAceptadasEnDia(Dias.LUNES, "Basura");

 */

        MenuDia[] semana = gh.generarHorarioAleatorio();

        System.out.println(gh.horarioATexto(semana));

    }
}
