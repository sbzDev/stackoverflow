package com.stackoverflow.questions;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class RssMerger {

    private final DocumentBuilder db;

    public RssMerger() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        this.db = dbf.newDocumentBuilder();
    }

    public void merge(String baseXml, String[] inputXmls, String resultXml) throws IOException, SAXException, TransformerException {

        Document resultDoc = db.parse(baseXml);

        Node resultConfigsNode = resultDoc.getElementsByTagName("Configs").item(0);
        Node resultRatingsBodyNode = resultDoc.getElementsByTagName("body").item(0);

        for (String inputXml : inputXmls){
            Document inputDoc = db.parse(inputXml);

            NodeList configNodeList = inputDoc.getElementsByTagName("Config");

            for (int i = 0; i < configNodeList.getLength(); i++) {
                Node copiedNode = resultDoc.importNode(configNodeList.item(i), true);
                resultConfigsNode.appendChild(copiedNode);
            }

            NodeList itemsNodeList = inputDoc.getElementsByTagName("Items");

            for (int i = 0; i < itemsNodeList.getLength(); i++) {
                Node copiedNode = resultDoc.importNode(itemsNodeList.item(i), true);
                NamedNodeMap attrMap = copiedNode.getAttributes();
                Node n = attrMap.getNamedItem("name");
                if(n.getNodeValue().equals("object 1")){
                    System.out.println("Items object 1");
                }
                resultRatingsBodyNode.appendChild(copiedNode);
            }


            NodeList valueNodeList = inputDoc.getElementsByTagName("value");
            for (int i = 0; i < valueNodeList.getLength(); i++) {
                Node copiedNode = resultDoc.importNode(valueNodeList.item(i), true);
                Text txt = (Text) copiedNode.getFirstChild();
                txt.setData("NewValue");
                resultRatingsBodyNode.appendChild(copiedNode);
            }

        }

        File file = new File(resultXml);
        processXml(resultDoc, file);
    }

    private void processXml(Document xml, File file) throws TransformerException {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT,"yes");
        tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
        DOMSource source = new DOMSource(xml);
        StreamResult result = new StreamResult(file);
        tf.transform(source,result);
    }
}
