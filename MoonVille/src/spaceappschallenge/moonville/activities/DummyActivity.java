package spaceappschallenge.moonville.activities;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DummyActivity extends Activity {
	protected Button newCompanyButton;
	protected List<Resource> initialResources;
	protected List<Building> initialBuildings;
	protected MoonBase initialMoonBase;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dummy);
		initMoonBase();
		initUI();
	}

	protected void initResources(){
		Resource oxygen = new Resource("oxygen", 100, (float)0.2);
		Resource helium3 = new Resource("helium-3",50,(float)0.2);
		Resource metal = new Resource("metal",800,(float)0.1);
		initialResources = new ArrayList<Resource>();
		initialResources.add(oxygen);
		initialResources.add(helium3);
		initialResources.add(metal);
		
		
		List<Resource> regolithPlantOutput = new ArrayList<Resource>();
		List<Building> requiredBuildings = new ArrayList<Building>();
		//TODO
//		Building regolithPlant = new Building("Regolith Plant","It processes regolith.",1, initialResources, requiredBuildings,);
//		(String name, String info, int amount,
//				List<Resource> requiredResources, List<Building> requiredBuildings,
//				List<Resource> outputResources, List<Building> outputBuildings,
//				int inputPower, int outputPower)
//	
		}
	
	protected void initBuildings(){
		
	}
	
	protected void initMoonBase(){
		initResources();
		initBuildings();
		//initialMoonBase=new MoonBase(10, 10,10, initialResources, 100000, initialBuildings);
	}
	public void initUI() {
		newCompanyButton = (Button) this.findViewById(R.id.newCompanyButton);
		newCompanyButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_dummy, menu);
		return true;
	}

}
