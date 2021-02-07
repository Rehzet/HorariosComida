import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class LeerComidas {

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

        }catch (Exception e){
            e.printStackTrace();
        }

        return comidas;
    }



}
