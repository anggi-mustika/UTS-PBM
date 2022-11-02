package com.example.kulineruts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class KulinerActivity extends AppCompatActivity {
    Button btn_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);
    }
    public void indonesia(View view) {
        String url = "https://blog.tiket.com/wisata-kuliner-indonesia/";
        Intent bukadrive = new Intent(Intent.ACTION_VIEW);
        bukadrive.setData(Uri.parse(url));
        startActivity(bukadrive);
    }

    public void amerika(View view) {
        String url = "https://www.tripadvisor.co.id/Attractions-g191-Activities-c42-t204-United_States.html";
        Intent bukadrive = new Intent(Intent.ACTION_VIEW);
        bukadrive.setData(Uri.parse(url));
        startActivity(bukadrive);
    }

    public void jepang(View view) {
        String url = "https://www.gotravelly.com/blog/10-tempat-berburu-jajanan-di-jepang/";
        Intent bukadrive = new Intent(Intent.ACTION_VIEW);
        bukadrive.setData(Uri.parse(url));
        startActivity(bukadrive);
    }

    public void saudi(View view) {
        String url = "https://tempatwisataunik.com/wisata-dunia/wisata-asia/arab-saudi/tempat-wisata-kuliner-mekkah";
        Intent bukadrive = new Intent(Intent.ACTION_VIEW);
        bukadrive.setData(Uri.parse(url));
        startActivity(bukadrive);
    }

    public void fragment(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, new TampilanFragment()).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);

        if (searchManager != null) {
            SearchView searchView = (SearchView)
                    (menu.findItem(R.id.search)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(KulinerActivity.this, query, Toast.LENGTH_SHORT).show();
                    searchView.clearFocus();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MenuFragment())
                    .addToBackStack(null)
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.menu2) {
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
            return true;
        } else {
            return true;
        }
    }

}