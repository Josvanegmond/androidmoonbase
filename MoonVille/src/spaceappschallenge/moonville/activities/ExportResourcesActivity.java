package spaceappschallenge.moonville.activities;

import java.util.List;

import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.domain.ImportCompany;
import spaceappschallenge.moonville.domain.MoonBase;
import spaceappschallenge.moonville.domain.Resource;
import spaceappschallenge.moonville.factories.ImportCompanies;
import spaceappschallenge.moonville.factories.MoonBaseManager;
import spaceappschallenge.moonville.listadapters.ExportResourceListAdapter;
import spaceappschallenge.moonville.miscellaneous.SerializablePair;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ExportResourcesActivity extends GameActivity {
	private List<ImportCompany> companies;
	private int companyIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_export_resources);

		this.companyIndex = 0;
		this.companies = ImportCompanies.getInstance()
				.getCompaniesByMinimumReputation(100);

		updateUI();
	}

	public void updateUI() {
		if (this.companies.size() > 0) {
			ImportCompany company = this.companies.get(this.companyIndex);
			TextView companyName = (TextView) this.findViewById(R.id.export_company_name);
			TextView companyInfo = (TextView) this.findViewById(R.id.companyinfo);
			ListView exportResourceList = (ListView) this.findViewById(R.id.importresourcelist);

			companyName.setText(company.getName());
			companyInfo.setText(company.getInfo());
			exportResourceList.setAdapter(new ExportResourceListAdapter(company
					.getImportResources()));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_export_resources, menu);
		return true;
	}

	// methods called by onClick property of button in xml

	/**
	 * export grabs the selected company, checks the resource demand, and
	 * compares it to the resources stored in moonbase. If there are enough
	 * resources, the resources are substracted from moonbase and money is
	 * added.
	 * 
	 * TODO: reputation involvement
	 */
	public void export(View view) {
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		ImportCompany company = companies.get(this.companyIndex);

		List<SerializablePair<Resource, Integer>> moonBaseResources = moonBase
				.getStoredResources();
		List<SerializablePair<Resource, Integer>> importResources = company
				.getImportResources();

		boolean canExport = true;

		// check if enough resources have been gathered to export the resources
		// canExport will be set accordingly
		for (SerializablePair<Resource, Integer> importResource : importResources) {
			SerializablePair<Resource, Integer> moonBaseResource = null;

			for (SerializablePair<Resource, Integer> searchResource : moonBaseResources) {
				if (searchResource.first.getName().equals(
						importResource.first.getName())) {
					moonBaseResource = searchResource;
					break;
				}
			}

			if (moonBaseResource != null) {
				if (moonBaseResource.second < importResource.second) {
					canExport = false;
					Toast.makeText(
							this,
							"Can't export, resources in stock, but demand not satisfied",
							500).show();
					break;
				}
			} else {
				canExport = false;
				Toast.makeText(this,
						"Can't export, demanded resources not in stock", 500)
						.show();
				break;
			}
		}

		// if we can export, subtract resources and add money
		if (canExport == true) {
			moonBase.setMoney(moonBase.getMoney() + company.getPayment());
			moonBase.decreaseResources(importResources);
			Toast.makeText(this,
					"Exported, payment is " + company.getPayment(), 500).show();
		}
	}

	public void nextImportCompany(View view) {
		this.companyIndex++;
		if (this.companyIndex >= this.companies.size()) {
			this.companyIndex = 0;
		}

		this.updateUI();
	}

	public void previousImportCompany(View view) {
		this.companyIndex--;
		if (this.companyIndex < 0) {
			this.companyIndex = this.companies.size() - 1;
			if (this.companyIndex < 0) {
				this.companyIndex = 0;
			}
		}

		this.updateUI();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			startActivity(new Intent(ExportResourcesActivity.this,
					BaseOverviewActivity.class));
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

}
