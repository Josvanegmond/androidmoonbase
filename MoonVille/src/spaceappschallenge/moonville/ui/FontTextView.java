package spaceappschallenge.moonville.ui;

import spaceappschallenge.moonville.GameActivity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class FontTextView extends TextView
{
	public FontTextView(Context context)
	{
		super(context);
		this.setTypeface( GameActivity.NASALISATION_FONT, 1 );
	}

	public FontTextView( Context context, AttributeSet attrs )
	{
		super(context, attrs);
		this.setTypeface( GameActivity.NASALISATION_FONT, 1 );
	}
	
	public FontTextView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		this.setTypeface( GameActivity.NASALISATION_FONT, 1 );
	}
}
