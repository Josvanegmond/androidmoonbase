package spaceappschallenge.moonville.activities;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.MoonVille;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.Building;
import spaceappschallenge.moonville.businessmodels.BuildingTree;
import spaceappschallenge.moonville.businessmodels.MoonBase;
import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.factories.Resources;
import spaceappschallenge.moonville.managers.MoonBaseManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class BaseOverviewActivity extends GameActivity {

	private AbsoluteLayout moonSurfaceLayout;
	private ArrayList<ImageView> buildingImageList;
	
	private static String PREFERENCE_SCROLL_X = "base_overview_scroll_x";
	private static String PREFERENCE_SCROLL_Y = "base_overview_scroll_y";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_overview);
		Log.i("Base", "showing moon");
		moonSurfaceLayout = (AbsoluteLayout) this
				.findViewById(R.id.moonsurface_relativelayout);
		Log.i("Base", "showing buildings");

		this.buildingImageList = new ArrayList<ImageView>();

		showBuildings();
		fixHVScrollViews();
		updateUI();
	}
	
	/**
	 * Saves scroll position.
	 */
	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences.Editor editor = 
				getSharedPreferences(MoonVille.PREFERENCE_FILE, 0).edit();
		final HorizontalScrollView hScroll = (HorizontalScrollView) 
				findViewById(R.id.moonsurface_hscrollview);
		final ScrollView vScroll = (ScrollView) 
				findViewById(R.id.moonsurface_vscrollview);
		editor.putInt(PREFERENCE_SCROLL_X, hScroll.getScrollX());
		editor.putInt(PREFERENCE_SCROLL_Y, vScroll.getScrollY());
		editor.commit();
	}

	/**
	 * Restores scroll position.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		final SharedPreferences settings = 
				getSharedPreferences(MoonVille.PREFERENCE_FILE, 0);
		final HorizontalScrollView hScroll = (HorizontalScrollView) 
				findViewById(R.id.moonsurface_hscrollview);
		final ScrollView vScroll = (ScrollView) 
				findViewById(R.id.moonsurface_vscrollview);
		// Don't know why, but using post is the only way to make this work.
		hScroll.post(new Runnable() {			
			@Override
			public void run() {
				hScroll.scrollTo(settings.getInt(PREFERENCE_SCROLL_X, 0), 0);
			}
		});
		vScroll.post(new Runnable() {			
			@Override
			public void run() {
				vScroll.scrollTo(0, settings.getInt(PREFERENCE_SCROLL_Y, 0));
			}
		});
	}

	public void updateUI() {
		TextView baseOverviewFundsTextView = (TextView) (this
				.findViewById(R.id.baseOverviewFundsTextView));
		baseOverviewFundsTextView.setText("Funds: "
				+ MoonBaseManager.getCurrentMoonBase().getMoney());

		TextView txtMonth = (TextView) (this.findViewById(R.id.txtMonth));
		txtMonth.setText("" + MoonBaseManager.getCurrentMoonBase().getMonth());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_base_overview, menu);
		return true;
	}

	private void showBuildings() {

		for (ImageView buildingImage : buildingImageList) {
			((AbsoluteLayout) buildingImage.getParent())
					.removeView(buildingImage);
		}

		buildingImageList.clear();

		List<Building> buildings = Buildings.getInstance().getAllBuildings();
		
		for (final Building building : buildings)
		{
			ImageView buildingImage = new ImageView(this);
			
			buildingImage.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view)
				{
					Intent intent = new Intent(BaseOverviewActivity.this, BuildingInfoActivity.class);
					intent.putExtra( "Building", building );
					view.getContext().startActivity( intent );
					BaseOverviewActivity.this.finish();
				}
			});

			buildingImageList.add(buildingImage);

			android.content.res.Resources res = this.getResources();

			int resID = res
					.getIdentifier("ref_"
							+ building.getName().replace(" ", "_")
									.toLowerCase(), "drawable",
							getPackageName());
			Drawable buildingDrawable = res.getDrawable(resID);
			buildingImage.setImageDrawable(buildingDrawable);

			AbsoluteLayout.LayoutParams buildingParams = new AbsoluteLayout.LayoutParams(
					buildingDrawable.getIntrinsicWidth(),
					buildingDrawable.getIntrinsicHeight(),
					building.getXPos() * 2, building.getYPos() * 2);
			
			boolean canBeBuild = true;
			
			for( Building requiredBuilding : building.getRequiredBuildings() )
			{
				if( MoonBaseManager.getCurrentMoonBase().getBuildBuildingsList().contains( requiredBuilding ) == false )
				{
					canBeBuild = false;
					break;
				}
			}
			
			//buildingImage.setClickable( canBeBuild );
			if( canBeBuild == false )
			{
				buildingImage.setAlpha( 50 );
			}
			else
			{
				buildingImage.setAlpha( 100 );
			}
			
			buildingImage.setLayoutParams(buildingParams);

			moonSurfaceLayout.addView(buildingImage);
		}
	}

	// methods called by onClick property of button in xml
	public void nextTurn(View view) {
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		BuildingTree tree = moonBase.getBuiltBuildings();
		tree.checkPower();
		tree.checkRequiredBuildings();

		Resources resources = Resources.getInstance();
		ArrayList<Resource> available = (ArrayList<Resource>) tree
				.checkResources(resources.getAvailableResources());
		resources.setAvailableResources(available);

		// TODO: factor in research and prospecting bonus
		// TODO: calculate reputation

		// last step, save to file
		MoonBaseManager.getCurrentMoonBase().setMonth(
				MoonBaseManager.getCurrentMoonBase().getMonth() + 1);
		updateUI();
		MoonBaseManager.saveMoonBase(view.getContext());

	}

	public void showImportResourcesScreen(View view) {
		view.getContext().startActivity(
				new Intent(this, ImportResourcesActivity.class));
		this.finish();
	}

	public void showExportResourcesScreen(View view) {
		view.getContext().startActivity(
				new Intent(this, ExportResourcesActivity.class));
		this.finish();

	}

	public void showBaseOverviewScreen(View view) {
		// we are already here
		// view.getContext().startActivity( new Intent( this,
		// BaseOverviewActivity.class ) );
		// this.finish();
	}

	public void showResourcesScreen(View view) {
		view.getContext().startActivity(
				new Intent(this, ResourcesActivity.class));
		this.finish();
	}

	public void showExportScreen(View view) {
		view.getContext().startActivity(
				new Intent(this, ResourcesActivity.class));
		this.finish();
	}

	// some scrollbar fix for scrolling
	private void fixHVScrollViews() {
		final HorizontalScrollView hScroll = (HorizontalScrollView) findViewById(R.id.moonsurface_hscrollview);
		final ScrollView vScroll = (ScrollView) findViewById(R.id.moonsurface_vscrollview);
		vScroll.setOnTouchListener(new View.OnTouchListener() { // inner scroll
																// listener
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
		});
		hScroll.setOnTouchListener(new View.OnTouchListener() { // outer scroll
																// listener
			private float mx, my, curX, curY;
			private boolean started = false;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				curX = event.getX();
				curY = event.getY();
				int dx = (int) (mx - curX);
				int dy = (int) (my - curY);
				switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE:
					if (started) {
						vScroll.scrollBy(0, dy);
						hScroll.scrollBy(dx, 0);
					} else {
						started = true;
					}
					mx = curX;
					my = curY;
					break;
				case MotionEvent.ACTION_UP:
					vScroll.scrollBy(0, dy);
					hScroll.scrollBy(dx, 0);
					started = false;
					break;
				}
				return true;
			}
		});
	}
}