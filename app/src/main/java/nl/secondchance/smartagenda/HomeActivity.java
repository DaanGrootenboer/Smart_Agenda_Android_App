package nl.secondchance.smartagenda;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import nl.secondchance.smartagenda.Adapters.MyResPagerAdapter;
import nl.secondchance.smartagenda.Fragments.AlertDialogFragment;
import nl.secondchance.smartagenda.Models.Reservation;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Boolean login;
    private SharedPreferences sharedpreferences;

    @Bind(R.id.pager_my_res) ViewPager mPager;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.nav_view) NavigationView navigationView;
    private TextView mDisplayName;
    private TextView mEmail;
    private View header;

    private PagerAdapter mPagerAdapter;
    public ArrayList<Reservation> list = new ArrayList<Reservation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        sharedpreferences = getSharedPreferences(getString(R.string.preference_userdata_file_key), Context.MODE_PRIVATE);
        login = sharedpreferences.getBoolean(LoginActivity.TAG_LOGIN, false);

//        mDisplayName = (TextView) header.findViewById(R.id.nav_header_home_username);
//        mEmail = (TextView) header.findViewById(R.id.nav_header_home_email);
//
//        mDisplayName.setText(sharedpreferences.getString(LoginActivity.TAG_USERDATEVALUES[1], "No name"));
//        mEmail.setText(sharedpreferences.getString(LoginActivity.TAG_USERDATEVALUES[4], "No Mail"));

        if (!login) {
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity (intent);
            this.finishActivity (0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);

        // dummie data
        list.add(new Reservation("Kamer 21", "Vandaag", "Morgen", "1 uur", "2 uur", "presentatie"));
        list.add(new Reservation("Kamer 22", "Vandaag", "morgen", "1 uur", "2 uur", "presentatie"));
        //getUserData();

        mPagerAdapter = new MyResPagerAdapter(getApplicationContext(), list);
        mPager.setAdapter(mPagerAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_reservation) {
            Intent intent = new Intent(getApplicationContext(),ReservationActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
