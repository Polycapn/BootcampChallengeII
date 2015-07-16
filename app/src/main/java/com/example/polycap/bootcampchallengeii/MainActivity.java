package com.example.polycap.bootcampchallengeii;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.polycap.bootcampchallengeii.activity.FragmentDrawer;
import com.example.polycap.bootcampchallengeii.activity.FriendsFragment;
import com.example.polycap.bootcampchallengeii.activity.HomeFragment;
import com.example.polycap.bootcampchallengeii.activity.MessageFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    public RecyclerView mRecyclerView;
    public MainAdapter mAdapter;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // display the first navigation drawer view on app launch
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<list> lists = new ArrayList<list>();
        {
            lists.add(new list(
                    "Automated Farming System"));


            lists.add(new list(
                    "Project Sahara"));

            lists.add(new list(
                    "PolyOcracy"));


            lists.add(new list(
                    "Flying Exoskeleton Suit"));

            lists.add(new list(
                    "NanoHealth"));

            lists.add(new list(
                    "Civic Engagement App"));

            lists.add(new list(
                    "Poly.Inc"));

            lists.add(new list(
                    "Create Paradise"));

            mAdapter = new MainAdapter(this, lists);
            mRecyclerView.setAdapter(mAdapter);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void setActionBar(Toolbar mToolbar) {

    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() < 1) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }

    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);

    }

    private void displayView(int position) {
        android.support.v4.app.Fragment mfragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                mfragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                mfragment = new FriendsFragment();
                title = getString(R.string.title_friends);
                break;
            case 2:
                mfragment = new MessageFragment();
                title = getString(R.string.title_messages);
                break;
            default:
                break;
        }

        if (mfragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, mfragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }

    }


}
