/*
 * A singleton class which manages moon bases. It also identifies the current moon base.
 */
package spaceappschallenge.moonville.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import spaceappschallenge.moonville.domain.Difficulty;
import spaceappschallenge.moonville.domain.MoonBase;
import android.content.Context;
import android.widget.Toast;

/**
 * Creates MoonBase, saves and loads game state.
 */
public class MoonBaseManager {

	public static final String SAVE_FILE = "lastsavedmoonbase.sav";

	// added static since there is only 1 moonbase
	// it's a bit dirty maybe, but also makes it easier to access it everywhere
	// when needed -Jos
	private static MoonBase currentMoonBase;

	public static MoonBase getCurrentMoonBase() {
		return currentMoonBase;
	}

	public static void createNewMoonBase(Difficulty diff, Context context) {
		MoonBaseManager.currentMoonBase = new MoonBase(diff.getMoney());
		MoonBaseManager.currentMoonBase.addPower(1000);//Initial power
		saveMoonBase(context);
	}

	/**
	 * Opens saved game
	 * @param context
	 */
	public static void loadSavedMoonbase(Context context) {
		MoonBase loadedMoonBase = null;

		try {
			FileInputStream fis = new FileInputStream(context.getFilesDir()
					+ File.separator + SAVE_FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);

			loadedMoonBase = (MoonBase) ois.readObject();

			ois.close();
			fis.close();
		}

		catch (FileNotFoundException e) {
			Toast t = Toast.makeText(context,
					"There is no saved Game - Please start a new one.",
					Toast.LENGTH_LONG);
			t.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

		MoonBaseManager.currentMoonBase = loadedMoonBase;
	}

	/**
	 * Saves the game state
	 * @param context
	 */
	public static void saveMoonBase(Context context) {
		try {
			FileOutputStream fos = new FileOutputStream(context.getFilesDir()
					+ File.separator + SAVE_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(MoonBaseManager.currentMoonBase);

			Toast t = Toast.makeText(context, "Saved.", Toast.LENGTH_LONG);
			t.show();

			oos.close();
			fos.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
