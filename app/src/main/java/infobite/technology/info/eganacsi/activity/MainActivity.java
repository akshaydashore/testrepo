package infobite.technology.info.eganacsi.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import infobite.technology.info.eganacsi.R;
import infobite.technology.info.eganacsi.adapter.NavigationAdapter;
import infobite.technology.info.eganacsi.fragment.HomeFragment;
import infobite.technology.info.eganacsi.model.Navigation;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Context ctx;
    ListView listView;
    ImageView menu_iv;
    ArrayList<Navigation> nav_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initxml();
        setNavigation();
        setTitle("Hi Kamal,");
    }

    private void setNavigation() {

        nav_list = new ArrayList<>();

        nav_list.add(new Navigation(R.drawable.home, "Home"));
        nav_list.add(new Navigation(R.drawable.home, "Search Products"));
        nav_list.add(new Navigation(R.drawable.home, "Browse By Category"));
        nav_list.add(new Navigation(R.drawable.home, "Order Your Requirment"));
        nav_list.add(new Navigation(R.drawable.home, "My enquiries"));
        nav_list.add(new Navigation(R.drawable.home, "My Notification"));
        nav_list.add(new Navigation(R.drawable.home, "My Wishlist"));
        nav_list.add(new Navigation(R.drawable.home, "Sell on Eganacsi"));
        nav_list.add(new Navigation(R.drawable.home, "More"));

        setAdapter();
        listView.setOnItemClickListener(this);
        HomeFragment fragment = new HomeFragment(ctx);
        setFragment(fragment);
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_main_framelayout,fragment);
        fragmentTransaction.commit();
    }


    private void initxml() {
        ctx = this;
        listView = (ListView) findViewById(R.id.lv_nav_listview);
        menu_iv = (ImageView) findViewById(R.id.menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        menu_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position == 8) {
            // more
            String name = nav_list.get(position).getName();
            if (name.equals("More")) {
                nav_list.set(8, new Navigation(R.drawable.home, "Less"));
                nav_list.add(new Navigation(R.drawable.home, "Terms & Condition"));
                nav_list.add(new Navigation(R.drawable.home, "Privacy & Policy"));
                nav_list.add(new Navigation(R.drawable.home, "FAQs"));
                nav_list.add(new Navigation(R.drawable.home, "About US"));
                nav_list.add(new Navigation(R.drawable.home, "Feedback"));
                nav_list.add(new Navigation(R.drawable.home, "Share App"));
                nav_list.add(new Navigation(R.drawable.home, "Rate US"));
                setAdapter();
                listView.setSelection(15);
            }
            if (name.equals("Less")) {
                nav_list.set(8, new Navigation(R.drawable.home, "More"));
                nav_list.remove(15);
                nav_list.remove(14);
                nav_list.remove(13);
                nav_list.remove(12);
                nav_list.remove(11);
                nav_list.remove(10);
                nav_list.remove(9);
                setAdapter();
                listView.setSelection(8);
            }
        }
    }

    private void setAdapter() {

        NavigationAdapter adp_navigation = new NavigationAdapter(ctx, nav_list);
        listView.setAdapter(adp_navigation);
    }
}
