package HorariosComida;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Permite convertir un archivo XML de comidas a un {@code ArrayList} de {@link Comida}.
 */
public class LeerComidas {

    /**
     * Se leen varios archivos que contienen comidas en formato XML, para después devolver sus datos en forma de lista de comidas.
     * El archivo XML deberá tener una estructura similar a esta, con una o varias etiquetas "comida":
     * <p>&nbsp;</p>
     *                                                                  {@literal <comidas>} <br>
     * &nbsp;&nbsp;&nbsp;&nbsp;                                         {@literal   <comida nombre="nombre" categoria"categoria" tipo="tipo">}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                 {@literal     Esta es la receta.} <br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                 {@literal     Ingredientes:}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         - Ingrediente 1}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         - Ingrediente 2}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         - etc}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                 {@literal     Pasos:}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         1. Paso 1.}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         2. Paso 2.}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         etc}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;                                         {@literal    </comida>}<br>
     *                                                                  {@literal </comidas>}<br>
     *
     * @param rutas Array que contiene todas las rutas a los archivos XML.
     * @return ArrayList de las comidas que contenía el archivo leído.
     */
    public static ArrayList<Comida> leerComidas(String[] rutas){
        ArrayList<Comida> comidas = new ArrayList<>();

        for (String ruta : rutas) {
            comidas.addAll(leerComidas(ruta));
        }

        return comidas;
    }

    /**
     * Se lee un archivo que contiene comidas en formato XML, para después devolver sus datos en forma de lista de comidas.
     * El archivo XML deberá tener una estructura similar a esta, con una o varias etiquetas "comida":
     * <p>&nbsp;</p>
     *                                                                  {@literal <comidas>} <br>
     * &nbsp;&nbsp;&nbsp;&nbsp;                                         {@literal   <comida nombre="nombre" categoria"categoria" tipo="tipo">}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                 {@literal     Esta es la receta.} <br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                 {@literal     Ingredientes:}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         - Ingrediente 1}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         - Ingrediente 2}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         - etc}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                 {@literal     Pasos:}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         1. Paso 1.}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         2. Paso 2.}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     {@literal         etc}<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;                                         {@literal    </comida>}<br>
     *                                                                  {@literal </comidas>}<br>
     *
     * @param ruta Ruta del archivo que se va a leer.
     * @return ArrayList de las comidas que contenía el archivo leído.
     */
    public static ArrayList<Comida> leerComidas(String ruta){

        ArrayList<Comida> comidas = new ArrayList<>();

        try {
            File file = new File(ruta);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("comida");

            for (int i=0; i<nodeList.getLength(); i++) {

                if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){

                    Element eElement = (Element) nodeList.item(i);

                    Comida comida = new Comida(eElement.getAttribute("nombre"), eElement.getAttribute("categoria"), eElement.getAttribute("tipo"), eElement.getTextContent());
                    comidas.add(comida);
                }

            }

        } catch (FileNotFoundException e){
            System.err.println("No se ha podido encontrar el archivo de comidas.");
            System.exit(1);
        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }

        return comidas;
    }



}
