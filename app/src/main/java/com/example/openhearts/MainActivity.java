package com.example.openhearts;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    ViewPager viewPager;
    LayoutInflater layoutInflater;
    CustomSwipeAdapter customSwipeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // now we hve already removed action bar from main activity
        //As we wanted to add toolbar
        // so lets use the toolbar and make it our support actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView =( NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState== null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragmaent()).commit();
            navigationView.setCheckedItem(R.id.home);


        }

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.swipe_layout, container, false);

        viewPager=(ViewPager) view.findViewById(R.id.view_pager);
        customSwipeAdapter= new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);
        layoutInflater= (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View Itemview= layoutInflater.inflate(R.layout.swipe_layout ,viewPager,false);

        //viewPager.removeAllViews();
        //viewPager.removeView(Itemview);
        return  view;
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId())
        {
            case R.id.Account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AccountFragmaent()).commit();
                break;
            case R.id.helped_people:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new VideosFragmaent()).commit();
                break;
            case R.id.choose_lang:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new LanguageFragmaent()).commit();
                break;
            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AboutusFragmaent()).commit();
                break;
            case R.id.share:
                break;
            case R.id.likeus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new LikeusFragmaent()).commit();
                break;
            case R.id.logout:
                break;
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragmaent()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();



    }
}
