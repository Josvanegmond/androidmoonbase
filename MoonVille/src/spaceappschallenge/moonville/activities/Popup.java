package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.xml_parsers.BuildingDefinition;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Popup extends AsyncTask<Void,Integer,Void>
{
	private View resourcePopup;
	private RelativeLayout.LayoutParams popupParams;
	private TextView textView;
	private ViewGroup parent;
	private Context context;
	private String text;
	private int waitTime;
	private int xPos, yPos;
	
	public Popup( Context context, ViewGroup parent, String text, int xPos, int yPos, int waitTime )
	{
		this.context = context;
		this.parent = parent;
		this.text = text;
		this.waitTime = waitTime;
		this.xPos = xPos;
		this.yPos = yPos;
		this.waitTime = waitTime;
		
		execute();
	}
	
	@Override
	protected void onPreExecute()
	{
		LayoutInflater inflater = LayoutInflater.from( context );
		resourcePopup = inflater.inflate(R.layout.overview_popup, parent, false);
		textView = (TextView) resourcePopup.findViewById( R.id.text );
		textView.setText( text );
		
		//place the popup in the background according to position determined in Building object
		popupParams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT );
		popupParams.leftMargin = xPos;
		popupParams.topMargin = yPos;

		resourcePopup.setLayoutParams( popupParams );
		textView.setTextColor( Color.argb( 0, 255, 255, 255 ) );
		resourcePopup.setBackgroundColor( Color.argb( 0, 20, 20, 20 ) );
		parent.addView( resourcePopup );
	}
	
	
	@Override
	protected Void doInBackground( Void... args )
	{
		try
		{
			int alpha = 1, dtAlpha = 22;
			
			Thread.sleep( waitTime );
			
			while( alpha > 0 )
			{
				this.publishProgress( alpha );
				alpha+=dtAlpha;
				dtAlpha--;
				
				Thread.sleep( 20 );
			}

			this.publishProgress( 0 );
		}
		catch( InterruptedException e )
		{
			
		}
		
		return null;
	}
	
	@Override
	protected void onProgressUpdate( Integer... values )
	{
		textView.setTextColor( Color.argb( values[0], 255, 255, 255 ) );
		resourcePopup.setBackgroundColor( Color.argb( values[0], 20, 20, 20 ) );
		popupParams.topMargin -= 1;
		resourcePopup.setLayoutParams( popupParams );
	}
	
	@Override
	protected void onPostExecute( Void result )
	{
		parent.removeView( resourcePopup );
	}

}
