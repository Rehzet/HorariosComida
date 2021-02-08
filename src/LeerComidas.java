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
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeerComidas {

    public static ArrayList<Comida> leerComidas(String[] rutas){
        ArrayList<Comida> comidas = new ArrayList<>();

        for (int i = 0; i < rutas.length; i++) {
            comidas.addAll(leerComidas(rutas[i]));
        }

        return comidas;
    }

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
