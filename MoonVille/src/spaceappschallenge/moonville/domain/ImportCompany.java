package spaceappschallenge.moonville.domain;

import java.util.ArrayList;
import java.util.List;

import android.util.Pair;

import spaceappschallenge.moonville.factories.Resources;

public class ImportCompany {
	protected String name;
	protected String info;
	protected List<Pair<Resource, Integer>> importResources;
	protected double paymentFactor;
	protected int requiredReputation;

	public ImportCompany(String companyName, String companyInfo,
			double paymentFactor2, int requiredReputation,
			ArrayList<Pair<Resource, Integer>> importResources) {
		this.name = companyName;
		this.info = companyInfo;
		this.paymentFactor = paymentFactor2;
		this.requiredReputation = requiredReputation;
		this.importResources = importResources;
	}

	public int getPayment() {
		Resources resources = Resources.getInstance();

		int totalMoneySum = 0;
		for (Pair<Resource, Integer> resource : this.importResources) {
			Resource resourceDefinition = resources.getResource(resource.first
					.getName());
			totalMoneySum += resource.second
					* resourceDefinition.getExportPrice();// second = amount
		}

		return (int) (this.paymentFactor * totalMoneySum);
	}

	public int getRequiredReputation() {
		return this.requiredReputation;
	}

	public String getName() {
		return this.name;
	}

	public String getInfo() {
		return this.info;
	}

	public List<Pair<Resource, Integer>> getImportResources() {
		return this.importResources;
	}
}
