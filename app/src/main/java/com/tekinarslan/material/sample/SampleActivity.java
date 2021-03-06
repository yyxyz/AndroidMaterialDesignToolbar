package com.tekinarslan.material.sample;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SampleActivity extends AppCompatActivity {

  private String[] titles = new String[]{"Sample Tab 1", "Sample Tab 2", "Sample Tab 3", "Sample Tab 4",
          "Sample Tab 5", "Sample Tab 6", "Sample Tab 7", "Sample Tab 8"};

  private DrawerLayout mDrawerLayout;
  private ActionBarDrawerToggle drawerToggle;
  private ListView mDrawerList;
  private Toolbar mToolbar;

  ViewPager pager;
  SlidingTabLayout slidingTabLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);

    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    if (mToolbar != null) {
      setSupportActionBar(mToolbar);
      mToolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
    }

    pager = (ViewPager) findViewById(R.id.viewpager);
    pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), titles));

    slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
    slidingTabLayout.setViewPager(pager);
    slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
      @Override
      public int getIndicatorColor(int position) {
        return Color.GREEN;
      }
    });

    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
    mDrawerLayout.setDrawerListener(drawerToggle);

    String[] values = new String[]{"DEFAULT", "RED", "BLUE", "MATERIAL GREY"};
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, values);

    mDrawerList = (ListView) findViewById(R.id.navdrawer);
    mDrawerList.setAdapter(adapter);
    mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
          case 0:
            mDrawerList.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
            mToolbar.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
            slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
            mDrawerLayout.closeDrawer(Gravity.START);
            break;

          case 1:
            mDrawerList.setBackgroundColor(getResources().getColor(R.color.red));
            mToolbar.setBackgroundColor(getResources().getColor(R.color.red));
            slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.red));
            mDrawerLayout.closeDrawer(Gravity.START);
            break;

          case 2:
            mDrawerList.setBackgroundColor(getResources().getColor(R.color.blue));
            mToolbar.setBackgroundColor(getResources().getColor(R.color.blue));
            slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            mDrawerLayout.closeDrawer(Gravity.START);
            break;

          case 3:
            mDrawerList.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
            mToolbar.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
            slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
            mDrawerLayout.closeDrawer(Gravity.START);
            break;
        }
      }
    });
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (drawerToggle.onOptionsItemSelected(item)) {
      return true;
    }

    switch (item.getItemId()) {
      case android.R.id.home:
        mDrawerLayout.openDrawer(Gravity.START);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    drawerToggle.syncState();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    drawerToggle.onConfigurationChanged(newConfig);
  }
}
