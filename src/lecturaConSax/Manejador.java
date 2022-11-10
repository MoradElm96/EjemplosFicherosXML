/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaConSax;

import creacionConDom.Coches;
import java.util.ArrayList;
import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Morad
 */
public class Manejador extends DefaultHandler {

    ArrayList<Coches> listaCoches = new ArrayList();
    Coches coche;

    StringBuilder sb = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        sb.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {

        switch (qName) {
            case "marca":
                coche.setMarca(sb.toString());
                break;
            case "modelo":
                coche.setModelo(sb.toString());
                break;
            case "color":
                coche.setColor(sb.toString());
                break;
            case "matriculacion":
                coche.setMatriculacion(Integer.parseInt(sb.toString()));
                break;
        }

    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {

        switch (qName) {

            case "coche":
                coche = new Coches();
                listaCoches.add(coche);

                coche.setId(Integer.parseInt(attributes.getValue("id")));

                break;
            case "marca":
            case "modelo":
            case "color":
            case "matriculacion":

                sb.delete(0, sb.length());
                break;

        }

    }

    public ArrayList<Coches> obtenerLista() {
        return listaCoches;
    }

}
