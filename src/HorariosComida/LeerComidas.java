package HorariosComida;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Permite convertir un archivo XML de comidas a un {@code ArrayList} de {@link Comida}.
 */
public class LeerComidas {

    /**
     * Se leen varios archivos o strings que contienen comidas en formato XML, para después devolver sus datos en forma de lista de comidas.
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
     * @param uri Array que contiene todas las rutas a los archivos XML si xmlAsFile value true.
     *            Si xmlAsFile vale false, uri deberá contener los distintos archivos XML en forma de string.
     * @param xmlAsFile Permite indicar si se leerán archivos XML o cadenas de texto con formato XML.
     * @return ArrayList de las comidas que contenía el archivo leído.
     */
    public static ArrayList<Comida> leerComidas(String[] uri, boolean xmlAsFile){
        ArrayList<Comida> comidas = new ArrayList<>();

        for (String ruta : uri) {
            comidas.addAll(leerComidas(ruta, xmlAsFile));
        }

        return comidas;
    }

    /**
     * Se lee un archivo o string que contiene comidas en formato XML, para después devolver sus datos en forma de lista de comidas.
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
     * @param uri Array que contiene la ruta al rchivo XML si xmlAsFile value true.
     *            Si xmlAsFile vale false, uri deberá contener el archivo XML en forma de string.
     * @param xmlAsFile Permite indicar si se leerán archivos XML o cadenas de texto con formato XML.
     * @return ArrayList de las comidas que contenía el archivo leído.
     */
    public static ArrayList<Comida> leerComidas(String uri, boolean xmlAsFile){

        ArrayList<Comida> comidas = new ArrayList<>();

        try {
            Document doc = xmlReadMode(xmlAsFile, uri);

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


    private static Document xmlReadMode(boolean readXmlAsFile, String str) throws ParserConfigurationException, IOException, SAXException {
        Document doc = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        if (readXmlAsFile){
            doc = documentBuilder.parse(new File(str));
        }
        else{
            InputSource is = new InputSource(new StringReader(str));
            doc = documentBuilder.parse(is);
        }

        return doc;
    }

}
