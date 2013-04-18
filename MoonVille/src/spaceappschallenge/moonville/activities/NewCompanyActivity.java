/*
 * Starts the game. Initializes managers based on user choices.
 */
package spaceappschallenge.moonville.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.*;
import spaceappschallenge.moonville.managers.MoonBaseManager;


public class NewCompanyActivity extends Activity {

	protected Button mNewCompanyButton;
	protected MoonBaseManager mMoonBaseManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_company);
		initUI();
		
	}
	
	protected void initUI(){
		mNewCompanyButton= (Button)findViewById(R.id.newCompanyButton);
		mNewCompanyButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
			}
		});
	}
	
	protected void initModels(){
		//Dummy models
		
		//MoonBase moonBase = new MoonBase()
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_new_company, menu);
		return true;
	}

}
