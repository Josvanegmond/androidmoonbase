/*
 * This class provides application context.
 * Also, it stores instances of Activities.
 */
package spaceappschallenge.moonville.factories;

import spaceappschallenge.moonville.activities.BaseOverviewActivity;
import spaceappschallenge.moonville.activities.ImportResourcesActivity;
import spaceappschallenge.moonville.activities.InitialLaunchActivity;
import android.content.Context;
import android.util.Log;

/**
 * Provides singleton access to application context.
 */
public class ApplicationService {
	protected static ApplicationService instance;
	private static Context applicationContext;
	private static BaseOverviewActivity baseOverviewActivity;
	private static ImportResourcesActivity importResourcesActivity;
	private static InitialLaunchActivity initialLaunchActivity;

	protected ApplicationService() {
		// just to make sure it can't be instantiated
	}

	public static ApplicationService getInstance() {
		Log.i("AppService", "getInstance()");
		if (ApplicationService.instance == null) {
			Log.i("AppService", "instance is null");
			ApplicationService.instance = new ApplicationService();
		}
		return ApplicationService.instance;
	}

	public void setApplicationContext(Context applicationContext) {
		ApplicationService.applicationContext = applicationContext;
	}

	public Context getApplicationContext() {
		if (ApplicationService.applicationContext == null) {
			Log.d("Error",
					"Application context has not been provided to ApplicationService before getApplicationContext() is called.");
		}

		return ApplicationService.applicationContext;
	}

	public static BaseOverviewActivity getBaseOverviewActivity() {
		return baseOverviewActivity;
	}

	public static void setBaseOverviewActivity(
			BaseOverviewActivity baseOverviewActivity) {
		ApplicationService.baseOverviewActivity = baseOverviewActivity;
	}

	public static ImportResourcesActivity getImportResourcesActivity() {
		return importResourcesActivity;
	}

	public static InitialLaunchActivity getInitialLaunchActivity() {
		return initialLaunchActivity;
	}

	public static void setImportResourcesActivity(
			ImportResourcesActivity importResourcesActivity) {
		ApplicationService.importResourcesActivity = importResourcesActivity;
	}

	public static void setInitialLaunchActivity(
			InitialLaunchActivity initialLaunchActivity) {
		ApplicationService.initialLaunchActivity = initialLaunchActivity;
	}

}
// public class ApplicationService extends Application {
// protected static ApplicationService instance;
// private static Context applicationContext;
//
// @Override
// public void onCreate() {
// super.onCreate();
// ApplicationService.applicationContext = getApplicationContext();
// }
//
// public Resources getResources() {
// return ApplicationService.instance.getResources();
// }
//
// public Context getApplicationContext() {
// while (ApplicationService.applicationContext == null) {
// Log.i("ApplicationService", "app context is null");
// }
// return ApplicationService.applicationContext;
// }
// }
