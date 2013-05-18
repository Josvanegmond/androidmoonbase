package spaceappschallenge.moonville.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.Building;
import spaceappschallenge.moonville.domain.BuildingDefinition;
import spaceappschallenge.moonville.domain.Research;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import spaceappschallenge.moonville.xml_parsers.BuildingXMLParser;
import spaceappschallenge.moonville.xml_parsers.ResearchXMLParser;
import android.content.Context;
import android.util.Log;

/**
 * Uses parser to provide information about research
 * 
 * @author Dell
 * 
 */
public class Researches {
	private static Researches instance;
	protected static Context context;

	// a list of all possible research
	private ArrayList<Research> allResearch;
	protected InputStream inputStream = null;

	private Researches() {
		this.allResearch = new ArrayList<Research>();
		Researches.context = ApplicationService.getInstance()
				.getApplicationContext();

		initAllResearch();

	}

	/*
	 * Calls the parser to initialize the ArrayList of research
	 */
	protected void initAllResearch() {
		inputStream = context.getResources().openRawResource(R.raw.research);

		try {
			ResearchXMLParser xmlParser = new ResearchXMLParser(inputStream);
			try {
				this.allResearch = xmlParser.parse();
				// printAllBuildings();
			} catch (IOException e) {
				Log.e("Researches",
						"There was problem while parsing the xml file");
			}
		} catch (XmlPullParserException e) {
			Log.e("Researches", "XMLParser could not be instantiated");
		}
	}

	public static Researches getInstance() {
		if (Researches.instance == null) {
			Researches.instance = new Researches();
		}

		return Researches.instance;
	}

	// returns a research object according to its name
	public Research getResearch(String name) {
		Research foundResearch = null;

		for (Research research : this.allResearch) {
			if (research.getName().equals(name)) {
				foundResearch = research;
				break;
			}
		}

		return foundResearch;
	}

	// returns all available research
	public ArrayList<Research> getAllResearch() {
		return this.allResearch;
	}
}
