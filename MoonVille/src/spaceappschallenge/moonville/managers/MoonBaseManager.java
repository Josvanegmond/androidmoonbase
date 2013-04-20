/*
 * A singleton class which manages moon bases. It also identifies the current moon base.
 */
package spaceappschallenge.moonville.managers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import spaceappschallenge.moonville.businessmodels.Difficulty;
import spaceappschallenge.moonville.businessmodels.MoonBase;

public class MoonBaseManager {
	// added static since there is only 1 moonbase
	// it's a bit dirty maybe, but also makes it easier to access it everywhere
	// when needed -Jos
	private static MoonBase currentMoonBase;

	public static MoonBase getCurrentMoonBase() {
		return currentMoonBase;
	}

	public static void createNewMoonBase(Difficulty diff) {
		MoonBaseManager.currentMoonBase = new MoonBase(
				diff.getResearchPoints(), diff.getProspectingLevel(),
				diff.getMoney());
		MoonBaseManager.saveMoonBase();
	}

	public static void loadSavedMoonbase() {
		MoonBase currentMoonBase = null;

		try {
			FileInputStream fis = new FileInputStream("lastsavedmoonbase.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);

			currentMoonBase = (MoonBase) ois.readObject();

			ois.close();
			fis.close();
		}

		catch (IOException e) {
		}

		catch (ClassNotFoundException e) {
		}

		MoonBaseManager.currentMoonBase = currentMoonBase;
	}

	public static void saveMoonBase() {
		try {
			FileOutputStream fos = new FileOutputStream("lastsavedmoonbase.sav");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(MoonBaseManager.currentMoonBase);

			oos.close();
			fos.close();
		}

		catch (IOException e) {
		}
	}
}
