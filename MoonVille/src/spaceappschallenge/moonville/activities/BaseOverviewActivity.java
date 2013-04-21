package spaceappschallenge.moonville.activities;

import java.util.ArrayList;
import java.util.List;

import spaceappschallenge.moonville.GameActivity;
import spaceappschallenge.moonville.R;
import spaceappschallenge.moonville.businessmodels.Building;
import spaceappschallenge.moonville.businessmodels.BuildingTree;
import spaceappschallenge.moonville.businessmodels.MoonBase;
import spaceappschallenge.moonville.businessmodels.Resource;
import spaceappschallenge.moonville.factories.Buildings;
import spaceappschallenge.moonville.factories.Resources;
import spaceappschallenge.moonville.managers.MoonBaseManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;

public class BaseOverviewActivity extends GameActivity {

	private AbsoluteLayout moonSurfaceLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_overview);
		Log.i("Base","showing moon");
		moonSurfaceLayout = (AbsoluteLayout) this
				.findViewById(R.id.moonsurface_relativelayout);
		Log.i("Base","showing buildings");
		
		showBuildings();
		fixHVScrollViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_base_overview, menu);
		return true;
	}

	private void showBuildings() {
		Log.i("Base","getting buildings");
		
		List<Building> buildings = Buildings.getInstance().getAllBuildings();
		
		for (Building building : buildings) {
			ImageView buildingImage = new ImageView(this);
			android.content.res.Resources res = this.getResources();
			Log.d("debug", building.getName().replace(" ", "_").toLowerCase());
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

			buildingImage.setLayoutParams(buildingParams);

			moonSurfaceLayout.addView(buildingImage);
		}
	}

	// methods called by onClick property of button in xml
	public void nextTurn(View view) {
		MoonBase moonBase = MoonBaseManager.getCurrentMoonBase();
		BuildingTree tree = moonBase.getBuiltBuildings();
		tree.checkPower();
		//tree.checkRequiredBuildings();

		Resources resources = Resources.getInstance();
		ArrayList<Resource> available = (ArrayList<Resource>) tree
				.checkResources(resources.getAvailableResources());
		resources.setAvailableResources(available);

		// TODO: factor in research and prospecting bonus
		// TODO: calculate reputation

		// last step, save to file
		MoonBaseManager.saveMoonBase(view.getContext());
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
	
	
	
	//some scrollbar fix for scrolling
	private void fixHVScrollViews()
	{
	    final HorizontalScrollView hScroll = (HorizontalScrollView) findViewById(R.id.moonsurface_hscrollview);
	    final ScrollView vScroll = (ScrollView) findViewById(R.id.moonsurface_vscrollview);
	    vScroll.setOnTouchListener(new View.OnTouchListener() { //inner scroll listener         
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            return false;
	        }
	    });
	    hScroll.setOnTouchListener(new View.OnTouchListener() { //outer scroll listener         
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
