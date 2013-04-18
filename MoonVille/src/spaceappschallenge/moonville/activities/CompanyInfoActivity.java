package spaceappschallenge.moonville.activities;

import spaceappschallenge.moonville.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CompanyInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_company_info, menu);
		return true;
	}

}
