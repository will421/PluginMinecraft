package com.gmail.willou421.PluginWill;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.bukkit.Bukkit;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PluginWillConf {

	private String nomFichier;
	private MultExpConf mxc;

	public MultExpConf getMexc() {
		return mxc;
	}

	public void setMexc(MultExpConf mxc) {
		this.mxc = mxc;
	}
	
	
	public PluginWillConf(String file) {
		// TODO Auto-generated constructor stub
		nomFichier = file;
		File f = new File(nomFichier);
		if (!f.canRead()) { writeXMLFile(nomFichier);}
		ReadXMLFile(nomFichier);
	}
	
	private void writeXMLFile(String path) {
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("pluginwill");
			doc.appendChild(rootElement);
	 
			// staff elements
			Element multexp = doc.createElement("multexp");
			rootElement.appendChild(multexp);
	 
			// set attribute to staff element
			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			multexp.setAttributeNode(attr);
	 
			// shorten way
			// multexp.setAttribute("id", "1");
	 
			// firstname elements
			Element coeff = doc.createElement("coeff");
			coeff.appendChild(doc.createTextNode("1"));
			multexp.appendChild(coeff);
	 
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			Bukkit.getServer().getConsoleSender().sendMessage(("PluginWill : "+path+" cree !"));
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		
		
	}


	private void ReadXMLFile(String path) {
		try {
			 
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
		 
			//Bukkit.broadcastMessage("Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getDocumentElement().getChildNodes();
		 
			for (int i = 0; i < nList.getLength(); i++) {
		 
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//Bukkit.broadcastMessage("\nCurrent Element :" + eElement.getNodeName());
					switch(eElement.getNodeName()) {
					case "multexp": setMexc(new MultExpConf(eElement)); break;
	
					default: throw new Exception("Chargement des configurations de pluginWill : noeud "+eElement.getNodeName()+ "inconnu");		
					}
				}
			}
			Bukkit.getServer().getConsoleSender().sendMessage(("PluginWill : "+path+" charge !"));
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	}


	public void EditXMLFile() {
		try {
			String path = nomFichier;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(path);
	 
			// Get the root element
			Node company = doc.getFirstChild();
	 
			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();
	 
			// Get the staff element by tag name directly
			Node multexp = doc.getElementsByTagName("multexp").item(0);
	 
			// loop the staff child node
			NodeList list = multexp.getChildNodes();
	 
			for (int i = 0; i < list.getLength(); i++) {
	 
	                   Node node = list.item(i);
	 
			   // get the coeff element, and update the value
			   if ("coeff".equals(node.getNodeName())) {
				node.setTextContent(String.valueOf(getMexc().getCoeff()));
			   }
	 
			}
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));
			transformer.transform(source, result);
	 
			Bukkit.getServer().getConsoleSender().sendMessage(("Configuration PluginWill enregistree dans : "+path));
	 
		   } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		   } catch (TransformerException tfe) {
			tfe.printStackTrace();
		   } catch (IOException ioe) {
			ioe.printStackTrace();
		   } catch (SAXException sae) {
			sae.printStackTrace();
		   }
	}
	}