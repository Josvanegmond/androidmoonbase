package spaceappschallenge.moonville.xml_parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.managers.ApplicationService;
import android.content.Context;

/*
 * Parses XML containing information about resources and stores each resource in an ArrayList. 
 * 
 *  @author Robik
 */
public class ResourceXMLParser {
	protected Context context = null;
	protected InputStream inputStream = null;
	protected XmlPullParser xpp;
	protected ArrayList<Resource> resources;

	public ResourceXMLParser(InputStream inputStream)
			throws XmlPullParserException {
		this.inputStream = inputStream;
		this.context = ApplicationService.getInstance().getApplicationContext();
		XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
		xmlFactory.setNamespaceAware(true);
		xpp = xmlFactory.newPullParser();
		this.resources = new ArrayList<Resource>();
	}

	// Create "Resource" objects by parsing input stream
	public ArrayList<Resource> parse() throws XmlPullParserException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				this.inputStream));
		xpp.setInput(br);
		String startTagName = "";
		int eventType = xpp.getEventType();
		Resource resource = null;
		String name = "";
		double quality = 0.0;
		int importPrice = 0;
		int exportPrice = 0;
		int weight = 0;

		// Parse the xml file to create "resource" objects
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				startTagName = xpp.getName();
				if (startTagName.equals("resource")) {
					name = xpp.getAttributeValue(null, "name");
					quality = Double.parseDouble(xpp.getAttributeValue(null,
							"quality"));
					importPrice = Integer.parseInt(xpp.getAttributeValue(null,
							"importPrice"));
					exportPrice = Integer.parseInt(xpp.getAttributeValue(null,
							"exportPrice"));
					weight = Integer.parseInt(xpp.getAttributeValue(null,
							"weight"));
					resource = new Resource(name, quality, importPrice,
							exportPrice, weight);
					resources.add(resource);
				}
			}
			eventType = xpp.next();
		}
		return this.resources;
	}

}
