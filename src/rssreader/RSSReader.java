
package rssreader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RSSReader {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            URL dir = new URL("http://estaticos.elmundo.es/elmundo/rss/portada.xml");
            Document documento = creadorDocumento.parse(dir.openStream());
            
            NodeList listaTitulos = documento.getElementsByTagName("title");
            for(int i=0; i<listaTitulos.getLength(); i++) {
                Node nodoTitulo = listaTitulos.item(i);
                Node titulo = nodoTitulo.getFirstChild();
                System.out.println(titulo.getNodeValue());
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(RSSReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(RSSReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RSSReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RSSReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
