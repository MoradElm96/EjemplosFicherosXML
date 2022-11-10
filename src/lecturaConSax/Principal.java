/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaConSax;

import creacionConDom.Coches;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


/**
 *
 * @author Morad
 */
public class Principal {
    public static void main(String[] args) {
        
        
        try{
        
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        
        Manejador m = new Manejador();
        File f = new File("Coches.xml");
        sp.parse(f, m);
        
        ArrayList<Coches> lista = m.obtenerLista();
        
            for (int i = 0; i <lista.size(); i++) {
                
                System.out.println(lista.get(i).toString());
            }
        
       } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException p) {
            System.out.println(p.getMessage());
        } catch (SAXException s) {
            System.out.println(s.getMessage());
        }
        
    }
}
