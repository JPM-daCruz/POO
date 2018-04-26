package project;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {

   public static void main(String[] args) {

      try {
         File inputFile = new File("input.txt");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         Node node = doc.getDocumentElement();

         NodeList data = doc.getElementsByTagName("simulation");
         int finalinst = Integer.parseInt(doc.getDocumentElement().getAttribute("finalinst"));
         int initpop = Integer.parseInt(doc.getDocumentElement().getAttribute("initpop"));
         int maxpop = Integer.parseInt(doc.getDocumentElement().getAttribute("maxpop"));
         int comfortsens = Integer.parseInt(doc.getDocumentElement().getAttribute("comfortsens"));
         NodeList data1 = doc.getElementsByTagName("grid");
         int colsnb = Integer.parseInt(data1.item(0).getAttributes().getNamedItem("colsnb").getNodeValue());
         int rowsnb = Integer.parseInt(data1.item(0).getAttributes().getNamedItem("rowsnb").getNodeValue());
         NodeList data2 = doc.getElementsByTagName("initialpoint");
         int xinicial = Integer.parseInt(data2.item(0).getAttributes().getNamedItem("xinicial").getNodeValue());
         int yinicial = Integer.parseInt(data2.item(0).getAttributes().getNamedItem("yinicial").getNodeValue());
         NodeList data3 = doc.getElementsByTagName("finalpoint");
         int xfinal = Integer.parseInt(data3.item(0).getAttributes().getNamedItem("xfinal").getNodeValue());
         int yfinal = Integer.parseInt(data3.item(0).getAttributes().getNamedItem("yfinal").getNodeValue());
         NodeList data4 = doc.getElementsByTagName("zone");
         int sczoneslength = data4.getLength();
         int[] sczXinitial =new int[sczoneslength];
         int[] sczYinitial =new int[sczoneslength];
         int[] sczXfinal =new int[sczoneslength];
         int[] sczYfinal =new int[sczoneslength];
         for(int i=0; i<sczoneslength; i++ )
         {
        	 sczXinitial[i] = Integer.parseInt(data4.item(i).getAttributes().getNamedItem("xinicial").getNodeValue());
        	 sczYinitial[i] = Integer.parseInt(data4.item(i).getAttributes().getNamedItem("yinicial").getNodeValue());
        	 sczXfinal[i] = Integer.parseInt(data4.item(i).getAttributes().getNamedItem("xfinal").getNodeValue());
        	 sczYfinal[i] = Integer.parseInt(data4.item(i).getAttributes().getNamedItem("yfinal").getNodeValue());
         }
         
         NodeList data5 = doc.getElementsByTagName("obstacle");
         int obslength = data5.getLength();
         int[] obsx =new int[obslength];
         int[] obsy =new int[obslength];
         
         for(int i=0; i<obslength; i++ )
         {
        	 obsx[i] = Integer.parseInt(data5.item(i).getAttributes().getNamedItem("xpos").getNodeValue());
        	 obsy[i] = Integer.parseInt(data5.item(i).getAttributes().getNamedItem("ypos").getNodeValue());
         }
         NodeList data6 = doc.getElementsByTagName("death");
         int deathparam = Integer.parseInt(data6.item(0).getAttributes().getNamedItem("param").getNodeValue());
         NodeList data7 = doc.getElementsByTagName("reproduction");
         int reproparam = Integer.parseInt(data7.item(0).getAttributes().getNamedItem("param").getNodeValue());
         NodeList data8 = doc.getElementsByTagName("move");
         int moveparam = Integer.parseInt(data8.item(0).getAttributes().getNamedItem("param").getNodeValue());
         System.out.println(moveparam);
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}