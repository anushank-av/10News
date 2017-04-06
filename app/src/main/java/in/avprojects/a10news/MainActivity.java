package in.avprojects.a10news;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import in.avprojects.sunrisenews.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout categoryDrawer;
    NavigationView newsNav;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar  = (Toolbar)findViewById(R.id.toolbar);
        categoryDrawer = (DrawerLayout)findViewById(R.id.drawer_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,categoryDrawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        categoryDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        newsNav = (NavigationView)findViewById(R.id.nav_view);
        newsNav.setNavigationItemSelectedListener(this);
        Fragment fragment = NewsFragment.getFragmentInstance("Top news",0);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
        setTitle("Home");
    }

    @Override
    public void onBackPressed() {
        categoryDrawer = (DrawerLayout)findViewById(R.id.drawer_main);
        if (categoryDrawer.isDrawerOpen(GravityCompat.START)){
            categoryDrawer.closeDrawer(GravityCompat.START);
        }
        else super.onBackPressed();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int id = item.getItemId();
        try {
            switch (id) {
                case R.id.topNews:
                    fragment = NewsFragment.getFragmentInstance(String.valueOf(item.getTitle()),0);
                    break;
                case R.id.national:
                    fragment = NewsFragment.getFragmentInstance(String.valueOf(item.getTitle()),0);
                    break;
                case R.id.world:
                    fragment = NewsFragment.getFragmentInstance(String.valueOf(item.getTitle()),0);
                    break;
                case R.id.business:
                    fragment =NewsFragment.getFragmentInstance(String.valueOf(item.getTitle()),0);
                    break;
                case R.id.entertainment:
                    fragment = NewsFragment.getFragmentInstance(String.valueOf(item.getTitle()),0);
                    break;
                case R.id.technology:
                    fragment = NewsFragment.getFragmentInstance(String.valueOf(item.getTitle()),0);
                    break;
                default:
                    fragment = NewsFragment.getFragmentInstance("Top News",0);
            }
        }catch (Exception e){e.printStackTrace();}
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
        item.setChecked(true);
        setTitle(item.getTitle());
        categoryDrawer.closeDrawers();

        return true;
    }
}
