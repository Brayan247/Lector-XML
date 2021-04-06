/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerxml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ordenador
 */
public class LeerXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File archivo = new File("C:\\Users\\Ordenador\\Documents\\tercero\\Base de datos\\datos.xml");//Cargamos el archivo desde nuestro ordenador
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//Creamos el DocumentBuilderFactory
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();//Creamos otro documento como el anterior pero aqui añadimos un nuevo documento
            Document document = documentBuilder.parse(archivo);//Creamos un documento al cual añadiremos nuestro archivo
            document.getDocumentElement().normalize();//Obtenemos el documento xml
            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());//Obtenemos el nombre de la llave principal
            NodeList listaEmpleados = document.getElementsByTagName("empleado");//Aqui ponemos el nombre de la lista que queremos adquirir
            for (int temp = 0; temp < listaEmpleados.getLength(); temp++) {//Esto nos dara todos los elementos de la lista seleccionada
                Node nodo = listaEmpleados.item(temp);//Aqui asignamos los datos de la lista a nuestro nodo con el cual los traeremos
                System.out.println("Elemento:" + nodo.getNodeName());//Aqui obtenemos el nombre de lo que estamos traendo, en nuestro caso serian los empleados
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;//Con esto obtendremos los elementos de nuestra tabla y se asignaran a nuestros nodos
                    System.out.println("id: " + element.getAttribute("id"));
                    System.out.println("Nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("username: " + element.getElementsByTagName("username").item(0).getTextContent());
                    System.out.println("password: " + element.getElementsByTagName("password").item(0).getTextContent());//Con esto estamos traendo los datos
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    


