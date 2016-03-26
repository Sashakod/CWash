package com.example.cwash;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cwash.fragment.AccManagerFragment;
import com.example.cwash.fragment.ExitFragment;
import com.example.cwash.fragment.HistoryFragment;
import com.example.cwash.fragment.SettingsFragment;
import com.example.cwash.fragment.StaticsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int LAYOUT = R.layout.activity_main;
    FragmentTransaction fragmentTransaction;
    Fragment historyFragment;
    Fragment staticsFragment;
    Fragment accManagerFragment;
    Fragment settingsFragment;
    Fragment exitFragment;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        historyFragment = new HistoryFragment();
        staticsFragment = new StaticsFragment();
        accManagerFragment = new AccManagerFragment();
        settingsFragment = new SettingsFragment();
        exitFragment = new ExitFragment();

        showFragmentHisory();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 0 ){
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switch(item.getItemId()){
            case R.id.nav_history:
                fragmentTransaction.replace(R.id.fragment_container, historyFragment);
                getSupportActionBar().setTitle("Заказы");
                break;
            case R.id.nav_statistics:
                fragmentTransaction.replace(R.id.fragment_container, staticsFragment);
                getSupportActionBar().setTitle("Статистика");
                break;
            case R.id.nav_acc_manager:
                fragmentTransaction.replace(R.id.fragment_container, accManagerFragment);
                getSupportActionBar().setTitle("Управление аккаунтом");
                break;
            case R.id.nav_settings:
                fragmentTransaction.replace(R.id.fragment_container, settingsFragment);
                getSupportActionBar().setTitle("Настройки");
                break;
            case R.id.nav_exit:
                fragmentTransaction.replace(R.id.fragment_container, exitFragment);
                getSupportActionBar().setTitle("Выход");
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragmentHisory(){
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, historyFragment);
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Заказы");
    }

}
