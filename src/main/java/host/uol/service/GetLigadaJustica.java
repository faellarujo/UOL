package host.uol.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class GetLigadaJustica {

    static String endpoint = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";

    List<String> lisLigaDaJustica = null;

    public List<String> getLisLigaDaJustica() {
        return lisLigaDaJustica;
    }

    public void setLisLigaDaJustica(List<String> lisLigaDaJustica) {
        this.lisLigaDaJustica = lisLigaDaJustica;
    }

    public GetLigadaJustica() throws IOException {
        this.lisLigaDaJustica = consultaEndPoint();
    }


    public List<String> consultaEndPoint() throws IOException {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(endpoint).openConnection();
            connection.setRequestMethod("GET");

            // Obter a resposta
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Ler a resposta
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    // Processar a resposta XML
                    String xmlResponse = response.toString();
                    System.out.println("Resposta XML:");
                    System.out.println(xmlResponse);

                    // Considerando que stringToXML é uma função que você implementou para converter XML em lista de strings
                    final List<String> list = new ArrayList<>(stringToXML(xmlResponse));

                    lisLigaDaJustica = list;
                    lisLigaDaJustica.forEach(codinome -> System.out.println(codinome));
                }
            } else {
                System.out.println("Falha na requisição. Código de resposta: " + responseCode);
            }

            // Fechar a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;

        return lisLigaDaJustica;
    }


    private static List<String> stringToXML(String xmlResponse) {
        Document doc = convertStringToXMLDocument(xmlResponse);

        //Verify XML document is build correctly
        System.out.println("Root Node : " + doc.getFirstChild().getNodeName());

        final Node firstChild = doc.getFirstChild();

        NodeList nodeList = doc.getElementsByTagName("codinomes");

        List<String> listCodinomes = new ArrayList<>();
        for (int itr = 0; itr < nodeList.getLength(); itr++) {

            Node node = nodeList.item(itr);
            System.out.println("\nliga_da_justica : " + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                listCodinomes.add(eElement.getElementsByTagName("codinome").item(0).getTextContent());
                listCodinomes.add(eElement.getElementsByTagName("codinome").item(1).getTextContent());
                listCodinomes.add(eElement.getElementsByTagName("codinome").item(2).getTextContent());
                listCodinomes.add(eElement.getElementsByTagName("codinome").item(3).getTextContent());
                listCodinomes.add(eElement.getElementsByTagName("codinome").item(4).getTextContent());
                listCodinomes.add(eElement.getElementsByTagName("codinome").item(5).getTextContent());

            }
        }
        return listCodinomes;
    }


    private static Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws IOException {
        GetLigadaJustica getLigadaJustica = new GetLigadaJustica();
        getLigadaJustica.consultaEndPoint();
    }
}


















