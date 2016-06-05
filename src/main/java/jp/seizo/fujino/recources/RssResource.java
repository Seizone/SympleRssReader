package jp.seizo.fujino.recources;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import jp.seizo.fujino.dao.RssLinkBean;

public class RssResource {

	private ArrayList<RssLinkBean> rsslist;
	String path = "http://www.apple.com/jp/main/rss/hotnews/hotnews.rss";

	public RssResource() {

        //parseXML(path);
	}

	public ArrayList<RssLinkBean> parseXML(String path) {
		ArrayList<RssLinkBean> rsslist = new ArrayList<RssLinkBean>();
        try {
            DocumentBuilderFactory  factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder         builder = factory.newDocumentBuilder();
            Document                document = builder.parse(path);
            Element                 root = document.getDocumentElement();

            /* Get and print Title of RSS Feed. */
            NodeList                channel = root.getElementsByTagName("channel");
            NodeList                title = ((Element)channel.item(0)).getElementsByTagName("title");
            System.out.println("\nTitle: " + title.item(0).getFirstChild().getNodeValue() + "\n");

            /* Get Node list of RSS items */
            NodeList                item_list = root.getElementsByTagName("item");
            for (int i = 0; i <item_list.getLength(); i++) {
                Element  element = (Element)item_list.item(i);
                NodeList item_title = element.getElementsByTagName("title");
                NodeList item_link  = element.getElementsByTagName("link");
                //System.out.println(" title: " + item_title.item(0).getFirstChild().getNodeValue());
                RssLinkBean bean = new RssLinkBean();
                bean.setTitleName(item_title.item(0).getFirstChild().getNodeValue());
                bean.setLinkUrl(item_link.item(0).getFirstChild().getNodeValue());
                rsslist.add(bean);
                //System.out.println(" link:  " + item_link.item(0).getFirstChild().getNodeValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
        } catch (ParserConfigurationException e) {
            System.out.println("Parser Configuration Exception");
        } catch (SAXException e) {
            System.out.println("SAX Exception");
        }
        return rsslist;
    }
}
