/*
 * The sole purpose of this class is to provide application "Context".
 */
package spaceappschallenge.moonville.managers;

import android.content.Context;
import android.util.Log;

/**
 * Provides singleton access to application context.
 */
public class ApplicationService
{
	protected static ApplicationService instance;
	private static Context applicationContext;
	
	protected ApplicationService(){
		//just to make sure it can't be instantiated
	}
	
	public static ApplicationService getInstance(){
		Log.i("AppService","getInstance()");
		if(ApplicationService.instance==null){
			Log.i("AppService","instance is null");
			ApplicationService.instance=new ApplicationService();}
		return ApplicationService.instance;
	}
	
	public void setApplicationContext(Context applicationContext){
		ApplicationService.applicationContext=applicationContext;
	}
	
	public Context getApplicationContext()
	{
		if( ApplicationService.applicationContext == null )
		{
			Log.d( "Error", "Application context has not been provided to ApplicationService before getApplicationContext() is called." );
		}
		
		return ApplicationService.applicationContext;
	}
}
//public class ApplicationService extends Application {
//	protected static ApplicationService instance;
//	private static Context applicationContext;
//
//	@Override
//	public void onCreate() {
//		super.onCreate();
//		ApplicationService.applicationContext = getApplicationContext();
//	}
//
//	public Resources getResources() {
//		return ApplicationService.instance.getResources();
//	}
//
//	public Context getApplicationContext() {
//		while (ApplicationService.applicationContext == null) {
//			Log.i("ApplicationService", "app context is null");
//		}
//		return ApplicationService.applicationContext;
//	}
//}
