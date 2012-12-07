package com.in73j.taller.controlador;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axis2.context.MessageContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

import com.in73j.taller.entitie.DatosConsultaFuga;


public class ServicioFuga {
	
	protected DatosConsultaFuga dcf;
	
	//PREDICE FUGA (true = FUGA, false = NO FUGA)
	
	public int isFuga(int idCliente){
		
		cargarDatosCliente(idCliente);
		prepareInstanceXML();
		
		RapidMinerManager rm = new RapidMinerManager();
		
		MessageContext context = MessageContext.getCurrentMessageContext(); 
        ServletContext servletContext = (ServletContext)context.getProperty("transport.http.servletContext"); 
		
        String relativeWebPath = "/WEB-INF/classes/com/in73j/taller/logic/procesoRapidMiner.xml";
        String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
        File file = new File(absoluteDiskPath);
		
        rm.executeProcess(file.getAbsolutePath());
		return (int) rm.getPrediction("Select Attributes");

	}
	
	protected void cargarDatosCliente(int idCliente){
		
		dcf = new DatosConsultaFuga();
		
		dcf.setCod_Cliente(60);
		dcf.setCOD_OFI(10);
		dcf.setCOM(80);
		dcf.setED(28);
		dcf.setSX("M");
		dcf.setNIV_EDUC("UNV");
		dcf.setRENTA(2000);
		dcf.setE_CIVIL("CAS");
		dcf.setVIG(100);
		dcf.setTRX_T(100);
		dcf.setTRX_T_1(200);
		dcf.setTRX_T_2(50);
		dcf.setSALDO_T_5(2000);
		dcf.setSALDO_T_4(4000);
		dcf.setSALDO_T_3(3000);
		dcf.setSALDO_T_2(2000);
		dcf.setSALDO_T_1(1000);
		dcf.setSALDO_T(0);
		dcf.setRENTS();
		
	}
	
	//CARGA EL ARCHIVO INSTANCE XML
	protected void prepareInstanceXML(){
		
		try {
			
				//LEEMOS EL ARCHIVO XML
				MessageContext context = MessageContext.getCurrentMessageContext(); 
				ServletContext servletContext = (ServletContext)context.getProperty("transport.http.servletContext"); 
			
				String relativeWebPath = "/WEB-INF/classes/com/in73j/taller/logic/instance.xml";
				String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
				File f = new File(absoluteDiskPath);
			
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(f);
				
				//GENERAMOS LA LISTA CON LOS ATRIBUTOS DEL OBJETO DocumentosConsultaFuga
				List<String> list = dcf.getList();
				
				NodeList nl = doc.getElementsByTagName("cliente");
				
				//RECORREMOS LA LISTA
				Node nodoCliente = nl.item(0);
				
				NodeList attributes = nodoCliente.getChildNodes();
				
				
				for(int i=0;i<attributes.getLength();i++){
					Node nodo_i = attributes.item(i);
					
					if(!nodo_i.getNodeName().equals("#text")){
						if(i<23)
						nodo_i.getAttributes().getNamedItem("value").setNodeValue(list.get(i));
					}
					
				}
	
				//GUARDAMOS EL ARCHIVO XML
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(f);
				transformer.transform(source, result);	
				
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
