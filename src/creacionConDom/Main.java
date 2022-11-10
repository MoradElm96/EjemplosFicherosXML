package creacionConDom;

import java.io.File;
import java.util.ArrayList;
import javax.management.StringValueExp;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author alumnotd
 */
public class Main {

    public static void main(String[] args) {

        File f = new File("Coches.xml");

        ArrayList<Coches> listaCoches = new ArrayList();

        Coches coche1 = new Coches("bmw", "m3", "negro", 2005);
        Coches coche2 = new Coches("seat", "ibiza", "azul", 2015);
        Coches coche3 = new Coches("nissan", "skyline", "naranja", 2001);

        listaCoches.add(coche1);
        listaCoches.add(coche2);
        listaCoches.add(coche3);

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
           

            //elemento raiz y colgarlo del documento
            Element raiz = doc.createElement("coches");
            doc.appendChild(raiz);

            for (int i = 0; i < listaCoches.size(); i++) {

                Element coche = doc.createElement("coche");
                raiz.appendChild(coche);
                //atributo
                Attr atributo = doc.createAttribute("id");
                atributo.setValue(String.valueOf(i));//escribir algo
                coche.setAttributeNode(atributo);//importante
            

                Element marca = doc.createElement("marca");
                marca.setTextContent(listaCoches.get(i).getMarca());
                coche.appendChild(marca);

                Element modelo = doc.createElement("modelo");
                modelo.setTextContent(listaCoches.get(i).getModelo());
                coche.appendChild(modelo);

                Element color = doc.createElement("color");
                color.setTextContent(listaCoches.get(i).getColor());
                coche.appendChild(color);

                Element matriculacion = doc.createElement("matriculacion");
                matriculacion.setTextContent(String.valueOf(listaCoches.get(i).getMatriculacion()));
                coche.appendChild(matriculacion);
  
            }
            //primer elemento

            //se escribe el contenido del xml en un archivo
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }

    }
}
