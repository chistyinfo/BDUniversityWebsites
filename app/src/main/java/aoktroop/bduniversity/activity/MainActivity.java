package aoktroop.bduniversity.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rzlts.appinbox.AppInbox;
import com.rzlts.appinbox.model.Gender;
import com.rzlts.appinbox.views.InboxView;

import oaktroop.bduniversity.R;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private NavigationView navigationView;
    private FloatingActionButton fabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        AppInbox.startInbox(this, "c1mkKqWWNaPSzE0e9GIHkgAyD0fvlslXZeosmJTmg2E", "89485377970", null, null, null, "Oak", "Troop", "oaktroop2015@gmail.com", Gender.MALE, 0);

        FrameLayout rlLayout = (FrameLayout) this.findViewById(R.id.rlLayout);
        final InboxView inbox = new InboxView(this);
        rlLayout.addView(inbox);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);


//        FloatingActionButton fabBtn = (FloatingActionButton) findViewById(R.id.fabBtn);
//
//        fabBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                finish();
//                System.exit(0);
//            }
//        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        if(id == R.id.action_search){
//            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new BduniversitywebsitesFragment();
                title = getString(R.string.title_home);
                break;

            case 1:
                fragment = new EngineeringFragment();
                title = getString(R.string.title_engin);
                break;
            case 2:
                fragment = new MedicalFragment();
                title = getString(R.string.title_medical);
                break;
            case 3:
                fragment = new PublicFragment();
                title = getString(R.string.title_public);
                break;
            case 4:
                fragment = new PrivateFragment();
                title = getString(R.string.title_private);
                break;
            case 5:
                fragment = new NationalFragment();
                title = getString(R.string.title_national);
                break;
            case 6:
                fragment = new InternationalFragment();
                title = getString(R.string.title_inter);
                break;
            case 7:
                fragment = new InternationalFragment();
                title = getString(R.string.title_developer);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_toolbar, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}